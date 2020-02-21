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
        int value = getIntent().getExtras().getInt("position");
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(levelActivity.this,MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
