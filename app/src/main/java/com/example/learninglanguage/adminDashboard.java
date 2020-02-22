package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class adminDashboard extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        b1=findViewById(R.id.cAdd);
        b2=findViewById(R.id.lAdd);
        b3=findViewById(R.id.tAdd);
        b4 = findViewById(R.id.leAdd);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(adminDashboard.this,admin_level.class);
                startActivity(intent);

            }
        });
    }
}
