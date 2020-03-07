package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class optToAddQuest extends AppCompatActivity {
Button ba,in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_to_add_quest);
        ba=findViewById(R.id.basicQues);
        in=findViewById(R.id.interQues);
        ba.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(optToAddQuest.this, Question.class);
                startActivity(intent);
            }
        });
        in.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(optToAddQuest.this, intermediateQuesUpload.class);
                startActivity(intent);
            }
        });
    }
}
