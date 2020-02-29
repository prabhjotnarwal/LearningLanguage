package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class fruitActivity extends AppCompatActivity {
private Button banana,orange,apple,kiwi,stberry,mango,grapes,wtmelon;
private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        img = findViewById(R.id.cimage);
        banana = findViewById(R.id.ba);
        orange = findViewById(R.id.org);
        apple = findViewById(R.id.ap);
        kiwi = findViewById(R.id.ki);
        stberry = findViewById(R.id.st);
        mango = findViewById(R.id.man);
        grapes = findViewById(R.id.gr);
        wtmelon = findViewById(R.id.wm);
        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582929170716.mp3?alt=media&token=cb8423d9-0746-4ef0-96ab-940c1838bb88");
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
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582855435083.mp3?alt=media&token=56721a07-ba7e-47f8-b206-2331134f8ffa");
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
        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582929146841.mp3?alt=media&token=a92062c6-6934-4619-9d4d-754bf7b5f516");
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
        kiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582929196465.mp3?alt=media&token=bf2be08e-196a-4e02-babf-3465d0aec332");
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
        stberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582931156765.mp3?alt=media&token=ca11eca0-b9e3-4971-8184-9cc8b7fb114d");
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
        mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582929272827.mp3?alt=media&token=d78da0cf-8587-45ec-b7f9-9b198a52a52a");
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
        grapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582931115418.mp3?alt=media&token=100e83f1-4e76-4e8a-ad4c-21cf17a05756");
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
        wtmelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1582929309408.mp3?alt=media&token=dca5f7df-bd71-4830-82e9-eb692d88a242");
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
    }
}
