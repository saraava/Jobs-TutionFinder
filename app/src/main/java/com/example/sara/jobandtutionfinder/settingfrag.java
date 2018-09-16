package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class settingfrag extends AppCompatActivity {
    private Button bSetting,bupdate;



        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
            bSetting=(Button) findViewById(R.id.chng_pass);
            bupdate=(Button) findViewById(R.id.update_profile);
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
                    startActivity(intentu);
                    }

            });
        }


    }

