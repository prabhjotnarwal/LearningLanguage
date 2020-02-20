package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class alphaLesson1 extends AppCompatActivity {
private Button q1,w1,e1,r1,t1,y1,u1,i1,o1,p1,a1,s1,d1,f1,g1,h1,j1,k1,l1,z1,x1,c1,v1,b1,n1,m1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        initializeUI();

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/a.mpeg?alt=media&token=efe5c258-9ade-4c77-af26-fea4d46b2bc8");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/b.mpeg?alt=media&token=04e3496d-9df7-45c7-8231-99fb1ae2a600");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/c.mpeg?alt=media&token=d030200c-f13d-4544-b663-7932d80ef0b8");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/d.mpeg?alt=media&token=6ff6a826-3c11-4078-aae7-e5140560c766");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/e.mpeg?alt=media&token=d2945966-565f-4a9f-ab32-3f1ee637e1e4");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/f.mpeg?alt=media&token=c81f40d2-05e0-47b5-85d2-a9a325377a71");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
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
