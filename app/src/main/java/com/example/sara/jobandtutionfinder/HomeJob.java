package com.example.sara.jobandtutionfinder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeJob extends AppCompatActivity {

    private ListView listV;
    List<PostInformation4> l = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_job);

        listV=findViewById(R.id.list3);

        DatabaseReference d= FirebaseDatabase.getInstance().getReference("HomeTutor");
        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i:dataSnapshot.getChildren()){
                    l.add(i.getValue(PostInformation4.class));
                }
                CustomAdapter3 c=new CustomAdapter3(HomeJob.this,l);
                listV.setAdapter(c);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
