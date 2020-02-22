package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Advance_admin extends AppCompatActivity {
private FirebaseDatabase db;
private DatabaseReference ref;
EditText url;
Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_admin_1);
        db=FirebaseDatabase.getInstance();
        ref =db.getReference("url");
        addbtn=findViewById(R.id.aDDbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final  String url1 ;
                url1 =url.getText().toString();
                Upload_video uploadVideo = new Upload_video(url1);
                ref.push().setValue(uploadVideo);
                Toast.makeText(getApplicationContext(),"Added successfully",Toast.LENGTH_LONG).show();
                url.setText("");

            }
        });

    }
}
