package com.example.sara.jobandtutionfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectCls extends AppCompatActivity {
private Button btnc9,btnc11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cls);
        btnc9=(Button) findViewById(R.id.btncls9);
        btnc11=(Button) findViewById(R.id.btncls11);
        btnc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9=new Intent(selectCls.this,bookSelections.class);
                startActivity(intent9);
            }
        });
        btnc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11=new Intent(selectCls.this,bookSelections.class);
                startActivity(intent11);
            }
        });
    }
}
