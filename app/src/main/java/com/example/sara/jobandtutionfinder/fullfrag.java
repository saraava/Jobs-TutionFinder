package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class fullfrag extends AppCompatActivity{

    private Button button_post,button_others;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        button_post=(Button)findViewById(R.id.fulltime_post_button);
        button_others=(Button)findViewById(R.id.fulltime_others_button);


        button_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(fullfrag.this,FullTimePostPage.class);
                startActivity(intent);


            }
        });

        button_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(fullfrag.this,FullTimeJob.class);
                startActivity(intent2);
            }
        });
    }
}