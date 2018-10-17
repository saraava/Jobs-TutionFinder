package com.example.sara.jobandtutionfinder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<post> profiles;
    String l;

    public String value=partfrag_others_postt.value;

   // public  String strUID = "";



    public MyAdapter(Context c , ArrayList<post> p)
    {
        context = c;
        profiles = p;
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.partfrag_post_show,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        holder.namee.setText(profiles.get(position).getFullname());
        holder.postdes.setText(profiles.get(position).getDescription());
        holder.time_date.setText(profiles.get(position).getDate() + " at "+profiles.get(position).getTime());
        Picasso.get().load(profiles.get(position).getProfileimage()).into(holder.profilePic);


        holder.onClick();

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView namee,time_date,postdes;
        ImageView profilePic;
        ImageButton btn;

        public MyViewHolder(View itemView) {
            super(itemView);

            namee = (TextView) itemView.findViewById(R.id.post_user_name);
            profilePic = (ImageView) itemView.findViewById(R.id.imgup);
            time_date =itemView.findViewById(R.id.date_time);
            postdes = itemView.findViewById(R.id.post_description);
            btn =  itemView.findViewById(R.id.commentbtnn);
        }

        void onClick() {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent toy1 = new Intent(context,CommentsActivitypartfrag.class);
                    toy1.putExtra("Value",value);
                    context.startActivity(toy1);



                }
            });

        }
    }
}

