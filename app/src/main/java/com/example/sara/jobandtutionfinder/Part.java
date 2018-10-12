package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Part extends AppCompatActivity {
    private TextView givepost,otherspost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);

        givepost = findViewById(R.id.p1);
        otherspost = findViewById(R.id.p2);

        givepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(Part.this,Part2Post.class);
                startActivity(toy);
            }
        });

        otherspost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy1 = new Intent(Part.this,Part2Job.class);
                startActivity(toy1);

            }
        });
    }
}
