package com.example.sara.jobandtutionfinder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter03 extends RecyclerView.Adapter<CustomAdapter03.MyViewHolder> {
    Context context;
    ArrayList<PostInformation3> profiles;
    String partkey,stid;

    public CustomAdapter03(Context c, ArrayList<PostInformation3> p) {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.sample03, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.namee.setText(profiles.get(position).getFullname());
        holder.postdes.setText(profiles.get(position).getDescription());
        holder.time_date.setText(profiles.get(position).getDate() + " at " + profiles.get(position).getTime());
        holder.studentidd.setText(profiles.get(position).getStudentidd());
        Picasso.get().load(profiles.get(position).getProfileimage()).into(holder.profilePic);

        partkey = profiles.get(position).getPostID().toString();
        stid=profiles.get(position).getStudentidd().toString();



        //do nothing
        //do nothing
        //do nothing
        //do nothing
        //do nothing
        //do nothing
        //do nothing

        holder.onClick();
        holder.onclick2();


    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView namee, time_date, postdes,studentidd;
        ImageView profilePic;
        ImageButton btn;


        public MyViewHolder(View itemView) {
            super(itemView);
            namee = (TextView) itemView.findViewById(R.id.post_user_name);
            profilePic = (ImageView) itemView.findViewById(R.id.imgup);
            time_date = itemView.findViewById(R.id.date_time);
            postdes = itemView.findViewById(R.id.post_description);
            btn = itemView.findViewById(R.id.commentbtnn);
            studentidd=itemView.findViewById(R.id.post_user_stid);


        }

        void onClick() {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent toy1 = new Intent(context, commentsactivity03.class);
                    toy1.putExtra("PartPostKey",partkey);
                    context.startActivity(toy1);


                }
            });

        }

        public void onclick2() {

            studentidd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toy1 = new Intent(context,othersprofile.class);
                    toy1.putExtra("Stid",stid);
                    context.startActivity(toy1);

                }
            });
        }

    }
}
