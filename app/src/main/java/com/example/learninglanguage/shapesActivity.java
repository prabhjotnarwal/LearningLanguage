package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class shapesActivity extends AppCompatActivity {
    private Button c,re,d,t,s,p,h,st,btn;
    private ImageView ima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);
        ima = findViewById(R.id.shape);
        c = findViewById(R.id.circle);
        d = findViewById(R.id.diamond);
        re = findViewById(R.id.rect);
        h= findViewById(R.id.heart);
        p = findViewById(R.id.pentagon);
        s = findViewById(R.id.square);
        t = findViewById(R.id.triangle);
        st = findViewById(R.id.star);
        btn=findViewById(R.id.tst);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161086852.mp3?alt=media&token=5d4dbba2-1be3-4b0b-bcdf-e5a3ad11925c");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161303218.mp3?alt=media&token=0300ab64-c37b-48b2-b792-0ba0fae9741f"
                    );
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161317443.mp3?alt=media&token=50d08624-3091-47cc-8f14-ff543be0f7e4");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161147005.mp3?alt=media&token=8f220c21-6c17-47dd-b255-d2c07754c555");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161283933.mp3?alt=media&token=fe5ddbda-3d9f-4522-9877-904e03a8fdd6"
                    );
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161210087.mp3?alt=media&token=4ce13b96-be0c-41dc-b8b9-3a2a2a64b791");
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161254717.mp3?alt=media&token=c51891ec-2b2f-4254-9d4a-904c9291c4c9"
                    );
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1584161230457.mp3?alt=media&token=dab082a5-5b8c-4bca-ad0f-ce68c9d9044b"
                    );
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mp.start();
                        }
                    });
                    mp.prepare();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mp.pause();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(shapesActivity.this, nothingToDisplay.class);
                startActivity(intent);
            }
        });
    }
}


