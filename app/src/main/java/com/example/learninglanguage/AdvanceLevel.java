package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class AdvanceLevel extends AppCompatActivity {

    VideoView video;
    TextView url;
    ProgressDialog pd;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference reference = firebaseDatabase.getReference();
    private DatabaseReference childreference = reference.child("songLink");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_level);
        video = (VideoView) findViewById(R.id.video);
        pd = new ProgressDialog(AdvanceLevel.this);
        url = (TextView) findViewById(R.id.txt1);
        Toast.makeText(getApplicationContext(), url.toString(), Toast.LENGTH_LONG);
        pd.setMessage("Buffering please wait");
        pd.show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        childreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(message);
                video.setVideoURI(uri);
                video.start();
                video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        pd.dismiss();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
