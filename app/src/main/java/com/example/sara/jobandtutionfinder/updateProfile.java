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

    private EditText userName,userlevel,userdept, userEmail, userid;
    Spinner genderspinner;
    private Button regButton;
    private FirebaseAuth firebaseAuth;
    private ImageView userProfilePic;
    String email, name,dept,level,gender,stid;
    private static int PICK_IMAGE = 123;
    Uri imagePath;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    private FirebaseDatabase firebaseDatabase;
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
        setContentView(R.layout.activity_updateprofile);

        setContentView(R.layout.activity_profile);

        context = this;

        userName = (EditText)findViewById(R.id.nametxt);
        userdept = findViewById(R.id.depttxt);
        userEmail = findViewById(R.id.emailtxt);
        userlevel = findViewById(R.id.leveltxt);
        regButton = findViewById(R.id.savebtn);
        userid = findViewById(R.id.stidtxt);
       // genderspinner = findViewById(R.id.spinner2);
        userProfilePic = (ImageView)findViewById(R.id.ivProfile);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());



    }
}
