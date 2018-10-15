package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class partfrag extends AppCompatActivity{

    private TextView givepost,otherspost;
    String namee,imagee,PartPostKey;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part);

        givepost = findViewById(R.id.p1);
        otherspost = findViewById(R.id.p2);

        namee=getIntent().getStringExtra("Name");
        imagee=getIntent().getStringExtra("Image");
        PartPostKey=getIntent().getStringExtra("PartPostKey");

        givepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(partfrag.this,partfrag_give_postt.class);
                i.putExtra("Name",namee);
                i.putExtra("Image",imagee);

                startActivity(i);
            }
        });

        otherspost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy1 = new Intent(partfrag.this,partfrag_others_postt.class);
                toy1.putExtra("PartPostKey",PartPostKey);
                startActivity(toy1);

            }
        });


    }
}
