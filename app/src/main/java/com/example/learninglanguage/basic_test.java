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

public class basic_test extends AppCompatActivity {


    TextView Question;
    Button b1,b2,b3,b4,b5;
    int correct=0;
    int total=0;
    int wrong=0;
    int computercount=0;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_test);

        b1=(Button)findViewById(R.id.opta);
        b2=(Button)findViewById(R.id.optb);
        b3=(Button)findViewById(R.id.optc);
        b4=(Button)findViewById(R.id.optd);
        b5=(Button)findViewById(R.id.next);
        Question=(TextView)findViewById(R.id.textView);

    }
    public void updateQuestion()
    {
        computercount++;

        if(computercount>10)
        {
            Toast.makeText(getApplicationContext(),"Test Over",Toast.LENGTH_LONG).show();
            Intent myintent= new Intent(basic_test.this,testResult.class);
            myintent.putExtra("total",String.valueOf(total));
            myintent.putExtra("correct",String.valueOf(correct));
            myintent.putExtra("incorrect",String.valueOf(wrong));
            startActivity(myintent);

        }
        else
        {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(computercount));
            total++;
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    final upload_question question = dataSnapshot.getValue(upload_question.class);
                    Question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b1.getText().toString().equals(question.answer)) {
                                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                b1.setBackgroundColor(Color.GREEN);
                                correct = correct + 1;
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            } else {
                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong = wrong + 1;

                                b1.setBackgroundColor(Color.RED);


                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();

                                handler.postDelayed(delay,1500);


                            }
                        }


                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b2.getText().toString().equals(question.answer))
                            {
                                correct = correct+1;
                                Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 2000);

                            }
                            else{

                                wrong++;
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();

                                b2.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#O3A9FA"));
                                        b3.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        updateQuestion();

                                    }
                                },1500);


                            }
                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b3.getText().toString().equals(question.answer))
                            {
                                correct++;
                                Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();

                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b3.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        updateQuestion();
                                    }
                                },2000);
                            }
                            else
                            {
                                wrong++;
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();

                                b3.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler= new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#O3A9F4"));

                                    }
                                }, 1500);
                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b4.getText().toString().equals(question.answer)) {
                                correct++;
                                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b4.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        updateQuestion();
                                    }
                                }, 2000);
                            } else {
                                wrong++;
                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                b4.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#O3A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#O3A9F4"));

                                    }
                                },1500);
                            }
                        }



                    } );

                }

                private Runnable delay = new Runnable() {
                    @Override
                    public void run() {

                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                        b2.setBackgroundColor(Color.parseColor("#03A9f4"));
                        b3.setBackgroundColor(Color.parseColor("03A9f4"));
                        b4.setBackgroundColor(Color.parseColor("#03A9f4"));
                        updateQuestion();

                    }
                };




                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
}

