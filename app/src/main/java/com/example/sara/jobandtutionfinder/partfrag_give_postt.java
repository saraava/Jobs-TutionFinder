package com.example.sara.jobandtutionfinder;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class partfrag_give_postt extends AppCompatActivity {

    private Button UpdatePostButton;
    private EditText PostDescription;


    String Description, getpostkey;


    private StorageReference PostsImagesRefrence;
    private DatabaseReference UsersRef, PostsRef;
    private FirebaseAuth mAuth;

    String namee, imagee, userFullName, userProfileImage,studentidd;


    private String saveCurrentDate, saveCurrentTime, postRandomName, downloadUrl, current_user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partfrag_give_postt);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        current_user_id = user.getUid();



        UsersRef = FirebaseDatabase.getInstance().getReference("User");
        PostsRef = FirebaseDatabase.getInstance().getReference("Part_Time_Job").child("Posts");


        UpdatePostButton = (Button) findViewById(R.id.btntxt);
        PostDescription = (EditText) findViewById(R.id.postttxt);

        UpdatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidatePostInfo();
            }
        });


    }

    private void ValidatePostInfo() {
        Description = PostDescription.getText().toString();

        if (TextUtils.isEmpty(Description)) {
            Toast.makeText(this, "Please say something about your image...", Toast.LENGTH_SHORT).show();
        } else {


            StoringImageToFirebaseStorage();
        }
    }

    void StoringImageToFirebaseStorage() {

        Calendar calFordDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
        saveCurrentDate = currentDate.format(calFordDate.getTime());

        Calendar calFordTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
        saveCurrentTime = currentTime.format(calFordDate.getTime());

        postRandomName = saveCurrentDate + saveCurrentTime;
        getpostkey = current_user_id + postRandomName;

        SavingPostInformationToDatabase();
    }

    void SavingPostInformationToDatabase() {
        UsersRef.child(current_user_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User userProfile = dataSnapshot.getValue(User.class);

                userFullName = userProfile.getName().toString().trim();
                userProfileImage = userProfile.getImageUrl().toString().trim();
                studentidd=userProfile.getStudentid().toString().trim();


                post p = new post(current_user_id, saveCurrentTime, saveCurrentDate, Description, userProfileImage, userFullName,getpostkey,studentidd);
                PostsRef.child(getpostkey).setValue(p);

                Intent intent = new Intent(partfrag_give_postt.this,MainActivity.class);
                startActivity(intent);
                //Toast.makeText(partfrag_give_postt.this,getpostkey,Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }

        });


    }

}



