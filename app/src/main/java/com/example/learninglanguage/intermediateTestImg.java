package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class intermediateTestImg extends AppCompatActivity {
private ImageView img;
TextView timer;
Button b1, b2, b3, b4;
private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
   private DatabaseReference reference;
    private StorageReference mStorageRef;
    //private DatabaseReference first=reference.child("mImageUrl");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        img = findViewById(R.id.imgQue);
        b1 = (Button) findViewById(R.id.opti1);
        b2 = (Button) findViewById(R.id.opti2);
        b3 = (Button) findViewById(R.id.opti3);
        b4 = (Button) findViewById(R.id.opti4);
        timer = (TextView) findViewById(R.id.timertxt);
        reference=FirebaseDatabase.getInstance().getReference();
        Query query=reference.child("ImgQues");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String url = ds.child("mImageUrl").getValue().toString();
                    Picasso.with(intermediateTestImg.this).load(url).into(img);
                    final String answer = ds.child("ans").getValue().toString();
                    final String op1 = ds.child("op1").getValue().toString();
                    final String op2 = ds.child("op2").getValue().toString();
                    final String op3 = ds.child("op3").getValue().toString();
                    final String op4 = ds.child("op4").getValue().toString();
                    b1.setText(op1);
                    b2.setText(op2);
                    b3.setText(op3);
                    b4.setText(op4);
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}