package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.learninglanguage.admin.upload_question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Question extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4,txt5;
    Button btn1;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    public String ques;
    List<String> li;
    Spinner sp1;


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

        li=new ArrayList<String>();

        li.add("Select Correct Answer");

        txt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                li.add(txt2.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                li.add(txt3.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txt4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                li.add(txt4.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txt5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                li.add(txt5.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        sp1=(Spinner) findViewById(R.id.answer);
        call();

        ref = FirebaseDatabase.getInstance().getReference("Question");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                   ques = ds.getKey();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ques1 = Integer.valueOf(ques);
                int key = ques1 + 1;
                String key1 = Integer.toString(key);
                String str1 = txt1.getText().toString();
                String str2 = txt2.getText().toString();
                String str3 = txt3.getText().toString();
                String str4 = txt4.getText().toString();
                String str5 = txt5.getText().toString();
                //String str6 = txt6.getText().toString();
                String answer = sp1.getSelectedItem().toString();
                upload_question que = new upload_question(str1, str2, str3, str4, str5, answer);

                ref.child(key1).push().setValue(que);

                Toast.makeText(getApplicationContext(), "Question Added", Toast.LENGTH_LONG).show();

                return;
            }
        });

    }

    public void call() {
// TODO Auto-generated method stub

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,li);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adp);
        sp1.setSelection((li.size()-1));


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
// TODO Auto-generated method stub
                //sp2.setSelection(arg2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
            }
        });
    }


}

