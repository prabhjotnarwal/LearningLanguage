package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class adminDashboard extends AppCompatActivity {
Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        b1=findViewById(R.id.cAdd);
        b2=findViewById(R.id.lAdd);
        b3=findViewById(R.id.tAdd);
    }
}
