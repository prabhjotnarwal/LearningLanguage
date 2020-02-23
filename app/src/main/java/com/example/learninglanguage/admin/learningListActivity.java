package com.example.learninglanguage.admin;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learninglanguage.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class learningListActivity  extends AppCompatActivity {
    private RecyclerView recyclerView;
    private learningListAdapter adapter;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private List<learning> learninglist = new ArrayList<>();
    private List<String> idList = new ArrayList<>();
    boolean learningExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_list);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        db = FirebaseDatabase.getInstance();
        ref = db.getReference("learning");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    learning learning= ds.getValue(learning.class);
                    learninglist.add(learning);
                    idList.add(ds.getKey());
                    adapter = new learningListAdapter(learningListActivity.this, learninglist, idList);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(learningListActivity.this, "There was some problem. Please try again later....", Toast.LENGTH_SHORT).show();
                learningExists=false;
            }

        });
    }
}
