package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RESULT_activity extends AppCompatActivity {

    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        t1=(TextView)findViewById(R.id.textView11);
        t2=(TextView)findViewById(R.id.textView16);
        t3=(TextView)findViewById(R.id.textView14);


        Intent i= getIntent();

        //String  questions= i.getStringExtra("total");
        String  correct= i.getStringExtra("correct");
        String  wrong= i.getStringExtra("incorrect");



        t1.setText("5");
        t2.setText(correct);
        t3.setText(wrong);

    }
}
