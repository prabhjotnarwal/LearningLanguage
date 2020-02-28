package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.learninglanguage.admin.addNewCategory;

public class adminDashboard extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        lv = findViewById(R.id.lv1);
        String[] mobileArray = {"Manage Category","Manage Level", "Add Videos", "Add Audios", "Manage Tests"};
        int flags[] = {R.drawable.admin_manage_category, R.drawable.admin_manage_levels, R.drawable.admin_add_video, R.drawable.admin_add_audio,R.drawable.admin_manage_tests};


        AdminDashboardAdapter customAdapter = new AdminDashboardAdapter(getApplicationContext(), mobileArray,flags);
        lv.setAdapter(customAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {

                        if (position == 0)
                        {
                            Intent intent = new Intent(adminDashboard.this, addNewCategory.class);
                            intent.putExtra("position",position);
                            startActivity(intent);
                        }
                        if (position == 1)
                        {
                            Intent intent = new Intent(adminDashboard.this, admin_level.class);
                            intent.putExtra("position",position);
                            startActivity(intent);
                        }
                        if (position == 2)
                        {
                            Intent intent = new Intent(adminDashboard.this, Advance_admin.class);
                            intent.putExtra("position",position);
                            startActivity(intent);
                        }
                        if (position == 3)
                        {
                            Intent intent = new Intent(adminDashboard.this, adminSongUpload.class);
                            intent.putExtra("position",position);
                            startActivity(intent);
                        }
                        if (position == 4)
                        {
                            Intent intent = new Intent(adminDashboard.this, AddTest.class);
                            intent.putExtra("position",position);
                            startActivity(intent);
                        }

                    }
                });
            }
        });



    }
}
