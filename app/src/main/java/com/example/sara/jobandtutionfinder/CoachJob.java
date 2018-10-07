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

public class CoachJob extends AppCompatActivity {

    private ListView listV;
    List<PostInformation2> l = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_job);

        listV=findViewById(R.id.list2);

        DatabaseReference d= FirebaseDatabase.getInstance().getReference("Coaching");
        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i:dataSnapshot.getChildren()){
                    l.add(i.getValue(PostInformation2.class));
                }
                CustomAdapter2 c=new CustomAdapter2(CoachJob.this,l);
                listV.setAdapter(c);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
