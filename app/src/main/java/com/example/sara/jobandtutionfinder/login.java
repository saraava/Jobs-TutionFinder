package com.example.sara.jobandtutionfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private EditText emailtxt,passwordtxt;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    private Button loginbtn,registerbtn;
    private String email="",password="";
    private TextView forgetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailtxt = (EditText) findViewById(R.id.editText);
        passwordtxt = findViewById(R.id.passwordtxt);
        loginbtn = findViewById(R.id.Login);
        registerbtn = findViewById(R.id.register);
        forgetpass = findViewById(R.id.textView18);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(login.this, registersave.class);

                startActivity(toy);
            }
        });

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(login.this, forgetpassword.class);

                startActivity(toy);

            }
        });

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

    }


        void signIn () {
            email = emailtxt.getText().toString().trim();
            password = passwordtxt.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
                return;
            }
            progressDialog.setMessage("Please wait!!!!!");
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(login.this);
                                s.edit().putString("username",email).commit();
                                Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
                                finish();
                                Intent toy = new Intent(login.this,MainActivity.class);
                                startActivity(toy);

                            }
                            else{
                                Toast.makeText(login.this,"Auth failed",Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    });

        }

    }
