package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeTeach extends AppCompatActivity {
    private Button button_post,button_others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_teach);

        button_post=(Button)findViewById(R.id.h1);
        button_others=(Button)findViewById(R.id.h2);


        button_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeTeach.this,HomePostPage.class);
                startActivity(intent);


            }
        });

        button_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(HomeTeach.this,HomeJob.class);
                startActivity(intent2);
            }
        });
    }
}
