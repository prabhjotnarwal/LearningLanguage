package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class levelActivity extends AppCompatActivity {
public Button ad,in,ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        ad=findViewById(R.id.button3);
        in=findViewById(R.id.button2);
        ba=findViewById(R.id.button);
        int value = getIntent().getExtras().getInt("position");

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(levelActivity.this,alphaLesson1.class);
                startActivity(intent);
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(levelActivity.this,alphaLesson2.class);
                startActivity(intent);
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(levelActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
