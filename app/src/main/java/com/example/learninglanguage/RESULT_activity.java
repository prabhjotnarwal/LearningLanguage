package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import com.example.learninglanguage.admin.categoryListActivity;
import com.example.learninglanguage.ResultAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_LONG;

public class RESULT_activity extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference ref;
    TextView t1,t2,t3,t4;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        db= FirebaseDatabase.getInstance();
        ref=db.getReference("Result");

        SharedPreferences prf;
        prf = getSharedPreferences("user_details",MODE_PRIVATE);

        String sess =  prf.getString("username","");

        Toast.makeText(getApplicationContext(),sess,LENGTH_LONG);

        Log.i("Session ",sess);

        t1=(TextView)findViewById(R.id.textView13);
        t2=(TextView)findViewById(R.id.textView17);
        t3=(TextView)findViewById(R.id.textView15);
        t4= findViewById(R.id.result);

        btn1 = findViewById(R.id.btnprofile);

        Intent i= getIntent();

        String  questions= i.getStringExtra("total");
        String  correct= i.getStringExtra("correct");
        String  wrong= i.getStringExtra("incorrect");

        int qtotal = Integer.parseInt(correct) +  Integer.parseInt(wrong);

        int Result = (Integer.parseInt(correct) * 100) / qtotal;

        if (Result >= 60)
        {
            t4.setText("You have Passed this test with " + (Result) + "%");
            t4.setTextColor(Color.GREEN);
        }
        else
        {
            t4.setText("Sorry, You Failed this test ");
            t4.setTextColor(Color.RED);
        }

        ResultAdapter que = new ResultAdapter(sess, Integer.toString(Result), correct);

        ref.push().setValue(que); //To save data into DB

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RESULT_activity.this,Profile.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(RESULT_activity.this, categoryListActivity.class);
        startActivity(intent);
    }
}
