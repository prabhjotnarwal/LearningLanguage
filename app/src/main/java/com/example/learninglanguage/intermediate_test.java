package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learninglanguage.admin.upload_question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class intermediate_test extends AppCompatActivity {
    TextView quest,timer;
    Button b1, b2, b3, b4, b5;
    int correct = 0;
    int total = 6;
    int wrong = 0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intemediate_test);
        b1 = (Button) findViewById(R.id.opta1);
        b2 = (Button) findViewById(R.id.optb2);
        b3 = (Button) findViewById(R.id.optc3);
        b4 = (Button) findViewById(R.id.optd1);
        timer = (TextView) findViewById(R.id.timertxt);
        quest = (TextView) findViewById(R.id.quesTxt);
        updateQuestion();
        reverseTimer(200,timer);
    }

    private void updateQuestion() {
        total++;
        if (total == 14) {
            reverseTimer(0,timer);
        }
        else {
            reference = FirebaseDatabase.getInstance().getReference("Question").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        String ques = ds.child("question").getValue().toString();
                        final String answer = ds.child("answer").getValue().toString();
                        final String op1 = ds.child("option1").getValue().toString();
                        final String op2 = ds.child("option2").getValue().toString();
                        final String op3 = ds.child("option3").getValue().toString();
                        final String op4 = ds.child("option4").getValue().toString();
                        final upload_question question = dataSnapshot.getValue(upload_question.class);
                        quest.setText(ques);
                        b1.setText(op1);
                        b2.setText(op2);
                        b3.setText(op3);
                        b4.setText(op4);


                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b1.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b1.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b1.setBackgroundColor(Color.RED);

                                    if (b2.getText().toString().equals(answer)) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals((answer))) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals((answer))) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b2.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b2.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b2.setBackgroundColor(Color.RED);

                                    if (b1.getText().toString().equals(answer)) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(answer)) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(answer)) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });
                        b3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b3.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b3.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b3.setBackgroundColor(Color.RED);

                                    if (b2.getText().toString().equals(answer)) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b1.getText().toString().equals(answer)) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(answer)) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });
                        b4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b4.getText().toString().equals(answer)) {
                                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct = correct + 1;
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();
                                        }

                                    }, 1500);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                    wrong = wrong + 1;

                                    b4.setBackgroundColor(Color.RED);

                                    if (b2.getText().toString().equals(answer)) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(answer)) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b1.getText().toString().equals(answer)) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundResource(R.drawable.fly);
                                            b2.setBackgroundResource(R.drawable.fly);
                                            b3.setBackgroundResource(R.drawable.fly);
                                            b4.setBackgroundResource(R.drawable.fly);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });

        }
        }

        public void reverseTimer ( int seconds, final TextView tv)
        {
            new CountDownTimer(seconds * 1000 + 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int seconds = (int) (millisUntilFinished / 1000);
                    int minutes = seconds / 60;
                    seconds = seconds % 60;
                    tv.setText(String.format("%02d", minutes)
                            + ":" + String.format("%02d", seconds));

                }

                @Override
                public void onFinish() {
                    tv.setText("completed");
                    Intent myIntent = new Intent(intermediate_test.this, RESULT_activity.class);
                    //myIntent.putExtra("total", String.valueOf(total));
                    myIntent.putExtra("correct", String.valueOf(correct));
                    myIntent.putExtra("incorrect", String.valueOf(wrong));
                    startActivity(myIntent);

                }
            }.start();
        }
    }








