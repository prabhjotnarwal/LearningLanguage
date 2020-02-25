package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class admin_level extends AppCompatActivity {

    EditText edt1;
    Button btn;
    DatabaseReference db;
    List<Level> levelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_level);

        db = FirebaseDatabase.getInstance().getReference("level");

        edt1 = findViewById(R.id.edt1);
        btn = findViewById(R.id.btnsubmit);

        levelList = new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addLevel();

            }
        });
    }

    private void addLevel(){

        String name = edt1.getText().toString().trim();

        if (!TextUtils.isEmpty(name))
        {
            //To create id for data in database
            String id = db.push().getKey();

            uploadLevel lev = new uploadLevel(name);

            db.child(id).setValue(lev);

            edt1.setText("");

            Toast.makeText(this,"Level Added",Toast.LENGTH_LONG).show();
        }
        else{

            Toast.makeText(this, "Please enter Level name", Toast.LENGTH_LONG).show();
        }

    }
}
