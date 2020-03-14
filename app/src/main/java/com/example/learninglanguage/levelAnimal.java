package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class levelAnimal extends AppCompatActivity {
    Button anBa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_animal);
        anBa=findViewById(R.id.anbasic);

        anBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(levelAnimal.this, Animalactivity.class);
                startActivity(intent);
            }
        });
    }
}
