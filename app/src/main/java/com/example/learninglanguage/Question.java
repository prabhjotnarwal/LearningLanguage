package com.example.learninglanguage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learninglanguage.admin.upload_question;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  Question extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4,txt5,txt6;
    Button btn1;
    private FirebaseDatabase db;
private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("Question");
        txt1 = findViewById(R.id.question);
        txt2 = findViewById(R.id.option1);
        txt3 = findViewById(R.id.option3);
        txt4 = findViewById(R.id.option2);
        txt5 = findViewById(R.id.option4);
        txt6 = findViewById(R.id.canswer);



        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = txt1.getText().toString();
                String str2 = txt2.getText().toString();
                String str3 = txt3.getText().toString();
                String str4 = txt4.getText().toString();
                String str5 = txt5.getText().toString();
                String str6 = txt6.getText().toString();
                upload_question que = new upload_question(str1, str2, str3, str4, str5, str6);

                ref.push().setValue(que);


                Toast.makeText(getApplicationContext(), "Question Added", Toast.LENGTH_LONG).show();

                return;
            }
        });

    }

}

