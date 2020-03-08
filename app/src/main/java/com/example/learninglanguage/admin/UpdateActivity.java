package com.example.learninglanguage.admin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learninglanguage.R;
import com.example.learninglanguage.uploadLevel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class UpdateActivity extends AppCompatActivity {
   private FirebaseDatabase db;
   private DatabaseReference ref;
    Button upd, del;
    TextView lname;


 @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
//        del = findViewById(R.id.delete);
//        upd = findViewById(R.id.update);
//
        lname = findViewById(R.id.name);
//
//
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("level");
        String jsonString = getIntent().getStringExtra("levelName");
        final String id = getIntent().getStringExtra("key");
        Gson gson = new Gson();
        uploadLevel uploadLevel = gson.fromJson(jsonString, uploadLevel.class);

        final String levelName = getIntent().getStringExtra("levelName");

        lname.setText(levelName);
//
//
//
//        upd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                learning learning=new learning();
//                learning.setLearningName(name.getText().toString());
//
//                learning.setLearningImagePath("https://thumbs.dreamstime.com/b/cute-little-female-doctor-cartoon-waving-hand-illustration-33233171.jpg");
//updateLearning(id,learning);
//                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_LONG).show();
//
//                return;
//            }
//        });
//        del.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatabaseReference childToDelete = ref.child(id);
//                childToDelete.removeValue();
//                Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_LONG).show();
//                finish();
//                return;
//
//            }
//        });
//
//    }
//    public void updateLearning(String id,learning learning){
//        ref.child(id).setValue(learning).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//            }
//        });
   }
}
