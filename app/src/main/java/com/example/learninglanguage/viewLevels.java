package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class viewLevels extends AppCompatActivity {
private RecyclerView lrc;
private ProgressBar progressBar1;

    private levelAdapter adapter;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private List<uploadLevel> levelList = new ArrayList<>();
    private List<String> idList = new ArrayList<>();
    boolean levelExists = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_levels);
        lrc=findViewById(R.id.levelRec);
        ProgressBar progressBar1=findViewById(R.id.lprogressBar);
        lrc.setLayoutManager(new LinearLayoutManager(this));
        lrc.setItemAnimator(new DefaultItemAnimator());

        db = FirebaseDatabase.getInstance();
        ref = db.getReference("level");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    uploadLevel upLevel= ds.getValue(uploadLevel.class);
                    levelList.add(upLevel);
                    idList.add(ds.getKey());
                    adapter = new levelAdapter(viewLevels.this, levelList, idList);
                    lrc.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(viewLevels.this, "There was some problem. Please try again later....", Toast.LENGTH_SHORT).show();
                levelExists=false;
            }

        });
}
}
