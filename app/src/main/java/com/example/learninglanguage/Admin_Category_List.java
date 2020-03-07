package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.learninglanguage.admin.UpdateActivity;
import com.example.learninglanguage.admin.addNewCategory;
import com.example.learninglanguage.admin.categoryListActivity;
import com.example.learninglanguage.admin.categoryListAdapter;
import com.example.learninglanguage.admin.uploadCategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Admin_Category_List extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Admin_category_Adapter adapter;
    public static final String EXTRA_CATEGORY="categoryName";
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private List<uploadCategory> categoryList = new ArrayList<>();
    private List<String> idList = new ArrayList<>();
    boolean categoryExists = false;
    ValueEventListener valueEventListener;
    Button adnewc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__category__list);
        recyclerView = findViewById(R.id.adcrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new Admin_category_Adapter(Admin_Category_List.this, categoryList,idList);
        recyclerView.setAdapter(adapter);
        adnewc=findViewById(R.id.addnewc);

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
        adnewc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Category_List.this, addNewCategory.class);
                startActivity(intent);
            }
        });
    }
    protected void onDestroy()
    {
        super.onDestroy();
        ref.removeEventListener(valueEventListener);
    }
}
