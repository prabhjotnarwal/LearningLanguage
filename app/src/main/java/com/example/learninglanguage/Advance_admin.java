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
        ref =db.getReference("video");
        addbtn=findViewById(R.id.aDDbtn);
        url=findViewById(R.id.addlink);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Upload_video uploadVideo = new Upload_video(url.getText().toString());
                ref.push().setValue(uploadVideo);
                Toast.makeText(getApplicationContext(),"Added successfully",Toast.LENGTH_LONG).show();
                url.setText("");

            }
        });

    }
}
