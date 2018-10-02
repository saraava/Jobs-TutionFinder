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

public class FullTimePostPage extends AppCompatActivity {
    private EditText f1;
    private Button fbutton;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    private String se1,saveCurrentDate, saveCurrentTime,current_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_time_post_page);
        f1=(EditText) findViewById(R.id.f1);
        fbutton=(Button) findViewById(R.id.fbutton);
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

        PostInformation1 post=new PostInformation1(f1.getText().toString().trim(),user,postRandomName.toString());

        DatabaseReference d=FirebaseDatabase.getInstance().getReference("FullTimeJob");

        d.child(current_user_id+postRandomName).setValue(post);

    }
}