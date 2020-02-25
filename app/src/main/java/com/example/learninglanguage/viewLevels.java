package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class viewLevels extends AppCompatActivity {
private RecyclerView lrc;
private ProgressBar progressBar1;

    private levelAdapter adapter;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private List<uploadLevel> lUpload=new ArrayList<>();
  ValueEventListener valueEventListener;
    boolean levelExists = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_levels);
        lrc=findViewById(R.id.levelRec);
        final ProgressBar progressBar1=findViewById(R.id.lprogressBar);
        lrc.setHasFixedSize(true);
        lrc.setLayoutManager(new LinearLayoutManager(this));
        lrc.setItemAnimator(new DefaultItemAnimator());
adapter=new levelAdapter(viewLevels.this,lUpload);
lrc.setAdapter(adapter);
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("level");
valueEventListener=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lUpload.clear();
                for (DataSnapshot dss : dataSnapshot.getChildren()) {
                    uploadLevel upLevel= dss.getValue(uploadLevel.class);
                    upLevel.setlKey(dss.getKey());
                    lUpload.add(upLevel);
//                    adapter = new levelAdapter(viewLevels.this, levelList, idList);
//                    lrc.setAdapter(adapter);
                }
                adapter.notifyDataSetChanged();
                progressBar1.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                levelExists=false;
            }

        });
}
protected void onDestroy()
{
    super.onDestroy();
    ref.removeEventListener(valueEventListener);
}


}
