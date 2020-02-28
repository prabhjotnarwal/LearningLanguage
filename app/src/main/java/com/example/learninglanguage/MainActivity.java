package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.learninglanguage.viewLevels.EXTRA_LEVEL;

public class MainActivity extends AppCompatActivity {

    Button rBtn, lBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
        lBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    public void logOut() {
        FirebaseAuth.getInstance().signOut();
        Intent i=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);

    }
    private void initializeViews() {
        rBtn = findViewById(R.id.register);
        lBtn = findViewById(R.id.login);
    }
}