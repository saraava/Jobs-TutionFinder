package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class showCv extends AppCompatActivity {
private Button cvbtn;
private ImageView toogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_cv);

        cvbtn=(Button) findViewById(R.id.btncvfr);

        toogle=findViewById(R.id.toolic);
        toogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(showCv.this,trysection.class);
                startActivity(in);
            }
        });

        cvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cvIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1TOObgrnsbEu1G7ndRShwWOfEuVkhnJhX"));
                startActivity(cvIntent);
            }
        });
    }
}
