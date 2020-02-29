package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class alphaLesson2 extends AppCompatActivity {
    private Button q1,w1,e1,r1,t1,y1,u1,i1,o1,p1,a1,s1,d1,f1,g1,h1,j1,k1,l1,z1,x1,c1,v1,b1,n1,m1,test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphalesson2);
        initializeUI();

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582402407837.mp3?alt=media&token=7c1c4ee4-89ae-4ad3-97bf-2aeb953f0763");
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
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582429123932.mp3?alt=media&token=dd583a08-1308-440c-a4a6-7d9fcd95b4f7");
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
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582429141322.mp3?alt=media&token=5b557311-225b-4aed-a617-de457761661a");
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
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430259011.mp3?alt=media&token=81678c8b-a716-4b9d-8a97-c59afbd5c1ef");
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
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430281540.mp3?alt=media&token=371b0b2d-43f7-4d14-a973-805cfe4467db");
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
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430297996.mp3?alt=media&token=a0763363-f037-42ba-b6cc-933ab3081ed0");
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
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430311787.mp3?alt=media&token=b0d25db8-4821-40e9-a52d-cbf1f8defe94");
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
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430329586.mp3?alt=media&token=3c9ffd72-b5e1-4c88-9239-d3bf099e9797");
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
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430441490.mp3?alt=media&token=67560abe-e8be-4ce9-9f24-ca0bb6ed9743");
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
        j1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430458097.mp3?alt=media&token=92e44d03-c0bc-4aad-a198-244b930d554d");
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
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430514697.mp3?alt=media&token=1aaad173-a485-44c1-9d12-845c82fd3f21");
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
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430532654.mp3?alt=media&token=e166110c-9dfb-43b5-9ebc-58c80e993f87");
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
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430546902.mp3?alt=media&token=48237c24-72ba-4914-be9f-e266dce02246");
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
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430563475.mp3?alt=media&token=8416daea-2b7f-4042-b9b4-f2427f39c568");
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
        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430596611.mp3?alt=media&token=bdea3704-6f5f-4727-9436-a0d2f49544f4");
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
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430611310.mp3?alt=media&token=fc5b73f6-1a16-41db-b078-854e04eef254");
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
        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582430627938.mp3?alt=media&token=37b74253-1119-405e-9992-5d629a1d6e0e");
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
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582777807259.mp3?alt=media&token=38e27a3e-75d4-48d1-9fda-24a10663adb9");
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
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582777824362.mp3?alt=media&token=889ad207-ca25-431d-851f-67fa6dddd0f4");
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
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582777845873.mp3?alt=media&token=fc55fee0-4240-48fc-bd05-fd17196a5104");
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
        u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582777865953.mp3?alt=media&token=6721310a-2358-42aa-b60f-74e550cc0d97");
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
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582777879058.mp3?alt=media&token=5fc44d36-9a85-49e4-85f1-d628d0f8032c");
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
        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582777892453.mp3?alt=media&token=129ca0a7-dc6f-4c63-a6e4-de744d027e27");
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
        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582778212320.mp3?alt=media&token=66b1b8fc-5513-42e9-8d59-9724f4fcc205");
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
        y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582778228579.mp3?alt=media&token=57de2f76-2b47-4282-8bcf-4882fad0c0ee");
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
        z1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp =new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582778243518.mp3?alt=media&token=38ff3b46-ee37-424d-9100-65eef6d7395b");
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
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(alphaLesson2.this,intermediate_test.class);
                startActivity(intent);
            }
        });
    }
    private void initializeUI() {
        test=findViewById(R.id.test2);
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
