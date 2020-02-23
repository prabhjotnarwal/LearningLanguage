package com.example.learninglanguage.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learninglanguage.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addNewCategory extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference ref;
    TextView name;
    Button add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("category");

        add = findViewById(R.id.add);
        name=findViewById(R.id.name);





        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name1;


                name1 = name.getText().toString();
                uploadCategory uploadCategory1 = new uploadCategory(name1);
                ref.push().setValue(uploadCategory1);
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
                name.setText(" ");
                return;


            }
        });
    }
}
