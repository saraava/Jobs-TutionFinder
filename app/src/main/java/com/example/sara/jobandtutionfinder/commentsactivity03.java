package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class commentsactivity03 extends AppCompatActivity {


    EditText commentbox;
    FirebaseAuth mAuth;
    DatabaseReference UsersRef, ref, reference, PostsRef;
    String Description, postRandomName, saveCurrentDate, saveCurrentTime, current_user_id, commentkey, userFullName, studentid;

    ListView lv;
    ArrayList<comment03class> allstudent;
    Button comment;
    comment03class student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentsactivity03);

        comment = findViewById(R.id.comment_click);
        commentbox = findViewById(R.id.comment_inputs);
        mAuth = FirebaseAuth.getInstance();


        lv = findViewById(R.id.listallstudent);
        allstudent = new ArrayList<>();


        current_user_id = mAuth.getCurrentUser().getUid();


        ref= FirebaseDatabase.getInstance().getReference("Coaching").child("Comments");
        UsersRef = FirebaseDatabase.getInstance().getReference("User");
        PostsRef = FirebaseDatabase.getInstance().getReference("Coaching").child("Comments");


        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validatepost();

            }
        });


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot i:dataSnapshot.getChildren())
                {
                    student = i.getValue(comment03class.class);
                    allstudent.add(student);

                }

                CommentsAdapter03 studentadapter = new CommentsAdapter03(commentsactivity03.this,allstudent);
                lv.setAdapter(studentadapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });


    }

    void validatepost() {
        Description = commentbox.getText().toString();

        if (TextUtils.isEmpty(Description)) {
            Toast.makeText(this, "Please say something about your image...", Toast.LENGTH_SHORT).show();
        } else {


            StoringdateFirebaseStorage();
        }


    }

    void StoringdateFirebaseStorage() {

        Calendar calFordDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
        saveCurrentDate = currentDate.format(calFordDate.getTime());

        Calendar calFordTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
        saveCurrentTime = currentTime.format(calFordDate.getTime());

        postRandomName = saveCurrentDate + saveCurrentTime;
        commentkey = current_user_id + postRandomName;

        SavingCommentInformationToDatabase();
    }

    void SavingCommentInformationToDatabase() {

        UsersRef.child(current_user_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                User userProfile = dataSnapshot.getValue(User.class);

                userFullName = userProfile.getName().toString().trim();
                studentid = userProfile.getStudentid().toString().trim();


                comment03class p = new comment03class(userFullName,Description,saveCurrentTime,saveCurrentDate,studentid);
                PostsRef.child(commentkey).setValue(p);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}