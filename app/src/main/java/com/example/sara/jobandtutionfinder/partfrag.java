package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class partfrag extends AppCompatActivity{

    private TextView givepost,otherspost;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part);

        givepost = findViewById(R.id.p1);
        otherspost = findViewById(R.id.p2);

        givepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(partfrag.this,PartPost.class);
                startActivity(toy);
            }
        });

        otherspost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy1 = new Intent(partfrag.this,PartJob.class);
                startActivity(toy1);

            }
        });


    }
}
