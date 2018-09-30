package com.example.sara.jobandtutionfinder;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class profilefrag extends AppCompatActivity{

    ImageView profilePic;
    TextView profileName, profileEmail,profilegender,profilestid,profiledept,profilelevel;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        profilePic = findViewById(R.id.ivProfilePic);
        profileName = findViewById(R.id.textname);
        profiledept = findViewById(R.id.textdept);
        profileEmail = findViewById(R.id.textemail);
        profilelevel = findViewById(R.id.textlevel);
        profilestid = findViewById(R.id.textstudentID);
        profilegender = findViewById(R.id.textgender);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        StorageReference storageReference = firebaseStorage.getReference();

        storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).fit().centerCrop().into(profilePic);
                //done
                //done
                //done
                //done
                //dpoenen
                //xknf
                //ddbbd
                ////jnjsddjh
                //djkndfnd,s
                //hdhd
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User userProfile = dataSnapshot.getValue(User.class);
                profileName.setText("Name          :" + userProfile.getName());
                profileEmail.setText("Email              :"+userProfile.getEmail());
                profilegender.setText("Gender           :"+userProfile.getGender());
                profilestid.setText("Student ID      :"+userProfile.getStudentid());
                profiledept.setText("Department   :"+userProfile.getDept());
                profilelevel.setText("Level              :"+userProfile.getLevel());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(profilefrag.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });






    }


}

