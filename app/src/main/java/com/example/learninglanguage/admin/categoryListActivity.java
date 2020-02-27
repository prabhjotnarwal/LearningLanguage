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

public class categoryListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private categoryListAdapter adapter;
    public static final String EXTRA_CATEGORY="categoryName";
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private List<uploadCategory> categoryList = new ArrayList<>();
    private List<String> idList = new ArrayList<>();
    boolean categoryExists = false;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        recyclerView = findViewById(R.id.crecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new categoryListAdapter(categoryListActivity.this, categoryList,idList);
        recyclerView.setAdapter(adapter);


        db = FirebaseDatabase.getInstance();
        ref = db.getReference("category");

        valueEventListener=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                categoryList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    uploadCategory category= ds.getValue(uploadCategory.class);
                    category.setcKey(ds.getKey());
                    categoryList.add(category);
                    idList.add(ds.getKey());

                } adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                categoryExists=false;
            }

        });
    }
    protected void onDestroy()
    {
        super.onDestroy();
        ref.removeEventListener(valueEventListener);
    }
}
