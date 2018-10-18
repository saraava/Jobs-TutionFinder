package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Coachx extends AppCompatActivity {
    private Button button_post,button_others;
    private ImageView toogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coachx);

        button_post=(Button)findViewById(R.id.c1);
        button_others=(Button)findViewById(R.id.c2);
        toogle=findViewById(R.id.toolic);
        toogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Coachx.this,trysection.class);
                startActivity(in);
            }
        });

        button_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Coachx.this,CoachxPostPage.class);
                startActivity(intent);


            }
        });

        button_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Coachx.this,CoachxJob.class);
                startActivity(intent2);
            }
        });
    }
}
