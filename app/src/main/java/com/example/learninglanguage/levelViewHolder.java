package com.example.learninglanguage;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class levelViewHolder extends RecyclerView.ViewHolder {
    TextView levelName;
    RelativeLayout layout;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    public levelViewHolder(@NonNull View itemView) {
        super(itemView);
        levelName = itemView.findViewById(R.id.lname);
        layout = itemView.findViewById(R.id.layout);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        String userid = firebaseAuth.getCurrentUser().getUid();
        ref = FirebaseDatabase.getInstance().getReference("News_User_Details").child(userid);
    }
}
