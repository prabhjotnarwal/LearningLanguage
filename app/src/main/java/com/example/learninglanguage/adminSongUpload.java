package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class adminSongUpload extends AppCompatActivity {
EditText title;
TextView txtv;
ProgressBar progressBar;
Uri audioUri;
StorageReference mstorageref;
DatabaseReference refSongs;
StorageTask muploadtask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_song_upload);
        title= (EditText)findViewById(R.id.songtitle);
        txtv=findViewById(R.id.fileselected);
        progressBar=findViewById(R.id.progressBar2);
        refSongs= FirebaseDatabase.getInstance().getReference().child("songs");
        mstorageref= FirebaseStorage.getInstance().getReference().child("songs");

    }
    public void openAudioFile(View v)
    {
        Intent i=new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("audio/*");
        startActivityForResult(i,101);
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==101 && resultCode==RESULT_OK && data.getData()!=null)
        {
            audioUri=data.getData();
            String fileName=getFileName(audioUri);
            txtv.setText(fileName);
        }
    }

    private String getFileName(Uri audioUri) {
        String result=null;
        if(audioUri.getScheme().equals("content"))
        {
            Cursor cursor=getContentResolver().query(audioUri,null,null,null,null);
            try
            {
                if(cursor!=null && cursor.moveToFirst())
                {
                    result=cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }finally
            {
                cursor.close();
            }
        }
        if(result==null)
        {
            result=audioUri.getPath();
            int cut=result.lastIndexOf("/");
            if(cut!=-1)
            {
                result=result.substring(cut+1);
            }
        }
        return result;
    }
    public void uploadAudioToFirebase(View v)
    {
        if(txtv.getText().toString().equals("No File Selected"))
        {
            Toast.makeText(getApplicationContext(),"Please select a song",Toast.LENGTH_LONG).show();
        }
        else
        {
            uploadFile();
        }
    }

    private void uploadFile() {
        if(audioUri!=null)
        {
            String durationTxt;
            Toast.makeText(getApplicationContext(),"Uploading please wait....",Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.VISIBLE);
            final StorageReference storageReference=mstorageref.child(System.currentTimeMillis()+"."+getFileExtension(audioUri));
            int durationInMillis=findSongDuration(audioUri);
            if(durationInMillis==0)
            {
                durationTxt="NA";
            }

            durationTxt=getDurationFromMilli(durationInMillis);
            final String finalDurationTxt=durationTxt;
            muploadtask=storageReference.putFile(audioUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            uploadSong uploadSong=new uploadSong(title.getText().toString(),finalDurationTxt,uri.toString());
                            String uploadId=refSongs.push().getKey();
                            refSongs.child(uploadId).setValue(uploadSong);

                            Toast.makeText(getApplicationContext(),"Uploaded Successfully",Toast.LENGTH_LONG).show();
                            title.setText(" ");
                        }
                    });

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress=(100.0+taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressBar.setProgress((int)progress);
                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No File Selected to upload",Toast.LENGTH_LONG).show();
        }

    }

    private int findSongDuration(Uri audioUri) {
        int timeInMillisec=0;
        try
        {
            MediaMetadataRetriever retriever=new MediaMetadataRetriever();
            retriever.setDataSource(this,audioUri);
            String time=retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            timeInMillisec=Integer.parseInt(time);
            retriever.release();
            return timeInMillisec;
        }catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    private String getFileExtension(Uri audioUri) {
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(audioUri));
    }

    private String getDurationFromMilli(int durationInMillis)
    {
        Date date=new Date(durationInMillis);
        SimpleDateFormat simple=new SimpleDateFormat("mm:ss", Locale.getDefault());
        String myTime=simple.format(date);
        return myTime;
    }
}
