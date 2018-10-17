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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class register extends AppCompatActivity{

    private EditText userName,userdept, userid;
    Spinner genderspinner,levelspinner;
    private Button regButton;
    private FirebaseAuth firebaseAuth;
    private ImageView userProfilePic;
    String email, name,dept,level,gender,stid;
    private static int PICK_IMAGE = 123;
    Uri imagePath;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    Context context;




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
        setContentView(R.layout.activity_register);

        context = this;

        setupUIViews();


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        storageReference = firebaseStorage.getReference();

        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickImage = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                pickImage.addCategory(Intent.CATEGORY_OPENABLE);
                pickImage.setType("image/*");

                startActivityForResult(pickImage,PICK_IMAGE);
            }
        });



        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendUserData();
                Intent intent = new Intent(register.this,login.class);
                intent.putExtra("Studentid",stid);
                intent.putExtra("Gender",gender);
                intent.putExtra("Name",name);
                intent.putExtra("Image",imagePath.toString());
                startActivity(intent);

            }
        });



    }

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.nametxt);
        userdept = findViewById(R.id.depttxt);
        levelspinner = findViewById(R.id.levelspinner);
        regButton = findViewById(R.id.savebtnn);
        userid = findViewById(R.id.stidtxt);
        genderspinner = findViewById(R.id.genderspinner);
        userProfilePic = (ImageView)findViewById(R.id.ivProfile);





        if (TextUtils.isEmpty(level)){
            Toast.makeText(register.this,"enter your level",Toast.LENGTH_SHORT).show();

        }

        if (TextUtils.isEmpty(dept)){
            Toast.makeText(register.this,"enter your department",Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(name)){
            Toast.makeText(register.this,"enter your name",Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(stid)){
            Toast.makeText(register.this,"enter your student id",Toast.LENGTH_SHORT).show();
        }

    }

    private void sendUserData(){
        name = userName.getText().toString().trim();
        stid = userid.getText().toString().trim();
        level = levelspinner.getSelectedItem().toString();
        dept = userdept.getText().toString().trim();
        gender = genderspinner.getSelectedItem().toString();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();

         FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
         DatabaseReference myref = firebaseDatabase.getReference("User").child(firebaseAuth.getUid());


        StorageReference imageReference = storageReference.child(firebaseAuth.getUid());  //User id/Images/Profile Pic.jpg
        UploadTask uploadTask = imageReference.putFile(imagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(register.this, "Upload failed!", Toast.LENGTH_SHORT).show();
            }
        }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                Toast.makeText(register.this, "Upload successful!", Toast.LENGTH_SHORT).show();
            }
        });


        User userProfile = new User(name,email,stid,dept,level,gender,imagePath.toString());
        myref.setValue(userProfile);




        DatabaseReference myrefemail = firebaseDatabase.getReference("All users").child(stid);

        User userProfile1 = new User(name,email,stid,dept,level,gender,imagePath.toString());
        myrefemail.setValue(userProfile1);



    }
}
