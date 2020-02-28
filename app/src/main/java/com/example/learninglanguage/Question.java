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

public class Question extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4,txt5,txt6;
    Button btn1;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        txt1 = findViewById(R.id.question);
        txt2 = findViewById(R.id.option1);
        txt3 = findViewById(R.id.option3);
        txt4 = findViewById(R.id.option2);
        txt5 = findViewById(R.id.option4);
        txt6 = findViewById(R.id.canswer);

        String str1 = txt1.getText().toString();
        String str2 = txt2.getText().toString();
        String str3 = txt3.getText().toString();
        String str4 = txt4.getText().toString();
        String str5 = txt5.getText().toString();
        String str6 = txt6.getText().toString();

        db = FirebaseDatabase.getInstance().getReference("Question");

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addQuestion();
            }
        });

    }
    private void addQuestion(){

        String str1 = txt1.getText().toString();
        String str2 = txt2.getText().toString();
        String str3 = txt3.getText().toString();
        String str4 = txt4.getText().toString();
        String str5 = txt5.getText().toString();
        String str6 = txt6.getText().toString();

        if (!TextUtils.isEmpty(str1)) {
            //To create id for data in database
            String id = db.push().getKey();

            upload_question lev = new uploadLevel(id, str1);

            db.child(id).setValue(lev);

            txt1.setText("");

            Toast.makeText(this, "Question Added", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Please enter Question", Toast.LENGTH_LONG).show();
        }
        if (!TextUtils.isEmpty(str2)) {
            //To create id for data in database
            String id = db.push().getKey();

            uploadLevel lev = new uploadLevel(id, str2);

            db.child(id).setValue(lev);

            txt2.setText("");

            Toast.makeText(this, "Option1 Added", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Please enter Option1", Toast.LENGTH_LONG).show();
        }
        if (!TextUtils.isEmpty(str3)) {
            //To create id for data in database
            String id = db.push().getKey();

            uploadLevel lev = new uploadLevel(id, str3);

            db.child(id).setValue(lev);

            txt3.setText("");

            Toast.makeText(this, "Option2 Added", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Please enter Option2", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(str4)) {
            //To create id for data in database
            String id = db.push().getKey();

            uploadLevel lev = new uploadLevel(id, str4);

            db.child(id).setValue(lev);

            txt4.setText("");

            Toast.makeText(this, "Option3 Added", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Please enter Option3", Toast.LENGTH_LONG).show();
        }
        if (!TextUtils.isEmpty(str5)) {
            //To create id for data in database
            String id = db.push().getKey();

            uploadLevel lev = new uploadLevel(id, str5);

            db.child(id).setValue(lev);

            txt5.setText("");

            Toast.makeText(this, "Option4 Added", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Please enter Option4", Toast.LENGTH_LONG).show();
        }
        if (!TextUtils.isEmpty(str6)) {
            //To create id for data in database
            String id = db.push().getKey();

            uploadLevel lev = new uploadLevel(id, str6);

            db.child(id).setValue(lev);

            txt6.setText("");

            Toast.makeText(this, "Answer Added", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Please enter Answer", Toast.LENGTH_LONG).show();
        }
    }
}

