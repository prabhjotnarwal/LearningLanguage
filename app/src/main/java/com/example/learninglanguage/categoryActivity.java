package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class categoryActivity extends AppCompatActivity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        lv = findViewById(R.id.listview1);
        String[] mobileArray = {"Alphabets","Numbers", "Fruit", "Vegetable", "Body Part Names","Shape","Toy","Transport","Bird","Animal"};
        int flags[] = {R.drawable.abc, R.drawable.numbers, R.drawable.fruits, R.drawable.veg,R.drawable.body,R.drawable.shape,R.drawable.toys,R.drawable.transport,R.drawable.bird,R.drawable.animals};

        categoryAdapter customAdapter = new categoryAdapter(getApplicationContext(), mobileArray, flags);
        lv.setAdapter(customAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Intent intent = new Intent(categoryActivity.this,levelActivity.class);
                        intent.putExtra("position",position);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
