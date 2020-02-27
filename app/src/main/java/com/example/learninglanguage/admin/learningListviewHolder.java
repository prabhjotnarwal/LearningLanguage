package com.example.learninglanguage.admin;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.learninglanguage.R;
public class learningListviewHolder extends RecyclerView.ViewHolder {
    ImageView learningImage;
    TextView name;
    RelativeLayout layout;

    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    public learningListviewHolder(@NonNull View itemView) {
        super(itemView);

        learningImage = itemView.findViewById(R.id.learningImage);
        name = itemView.findViewById(R.id.name);
        layout = itemView.findViewById(R.id.layout);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        String userid = firebaseAuth.getCurrentUser().getUid();
        ref = FirebaseDatabase.getInstance().getReference("News_User_Details").child(userid);

    }
}
