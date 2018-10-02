package com.example.sara.jobandtutionfinder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FullTimeJob extends AppCompatActivity {

    private TextView t1,t2,t3,t4;
    private ListView listV;
    List<PostInformation1> l = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_time_job);

        listV=findViewById(R.id.list1);

        DatabaseReference d= FirebaseDatabase.getInstance().getReference("FullTimeJob");
        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i:dataSnapshot.getChildren()){
                    l.add(i.getValue(PostInformation1.class));
                }
                CustomAdapter c=new CustomAdapter(FullTimeJob.this,l);
                listV.setAdapter(c);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
