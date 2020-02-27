package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class levelActivity extends AppCompatActivity {

//    public Button ad,in,ba;

    private ListView lv1;
    private FirebaseDatabase database;
    private DatabaseReference dbRef;
    private ArrayList<String> level = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
//        ad=findViewById(R.id.button3);
//        ba=findViewById(R.id.button);
//        in=findViewById(R.id.button2);
        lv1 = findViewById(R.id.lv1);

        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference("level/levelName");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,level);
        lv1.setAdapter(arrayAdapter);

        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String value = dataSnapshot.getValue(String.class);
                level.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // int value = getIntent().getExtras().getInt("position");
//        ba.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(levelActivity.this,alphaLesson1.class);
//
//                startActivity(intent);
//            }
//        });
//        in.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(levelActivity.this,alphaLesson2.class);
//
//                startActivity(intent);
//            }
//        });
//        ad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(levelActivity.this,AdvanceLevel.class);
//
//                startActivity(intent);
//            }
//        });
    }
}
