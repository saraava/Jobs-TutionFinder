package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bookSelection extends AppCompatActivity {
private Button pbtn,cbtn,ibtn,gmbtn,hmbtn,bbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_selection);
        pbtn=(Button) findViewById(R.id.phybtn);
        cbtn=(Button) findViewById(R.id.chebtn);
       ibtn=(Button) findViewById(R.id.ictbtn);
        gmbtn=(Button) findViewById(R.id.gmbtn);
        hmbtn=(Button) findViewById(R.id.hmathbtn);
        bbtn=(Button) findViewById(R.id.biobtn);
       pbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent phybookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1kzANjG8a08_EYJtCKbnW6HlW9p8BjEW6"));
               startActivity(phybookIntent);
           }
       });

   cbtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent chebookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1Z4-qQVcN564VFuPc6g8iF2o4sZIxKBu1"));
           startActivity(chebookIntent);
       }
   });
       bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent biobookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1M_unb0jVUVhDQ_kTg1bXIeI545sOGj9B"));
                startActivity(biobookIntent);
            }
        });
       gmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmbookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1eHXU-FzreDUsKPDem0mCKCIM4lhtY4VC"));
                startActivity(gmbookIntent);
            }
        });
        hmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hmbookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1YuafWPPIUJ86rARJHgi42L3rk0hm5d1Z"));
                startActivity(hmbookIntent);
            }
        });
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ictbookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=11y0-gFDzG2_JslDmLet5xtZlI5gVhTQH"));
                startActivity(ictbookIntent);
            }
        });


    }
}
