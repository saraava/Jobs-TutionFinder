package com.example.sara.jobandtutionfinder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FullTimeJob extends AppCompatActivity {


    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<PostInformation1> list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_time_job);

        //listV=findViewById(R.id.list1);

        recyclerView = (RecyclerView) findViewById(R.id.rePerson);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));


        reference = FirebaseDatabase.getInstance().getReference("Full_Time_Job").child("Posts");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<PostInformation1>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    PostInformation1 p = dataSnapshot1.getValue(PostInformation1.class);
                    list.add(p);
                }
                adapter = new CustomAdapter(FullTimeJob.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FullTimeJob.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
