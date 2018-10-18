package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class partfrag extends AppCompatActivity {
    private ImageView toogle;
    private Button button_post,button_others;
    String PartPostKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partfrag);

        button_post=(Button)findViewById(R.id.c1);
        button_others=(Button)findViewById(R.id.c2);
        toogle=findViewById(R.id.toolic);
        toogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(partfrag.this,trysection.class);
                startActivity(in);
            }
        });



        button_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(partfrag.this,partfrag_give_postt.class);
                startActivity(intent);


            }
        });

        button_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(partfrag.this,partfrag_others_postt.class);
                startActivity(intent2);
            }
        });
    }
}
