package com.example.sara.jobandtutionfinder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CoachxJob extends AppCompatActivity {


    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<PostInformation3> list;
    CustomAdapter03 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coachx_job);

        recyclerView = (RecyclerView) findViewById(R.id.rePerson);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));



        reference = FirebaseDatabase.getInstance().getReference("Coaching").child("Posts");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<PostInformation3>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    PostInformation3 p = dataSnapshot1.getValue(PostInformation3.class);
                    list.add(p);
                }
                adapter = new CustomAdapter03(CoachxJob.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CoachxJob.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
