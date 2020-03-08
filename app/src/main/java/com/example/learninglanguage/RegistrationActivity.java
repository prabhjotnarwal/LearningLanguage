package com.example.learninglanguage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learninglanguage.admin.categoryListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailTV, passwordTV,cpassTV;
    private Button regBtn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                progressBar.setVisibility(View.VISIBLE);
                String email, password,cpass;
                email = emailTV.getText().toString();
                password = passwordTV.getText().toString();
                cpass=cpassTV.getText().toString();
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Your password must have at least 6 characters", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                if (!password.equals(cpass)) {
                    Toast.makeText(getApplicationContext(), "Both password fields must be identical ", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)||TextUtils.isEmpty(cpass)) {
                    Toast.makeText(getApplicationContext(), "Please fill the details", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                } else{
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegistrationActivity.this, categoryListActivity.class);
                                startActivity(intent);
                                finish();
                                progressBar.setVisibility(View.GONE);
                            }else {
                                Toast.makeText(getApplicationContext(), "Failed to Register\nError Desc: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });

                }
            }
        });
    }



    private void initializeUI() {
        emailTV = findViewById(R.id.email);
        passwordTV = findViewById(R.id.password);
        cpassTV=findViewById(R.id.cpass);
        regBtn = findViewById(R.id.register);
        progressBar = findViewById(R.id.progressBar);
    }
}
