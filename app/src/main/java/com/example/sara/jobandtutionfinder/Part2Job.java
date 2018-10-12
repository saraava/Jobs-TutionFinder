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

public class Part2Job extends AppCompatActivity {
    private ListView listV;
    List<StudentInfo1> l = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_job);


        listV=findViewById(R.id.list11);

        DatabaseReference d= FirebaseDatabase.getInstance().getReference("PartTimeJob");
        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i:dataSnapshot.getChildren()){
                    l.add(i.getValue(StudentInfo1.class));
                }
                CustomAdapter1 c=new CustomAdapter1(Part2Job.this,l);
                listV.setAdapter(c);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
