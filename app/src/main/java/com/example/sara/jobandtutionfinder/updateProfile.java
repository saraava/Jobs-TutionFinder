package com.example.sara.jobandtutionfinder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class updateProfile extends AppCompatActivity {

    EditText userName,userlevel,userdept, userEmail, userid;
    Spinner genderspinner;
    Button updatebtn;
    FirebaseAuth firebaseAuth;
    ImageView userProfilePic;
    String email, name,dept,level,gender,stid;
    private static int PICK_IMAGE = 123;
    Uri imagePath;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    Context context;
    String currentid;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                userProfilePic.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        //setContentView(R.layout.activity_profile);

        context = this;

        userName = (EditText)findViewById(R.id.nametxt);
        userdept = findViewById(R.id.depttxt);
        userlevel = findViewById(R.id.leveltxt);
        updatebtn = findViewById(R.id.savebtn);
        userid = findViewById(R.id.stidtxt);
        userProfilePic = (ImageView)findViewById(R.id.ivProfile);

        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickImage = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                pickImage.addCategory(Intent.CATEGORY_OPENABLE);
                pickImage.setType("image/*");

                startActivityForResult(pickImage,PICK_IMAGE);
            }
        });



        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        storageReference = firebaseStorage.getReference();





        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatepro();
            }
        });





    }

    void updatepro() {

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("User").child(firebaseAuth.getUid());

        StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Pic");
        UploadTask uploadTask = imageReference.putFile(imagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(updateProfile.this, "Upload failed!", Toast.LENGTH_SHORT).show();
            }
        }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                Toast.makeText(updateProfile.this, "Upload successful!", Toast.LENGTH_SHORT).show();
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User userPro = dataSnapshot.getValue(User.class);
                gender = userPro.getGender();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        name = userName.getText().toString().trim();
        dept = userdept.getText().toString().trim();
        stid = userid.getText().toString().trim();
        level = userlevel.getText().toString().trim();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();




        User userProfile = new User(name,email,stid,dept,level,gender,imagePath.toString());
        myRef.setValue(userProfile);


    }
}
