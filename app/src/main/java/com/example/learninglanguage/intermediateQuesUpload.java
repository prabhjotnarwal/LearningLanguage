package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class intermediateQuesUpload extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST=1;
private Button q,upl;
private ImageView qt;
private EditText op1,op2,op3,op4,ans1;
private ProgressBar mProgressBar;
private Uri mQueUri;
private StorageReference mStorageRef;
private DatabaseReference mDatabaseRef,ref;
private StorageTask mUploadTask;
    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_ques_intermediate);
        q = (Button) findViewById(R.id.quebtn);
        mProgressBar=findViewById(R.id.imgProgressBar);
        upl=findViewById(R.id.uploadImg);
        qt = findViewById(R.id.queimg);
        op1=findViewById(R.id.opt1);
        op2=findViewById(R.id.opt2);
        op3=findViewById(R.id.opt3);
        op4=findViewById(R.id.opt4);
        ans1=findViewById(R.id.ans);
        mStorageRef= FirebaseStorage.getInstance().getReference("ImgQues");
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("ImgQues");

        ref = FirebaseDatabase.getInstance().getReference("ImgQues");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    id = ds.getKey();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });
        upl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mUploadTask!=null && mUploadTask.isInProgress())
                {
                    Toast.makeText(intermediateQuesUpload.this,"Upload in progress",Toast.LENGTH_SHORT).show();
                }
                else {
                    uploadFile();
                }
            }
        });
    }
    private void openFileChooser(){
        Intent i=new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, PICK_IMAGE_REQUEST);
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            mQueUri=data.getData();
            Picasso.with(this).load(mQueUri).into(qt);
//           qt.setImageURI();
        }
    }
    private String getFileExtension(Uri uri)
    {
        ContentResolver cR=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return  mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadFile()
    {
        if(mQueUri!=null)
        {
            final StorageReference fileReference=mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mQueUri));
            mUploadTask=fileReference.putFile(mQueUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(0);
                        }
                    }, 600);
                    Toast.makeText(intermediateQuesUpload.this, "Uploaded successfully", Toast.LENGTH_LONG).show();
                    fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            int id1 = Integer.valueOf(id);
                            //int key = id1 + 1;
                            int key = 1;
                            String key1 = Integer.toString(key);
                            String str1 = op1.getText().toString();
                            String str2 = op2.getText().toString();
                            String str3 = op3.getText().toString();
                            String str4 = op4.getText().toString();
                            String str5 = ans1.getText().toString();
                            uploadImageQue uploadImageQue1 = new uploadImageQue(uri.toString(),str1,str2,str3,str4,str5);
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(key1).setValue(uploadImageQue1);
                            Toast.makeText(getApplicationContext(), "Uploaded Successfully", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(intermediateQuesUpload.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    mProgressBar.setProgress((int) progress);
                }
            });
        }
        else
        {
            Toast.makeText(this,"No File Selected", Toast.LENGTH_SHORT).show();
        }
    }
}
