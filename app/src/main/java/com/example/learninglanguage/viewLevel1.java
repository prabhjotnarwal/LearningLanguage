package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewLevel1 extends AppCompatActivity {
Button a,b,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_level1);
        a = findViewById(R.id.adv);
        b = findViewById(R.id.basic);
        i = findViewById(R.id.interm);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewLevel1.this, alphaLesson1.class);
                startActivity(intent);
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewLevel1.this, alphaLesson2.class);
                startActivity(intent);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewLevel1.this, AdvanceLevel.class);
                startActivity(intent);
            }
        });
    }
}
