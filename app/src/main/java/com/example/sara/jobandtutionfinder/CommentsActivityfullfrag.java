package com.example.sara.jobandtutionfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class CommentsActivityfullfrag extends AppCompatActivity {

    EditText commentbox;
    FirebaseAuth mAuth;
    DatabaseReference UsersRef, ref, reference, PostsRef;
    String Description, postRandomName, saveCurrentDate, saveCurrentTime, current_user_id, commentkey, userFullName, studentid;

    ListView lv;
    ArrayList<comment02class> allstudent;
    ImageButton comment;
    comment02class student;
    String l;
    String PartPostKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_activityfullfrag);


        comment = findViewById(R.id.comment_click);
        commentbox = findViewById(R.id.comment_inputs);
        mAuth = FirebaseAuth.getInstance();

        PartPostKey=getIntent().getStringExtra("PartPostKey");


        lv = findViewById(R.id.listallstudent);
        allstudent = new ArrayList<>();


        current_user_id = mAuth.getCurrentUser().getUid();


        ref= FirebaseDatabase.getInstance().getReference("Full_Time_Job").child("Posts").child(PartPostKey).child("Comments");
        UsersRef = FirebaseDatabase.getInstance().getReference("User");
        PostsRef = FirebaseDatabase.getInstance().getReference("Full_Time_Job").child("Posts").child(PartPostKey).child("Comments");


        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validatepost();

            }
        });


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                allstudent.clear();
                for(DataSnapshot i:dataSnapshot.getChildren())
                {
                    student = i.getValue(comment02class.class);
                    allstudent.add(student);

                }

                CommentsAdapter02 studentadapter = new CommentsAdapter02(CommentsActivityfullfrag.this,allstudent);
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
        Random r = new Random();
        int n=r.nextInt(100)+1;
        commentkey = current_user_id + postRandomName+n;

        SavingCommentInformationToDatabase();
    }

    void SavingCommentInformationToDatabase() {

        UsersRef.child(current_user_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                User userProfile = dataSnapshot.getValue(User.class);

                userFullName = userProfile.getName().toString().trim();
                studentid = userProfile.getStudentid().toString().trim();


                comment02class p = new comment02class(userFullName,Description,saveCurrentTime,saveCurrentDate,studentid);
                PostsRef.child(commentkey).setValue(p);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
