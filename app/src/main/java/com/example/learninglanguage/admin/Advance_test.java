package com.example.learninglanguage.admin;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.OpenableColumns;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learninglanguage.R;
import com.example.learninglanguage.RESULT_activity;
import com.example.learninglanguage.uploadSong;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Advance_test extends AppCompatActivity {
    private ImageView img;
    EditText title;
    TextView txtv;
    ProgressBar progressBar;
    Uri audioUri;
    TextView timer;
    Button b1, b2, b3, b4;
    int correct = 0;
    int total = 6;
    int wrong = 0;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference reference;
    private StorageReference mStorageRef;
    StorageTask muploadtask;
    StorageReference mstorageref;
    DatabaseReference refSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_test);
        title= (EditText)findViewById(R.id.songtitle);
        txtv=findViewById(R.id.fileselected);
        progressBar=findViewById(R.id.progressBar2);
        refSongs= FirebaseDatabase.getInstance().getReference().child("songs");
        mstorageref= FirebaseStorage.getInstance().getReference().child("songs");
        img = findViewById(R.id.imgQue);
        b1 = (Button) findViewById(R.id.opti1);
        b2 = (Button) findViewById(R.id.opti2);
        b3 = (Button) findViewById(R.id.opti3);
        b4 = (Button) findViewById(R.id.opti4);
        timer = (TextView) findViewById(R.id.timertxt);
        updateQuestion();
        reverseTimer(200, timer);
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
    private void updateQuestion() {
        total++;
        if (total == 1) {
            reverseTimer(0,timer);
        }
        else {
            reference=FirebaseDatabase.getInstance().getReference();
            Query query=reference.child("ImgQues").child(String.valueOf(total));;

            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String url = ds.child("mImageUrl").getValue().toString();
                        Picasso.with(Advance_test.this).load(url).into(img);
                        final String answer = ds.child("ans").getValue().toString();
                        final String op1 = ds.child("op1").getValue().toString();
                        final String op2 = ds.child("op2").getValue().toString();
                        final String op3 = ds.child("op3").getValue().toString();
                        final String op4 = ds.child("op4").getValue().toString();
                        b1.setText(op1);
                        b2.setText(op2);
                        b3.setText(op3);
                        b4.setText(op4);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b1.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b1.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b1.setBackgroundColor(Color.RED);

                                    if (b2.getText().toString().equals(answer)) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals((answer))) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals((answer))) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b2.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b2.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b2.setBackgroundColor(Color.RED);

                                    if (b1.getText().toString().equals(answer)) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(answer)) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(answer)) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });
                        b3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b3.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b3.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b3.setBackgroundColor(Color.RED);

                                    if (b2.getText().toString().equals(answer)) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b1.getText().toString().equals(answer)) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(answer)) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });
                        b4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b4.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();
                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b4.setBackgroundColor(Color.RED);

                                    if (b2.getText().toString().equals(answer)) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(answer)) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b1.getText().toString().equals(answer)) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });

        }
    }

    public void reverseTimer ( int seconds, final TextView tv)
    {
        new CountDownTimer(seconds * 1000 + 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));

            }

            @Override
            public void onFinish() {
                tv.setText("completed");
                Intent myIntent = new Intent(Advance_test.this, RESULT_activity.class);
                //myIntent.putExtra("total", String.valueOf(total));
                myIntent.putExtra("correct", String.valueOf(correct));
                myIntent.putExtra("incorrect", String.valueOf(wrong));
                startActivity(myIntent);

            }
        }.start();
    }
}
