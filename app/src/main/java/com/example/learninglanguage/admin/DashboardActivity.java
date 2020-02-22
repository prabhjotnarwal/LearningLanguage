package com.example.learninglanguage.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learninglanguage.R;

public class DashboardActivity extends AppCompatActivity{

    Button b1,b2,b3;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_dashboard);
            b1=findViewById(R.id.cAdd);
            b2=findViewById(R.id.lAdd);
            b3=findViewById(R.id.tAdd);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DashboardActivity.this, addNewLessons.class);
                    startActivity(intent);
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DashboardActivity.this, addNewLessons.class);
                    startActivity(intent);
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DashboardActivity.this, addNewLessons.class);
                    startActivity(intent);
                }
            });
        }
        }
