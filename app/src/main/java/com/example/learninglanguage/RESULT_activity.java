package com.example.learninglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learninglanguage.admin.categoryListActivity;

public class RESULT_activity extends AppCompatActivity {

    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        t1=(TextView)findViewById(R.id.textView13);
        t2=(TextView)findViewById(R.id.textView17);
        t3=(TextView)findViewById(R.id.textView15);
        t4= findViewById(R.id.result);

        Intent i= getIntent();

        String  questions= i.getStringExtra("total");
        String  correct= i.getStringExtra("correct");
        String  wrong= i.getStringExtra("incorrect");

        int qtotal = Integer.parseInt(correct) +  Integer.parseInt(wrong);

        int Result = (Integer.parseInt(correct) * 100) / Integer.parseInt(questions);

        //Toast.makeText(getApplicationContext(),Integer.toString(Result),Toast.LENGTH_LONG);
        if (Result >= 60)
        {
            t4.setText(Integer.toString(Result));
        }
        else
        {
            t4.setText(Integer.toString(Result));
        }

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(RESULT_activity.this, categoryListActivity.class);
        startActivity(intent);
    }
}
