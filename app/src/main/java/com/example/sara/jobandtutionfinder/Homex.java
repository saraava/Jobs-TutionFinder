package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Homex extends AppCompatActivity {
    private Button button_post,button_others;
    private ImageView toogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homex);

        button_post=(Button)findViewById(R.id.h1);
        button_others=(Button)findViewById(R.id.h2);
        toogle=findViewById(R.id.toolic);
        toogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Homex.this,trysection.class);
                startActivity(in);
            }
        });

        button_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Homex.this,Homexpost.class);
                startActivity(intent);


            }
        });

        button_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Homex.this,HomexJob2.class);
                startActivity(intent2);
            }
        });
    }
}
