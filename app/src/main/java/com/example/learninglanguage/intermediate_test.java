package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class intermediate_test extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_test);
        b1=findViewById(R.id.sound);
        b2=findViewById(R.id.opta);
        b3=findViewById(R.id.optb);
        b4=findViewById(R.id.optc);
        b5=findViewById(R.id.optd);
        b6=findViewById(R.id.next);
    }
}
