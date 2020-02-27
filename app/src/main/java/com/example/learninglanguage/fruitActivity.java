package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class fruitActivity extends AppCompatActivity {
private Button banana,orange,apple,kiwi,stberry,mango,grapes,wmelon;
private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        img = findViewById(R.id.cimage);
        banana = findViewById(R.id.ba);
        orange = findViewById(R.id.org);
        apple = findViewById(R.id.ap);
        kiwi = findViewById(R.id.ki);
        stberry = findViewById(R.id.st);
        mango = findViewById(R.id.man);
        grapes = findViewById(R.id.gr);
        wmelon = findViewById(R.id.wm);
    }
}
