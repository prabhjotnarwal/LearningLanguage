package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.google.gson.Gson;

public class basic_test extends AppCompatActivity {


    TextView quest;
    Button b1, b2, b3, b4, b5;
    int correct = 0;
    int total = 0;
    int wrong = 0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_test);
        b1 = (Button) findViewById(R.id.opta);
        b2 = (Button) findViewById(R.id.optb);
        b3 = (Button) findViewById(R.id.optc);
        b4 = (Button) findViewById(R.id.optd);

        quest = (TextView) findViewById(R.id.quesTxt);
        updateQuestion();
    }

    private void updateQuestion() {
        total++;
        if (total > 7) {
// result
            Intent i=new Intent(getApplicationContext(),testResult.class);
            startActivity(i);
        } else {
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
                                            b1.setBackgroundResource(R.drawable.testimg);
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
                                            b1.setBackgroundResource(R.drawable.testimg);
                                            b2.setBackgroundResource(R.drawable.btnimg1);
                                            b3.setBackgroundResource(R.drawable.btnimg1);
                                            b4.setBackgroundResource(R.drawable.testimg);
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
                                            b2.setBackgroundResource(R.drawable.btnimg1);
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
                                            b1.setBackgroundResource(R.drawable.testimg);
                                            b2.setBackgroundResource(R.drawable.btnimg1);
                                            b3.setBackgroundResource(R.drawable.btnimg1);
                                            b4.setBackgroundResource(R.drawable.testimg);
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
                                            b3.setBackgroundResource(R.drawable.btnimg1);
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
                                            b1.setBackgroundResource(R.drawable.testimg);
                                            b2.setBackgroundResource(R.drawable.btnimg1);
                                            b3.setBackgroundResource(R.drawable.btnimg1);
                                            b4.setBackgroundResource(R.drawable.testimg);
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
                                            b4.setBackgroundResource(R.drawable.testimg);
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
                                            b1.setBackgroundResource(R.drawable.testimg);
                                            b2.setBackgroundResource(R.drawable.btnimg1);
                                            b3.setBackgroundResource(R.drawable.btnimg1);
                                            b4.setBackgroundResource(R.drawable.testimg);
                                            updateQuestion();

                                        }
                                    }, 1500);

                                }
                            }


                        });

                    }
                }
                    @Override
                    public void onCancelled (@NonNull DatabaseError databaseError){

                    }

            });


        }
    }
    }





