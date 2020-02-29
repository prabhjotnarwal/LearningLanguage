package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class admin_level extends AppCompatActivity implements IFirebaseLoadDone {

    EditText edt1; //to Add level
    Button btn; //to Add level
    DatabaseReference db,categoryRef;
    List<Level> levelList; //to Add level
    SearchableSpinner searchableSpinner;
    IFirebaseLoadDone iFirebaseLoadDone;
    List<categorySpinnerAdapter> categorySpinnerAdapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_level);

        db = FirebaseDatabase.getInstance().getReference("level");

        edt1 = findViewById(R.id.edt1);
        btn = findViewById(R.id.btnsubmit);

        searchableSpinner = (SearchableSpinner)findViewById(R.id.searchable_spinner);
        categoryRef = FirebaseDatabase.getInstance().getReference("category");
        iFirebaseLoadDone = this;
        categoryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                List<categorySpinnerAdapter> catSpinnerList = new ArrayList<>();
                for (DataSnapshot categorySnapshot:dataSnapshot.getChildren())
                {

                    catSpinnerList.add(categorySnapshot.getValue(categorySpinnerAdapter.class));

                }
                iFirebaseLoadDone.onFirebaseLoadSuccess(catSpinnerList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                iFirebaseLoadDone.onFirebaseLoadFailed(databaseError.getMessage());

            }
        });

        levelList = new ArrayList<>();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addLevel();

            }
        });
    }

    @Override
    public void onFirebaseLoadSuccess(List<categorySpinnerAdapter> category) {

        categorySpinnerAdapters = category;

        List<String> name_list = new ArrayList<>();
        for (categorySpinnerAdapter categorySpinnerAdapters:category)
            name_list.add(categorySpinnerAdapters.getCategoryName());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,name_list);
        searchableSpinner.setAdapter(adapter);


    }

    @Override
    public void onFirebaseLoadFailed(String message) {

    }


    private void addLevel(){

        String name = edt1.getText().toString().trim();

        if (!TextUtils.isEmpty(name))
        {
            //To create id for data in database
            String id = db.push().getKey();

            uploadLevel lev = new uploadLevel(name);

            db.child(id).setValue(lev);

            edt1.setText("");

            Toast.makeText(this,"Level Added",Toast.LENGTH_LONG).show();
        }
        else{

            Toast.makeText(this, "Please enter Level name", Toast.LENGTH_LONG).show();
        }

    }

}
