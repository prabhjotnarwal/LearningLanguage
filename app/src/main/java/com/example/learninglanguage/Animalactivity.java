package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Animalactivity extends AppCompatActivity {
    private Button e,li,be,de,ti,ho,pan,d;
    private ImageView animal;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalactivity);
        animal = findViewById(R.id.A);
        e = findViewById(R.id.ele);
        li = findViewById(R.id.lion);
        be = findViewById(R.id.bear);
        d = findViewById(R.id.dog);
        de = findViewById(R.id.deer);
        ho = findViewById(R.id.horse);
        ti = findViewById(R.id.tiger);
        pan = findViewById(R.id.panda);
        btn  = findViewById(R.id.test);

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643142719.mp3?alt=media&token=02bad83d-9fb3-407d-8ea8-539070828fe1");
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
        li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643082707.mp3?alt=media&token=ddfa7b45-bf7f-45d8-9d9a-f3fc159d92ab");
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
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643123728.mp3?alt=media&token=0ce5005a-4eac-4bbe-baff-d0778e1c1764");
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
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643183065.mp3?alt=media&token=1fa014c4-a9f6-4bca-be20-b4f0d3ab1f54");
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
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643183065.mp3?alt=media&token=1fa014c4-a9f6-4bca-be20-b4f0d3ab1f54");
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
        ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643220783.mp3?alt=media&token=781cd02a-9618-45f7-85a6-a87d69ec0f22");
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
        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643201262.mp3?alt=media&token=cdada59e-6ba3-46b3-81da-7f6c4561fe37");
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
        pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final MediaPlayer mp = new MediaPlayer();
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/my-application1-db96a.appspot.com/o/songs%2F1583643100148.mp3?alt=media&token=74e80ac9-b3c0-4115-8429-1ee910aa4952");
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


