package com.example.sara.jobandtutionfinder;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Part2Post extends AppCompatActivity {

    private EditText f1;
    private Button fbutton;
    private DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    private String se1,saveCurrentDate, saveCurrentTime,current_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_post);
        f1=(EditText) findViewById(R.id.pp1);
        fbutton=(Button) findViewById(R.id.pb1);
        databaseReference= FirebaseDatabase.getInstance().getReference();

        mAuth=FirebaseAuth.getInstance();
        current_user_id = mAuth.getCurrentUser().getUid();
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveInfo();
                f1.setText("");



            }
        });
    }

    void saveInfo(){


        //setDate
        se1=f1.getText().toString().trim();
        Calendar calFordDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
        saveCurrentDate = currentDate.format(calFordDate.getTime());
        Calendar calFordTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
        saveCurrentTime = currentTime.format(calFordDate.getTime());
        String postRandomName = saveCurrentDate + saveCurrentTime;



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String user=preferences.getString("username","");

       StudentInfo1 post=new StudentInfo1(f1.getText().toString().trim(),user,postRandomName.toString());

        DatabaseReference d=FirebaseDatabase.getInstance().getReference("PartTimeJob");

        d.child(current_user_id+postRandomName).setValue(post);

    }
}