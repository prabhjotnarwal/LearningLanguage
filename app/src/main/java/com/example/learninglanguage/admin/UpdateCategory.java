package com.example.learninglanguage.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learninglanguage.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class UpdateCategory extends AppCompatActivity {
    private FirebaseDatabase db;
    private DatabaseReference ref;
    Button upd, del;
    TextView Cname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_category);
        del = findViewById(R.id.cdelete);
        upd = findViewById(R.id.cupdate);
        Cname = findViewById(R.id.CNAme);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference("category");

        String jsonString = getIntent().getStringExtra("category");
        final String id = getIntent().getStringExtra("key");
        Gson gson = new Gson();
        uploadCategory category = gson.fromJson(jsonString, uploadCategory.class);

        final String  categoryName = getIntent().getStringExtra("categoryName");

       Cname.setText( categoryName);
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadCategory category1=new uploadCategory();
                category1.setCategoryName(Cname.getText().toString());
                updateCategory(id,category1);
                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_LONG).show();
                return;
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference childToDelete = ref.child(id);
                childToDelete.removeValue();
                Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_LONG).show();
                finish();
                return;

            }
        });

    }
    public void updateCategory(String id,uploadCategory uploadCategory){
        ref.child(id).setValue(uploadCategory).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });
    }
}
