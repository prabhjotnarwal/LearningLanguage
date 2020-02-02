package com.example.learninglanguage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class splashs extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2500;
    ProgressBar progressBar;
ImageView imageView;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splashs);
        progressBar=findViewById(R.id.progressBar);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(splashs.this, MainActivity.class);
                splashs.this.startActivity(mainIntent);
                splashs.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}