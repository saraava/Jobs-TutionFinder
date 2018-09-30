package com.example.sara.jobandtutionfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updateProfile extends AppCompatActivity {

    private EditText newUserName, newUserEmail, newUserAge;
    private Button save;

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        newUserName = findViewById(R.id.editText8);
        newUserEmail=findViewById(R.id.editText9);
        newUserAge = findViewById(R.id.editText10);
        save = findViewById(R.id.button5);



        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        // myRef = mFirebaseDatabase.getReference("user");
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBook();

            }

        });

    }
    private void updateBook() {

        myRef = mFirebaseDatabase.getReference("User").child(userID);

        // getting the value
        String name = newUserName.getText().toString().trim();
        String email = newUserEmail.getText().toString().trim();
        String id = newUserAge.getText().toString().trim();



        // creating the object
        //User boi = new User(name, email ,id);

       // myRef.setValue(boi);
        // set the value


       // Toast.makeText(this, "Book Info Updated!", Toast.LENGTH_SHORT).show();

    }
}
