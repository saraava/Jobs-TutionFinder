package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity implements View.OnClickListener{

    private EditText nametxt;
    private EditText stidtxt;
    private EditText emailtxt;
    private EditText passtxt;
    private EditText confpasstxt;
    private Button confirmbtn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nametxt = findViewById(R.id.editText);
        stidtxt = findViewById(R.id.editText2);
        emailtxt = findViewById(R.id.editText3);
        passtxt = findViewById(R.id.editText4);
        confpasstxt = findViewById(R.id.editText5);
        confirmbtn = findViewById(R.id.conf);
        progressBar = findViewById(R.id.progressBar2);

        progressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();

        confirmbtn.setOnClickListener(this);

    }
    private void registerUser() {
        final String name = nametxt.getText().toString().trim();
        final String email = emailtxt.getText().toString().trim();
        final String studentid = stidtxt.getText().toString().trim();
        String password = passtxt.getText().toString().trim();
        final String confpassword = confpasstxt.getText().toString().trim();

        if (name.isEmpty()) {
            nametxt.setError("Please type a name");
            nametxt.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            emailtxt.setError("Please type an email");
            emailtxt.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailtxt.setError("");
            emailtxt.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passtxt.setError("Please type a password");
            passtxt.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passtxt.setError("Password is too small,must be more than 6 characters");
            passtxt.requestFocus();
            return;
        }

        if (studentid.isEmpty()) {
            stidtxt.setError("please enter your Student ID");
            stidtxt.requestFocus();
            return;
        }
        if (confpassword.isEmpty()) {
            confpasstxt.setError("Confirm the password");
            confpasstxt.requestFocus();
            return;
        }



        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            User user = new User(
                                    name,
                                    email,
                                    studentid
                            );





                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        sendEmailVerification();
                                        Toast.makeText(register.this,"Registration Success", Toast.LENGTH_LONG).show();
                                        Intent toy = new Intent(register.this,login.class);

                                        startActivity(toy);
                                    } else {
                                        //display a failure message
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }






    @Override
    public void onClick(View view) {
        if(view == confirmbtn){
            String checkPass1 = passtxt.getText().toString().trim();
            String checkPass2 = confpasstxt.getText().toString().trim();
            if(checkPass1.contentEquals(checkPass2)){
                registerUser();
            }else{
                Toast.makeText(register.this,"Password didn't match",Toast.LENGTH_LONG).show();
            }

        }

    }

    private void sendEmailVerification() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(register.this, "Check your Email for verification", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                    }
                    else{
                        Toast.makeText(register.this,"Email is not correct",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
