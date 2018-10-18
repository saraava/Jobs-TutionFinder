package com.example.sara.jobandtutionfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class partfrag_others_postt extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<post> list;
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partfrag_others_postt);


        //MyAdapter c1 = new MyAdapter();
        //c1.setUID("Hi");



        recyclerView = (RecyclerView) findViewById(R.id.rePerson);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference("Part_Time_Job").child("Posts");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<post>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    post p = dataSnapshot1.getValue(post.class);
                    list.add(p);
                }
                adapter = new MyAdapter(partfrag_others_postt.this,list);
                recyclerView.setAdapter(adapter);




            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


}
