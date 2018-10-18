package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changePass extends AppCompatActivity {
    private Button update;
    private EditText newPassword,confPassword;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    private ImageView toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        update=findViewById(R.id.button2);
        newPassword=findViewById(R.id.editText8);
        confPassword=findViewById(R.id.editText9);
        toogle=findViewById(R.id.toolic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        toogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(changePass.this,trysection.class);
                startActivity(in);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == update) {
                    String checkPass1 = newPassword.getText().toString().trim();
                    String checkPass2 = confPassword.getText().toString().trim();
                    if (checkPass1.contentEquals(checkPass2)) {
                        firebaseUser.updatePassword(checkPass1).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(changePass.this, "Password Changed", Toast.LENGTH_SHORT).show();

                                }
                            }

                        });

                    }else{
                        Toast.makeText(changePass.this, "Password Changed failed", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                }

            }

        });
    }
}
