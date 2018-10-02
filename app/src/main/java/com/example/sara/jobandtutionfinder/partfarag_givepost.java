package com.example.sara.jobandtutionfinder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class partfarag_givepost extends AppCompatActivity {

    private EditText PostDescription;
    private Button UpdatePostButton;
    private DatabaseReference UsersRef, PostsRef;
    private FirebaseAuth mAuth;
    String Description;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;

    String saveCurrentDate, saveCurrentTime, postRandomName, current_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partfarag_givepost);

        PostDescription = findViewById(R.id.posttext);
        UpdatePostButton = findViewById(R.id.buttonpost);

        mAuth = FirebaseAuth.getInstance();
        current_user_id = mAuth.getCurrentUser().getUid();

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseStorage= FirebaseStorage.getInstance();

        UsersRef = firebaseDatabase.getReference(mAuth.getUid());
        PostsRef = FirebaseDatabase.getInstance().getReference().child("Part_Time_post").child("Posts");

        UpdatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidatePostInfo();
            }
        });

    }

    private void ValidatePostInfo() {

        Description = PostDescription.getText().toString();

        if(TextUtils.isEmpty(Description))
        {
            Toast.makeText(this, "Please say something about your image...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Please wait while new post is adding.....", Toast.LENGTH_SHORT).show();


            StoringImageToFirebaseStorage();
        }

    }

    private void StoringImageToFirebaseStorage()
    {
        Calendar calFordDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
        saveCurrentDate = currentDate.format(calFordDate.getTime());

        Calendar calFordTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
        saveCurrentTime = currentTime.format(calFordDate.getTime());



        postRandomName = saveCurrentDate + saveCurrentTime;

        SavingPostInformationToDatabase();

    }

    private void SavingPostInformationToDatabase()
    {
        UsersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User userProfile = dataSnapshot.getValue(User.class);

                String userFullName = userProfile.getName().toString().trim();
                String userProfileImage =userProfile.getImageUrl().toString().trim();

                HashMap postsMap = new HashMap();
                postsMap.put("uid", current_user_id);
                postsMap.put("date", saveCurrentDate);
                postsMap.put("time", saveCurrentTime);
                postsMap.put("description", Description);
                postsMap.put("name",userFullName);
                postsMap.put("imageUrl",userProfileImage);


                PostsRef.child(current_user_id + postRandomName).updateChildren(postsMap)
                        .addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task)
                            {
                                if(task.isSuccessful())
                                {
                                    Intent toy = new Intent(partfarag_givepost.this,MainActivity.class);
                                    startActivity(toy);

                                    Toast.makeText(partfarag_givepost.this,"Post is updated",Toast.LENGTH_SHORT).show();
                                }

                                else
                                {
                                    Toast.makeText(partfarag_givepost.this,"Post is not updated",Toast.LENGTH_SHORT).show();

                                }

                            }
                        });


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
    }
}
