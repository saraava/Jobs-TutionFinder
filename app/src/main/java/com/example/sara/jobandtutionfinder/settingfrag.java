package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class settingfrag extends AppCompatActivity {
    private Button bSetting,bupdate;
    private ImageView toogle;
String studentid,gender;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
            bSetting=(Button) findViewById(R.id.chng_pass);
            bupdate=(Button) findViewById(R.id.update_profile);

            toogle=findViewById(R.id.toolic);
            toogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(settingfrag.this,trysection.class);
                    startActivity(in);
                }
            });
            studentid=getIntent().getStringExtra("Studentid");
            gender=getIntent().getStringExtra("Gender");
            bSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(settingfrag.this,changePass.class);
                    startActivity(intent);
                    }

            });

            bupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intentu=new Intent(settingfrag.this,updateProfile.class);
                    intentu.putExtra("Studentid",studentid);
                    intentu.putExtra("Gender",gender);
                    Toast.makeText(settingfrag.this,studentid,Toast.LENGTH_SHORT).show();
                    startActivity(intentu);
                    }

            });
        }


    }

