package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learninglanguage.admin.categoryListActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference ref;
    private String sess;
    private String uname,score;
    private Integer total = 0;
    private TextView txtScore,txtUname;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences prf;
        prf = getSharedPreferences("user_details",MODE_PRIVATE);

        btnReturn = findViewById(R.id.btnRetrun);

        sess =  prf.getString("username","");

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtUname = (TextView) findViewById(R.id.uname);

        Log.i(sess,": Session");

        db=FirebaseDatabase.getInstance();
        ref=db.getReference("Result");

        ref = FirebaseDatabase.getInstance().getReference("Result");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    long test = ds.getChildrenCount();
                    ResultAdapter post = ds.getValue(ResultAdapter.class);

                    uname = post.getUsername();

                    score = post.getScore();

                    if (uname.equals(sess))
                    {
                        total = total + Integer.parseInt(score);
                    }

//                    Log.i("Uname : ", post.getUsername());
//                    Log.i("Score : ", post.getScore());
//                    Log.i("Result : ", post.getResult());

                }
                System.out.println("TOTAL "+total);
                txtUname.setText("Hello! " + sess);
                txtScore.setText(String.valueOf(total));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, categoryListActivity.class);
                startActivity(intent);

            }
        });

    }
}
