package com.example.sara.jobandtutionfinder;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registersave extends AppCompatActivity {

    EditText sname,spass,confpass;
    Button save;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    String password,email;
    ProgressBar progressBar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registersave);

        sname = findViewById(R.id.utxt);
        spass = findViewById(R.id.pass);
        save = findViewById(R.id.reg);
        confpass = findViewById(R.id.editText4);
        progressBar = findViewById(R.id.progressBar);
        context = this;

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressBar.setVisibility(View.GONE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checkPass1 = spass.getText().toString().trim();
                String checkPass2 = confpass.getText().toString().trim();
                if(checkPass1.contentEquals(checkPass2)){
                    sign_in();
                }else{
                    AppConstant.showAlertMessage(context,"Password didn't match");
                    return;

                }
            }
        });

    }

    void sign_in(){

        email = sname.getText().toString().trim();
        password = spass.getText().toString().trim();

        //validation
        if (TextUtils.isEmpty(email)){
            AppConstant.showAlertMessage(context,"Enter an Email");
            return;
        }

        if (TextUtils.isEmpty(password)){
            AppConstant.showAlertMessage(context,"Enter Password");
            return;

        }

        if (password.length() <= 6){
            AppConstant.showAlertMessage(context,"Password legnth should be more than 6 characters");
            return;
        }


        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //sendEmailVerification();

                            Toast.makeText(registersave.this,"Registration successfull",Toast.LENGTH_SHORT).show();
                            Intent toy = new Intent(registersave.this,register.class);
                            startActivity(toy);

                        } else {

                            Toast.makeText(registersave.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });




    }



}
