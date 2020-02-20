package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.IOException;

public class alphaLesson1 extends AppCompatActivity {
private Button q1,w1,e1,r1,t1,y1,u1,i1,o1,p1,a1,s1,d1,f1,g1,h1,j1,k1,l1,z1,x1,c1,v1,b1,n1,m1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        initializeUI();
        final MediaPlayer mp = MediaPlayer.create(alphaLesson1.this, R.raw.ab);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();

                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
    }
    private void initializeUI() {
        a1=findViewById(R.id.a);
        b1=findViewById(R.id.b);
        c1=findViewById(R.id.c);
        d1=findViewById(R.id.d);
        e1=findViewById(R.id.e);
        f1=findViewById(R.id.f);
        g1=findViewById(R.id.g);
        h1=findViewById(R.id.h);
        i1=findViewById(R.id.i);
        j1=findViewById(R.id.j);
        k1=findViewById(R.id.k);
        l1=findViewById(R.id.l);
        m1=findViewById(R.id.m);
        n1=findViewById(R.id.n);
        o1=findViewById(R.id.o);
        p1=findViewById(R.id.p);
        q1=findViewById(R.id.q);
        r1=findViewById(R.id.r);
        s1=findViewById(R.id.s);
        t1=findViewById(R.id.t);
        u1=findViewById(R.id.u);
        v1=findViewById(R.id.v);
        w1=findViewById(R.id.w);
        x1=findViewById(R.id.x);
        y1=findViewById(R.id.y);
        z1=findViewById(R.id.z);

    }
}
