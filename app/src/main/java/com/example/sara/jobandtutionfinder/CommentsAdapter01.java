package com.example.sara.jobandtutionfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentsAdapter01 extends BaseAdapter {

    private Context activity;
    private ArrayList<comment01class> allstudent=new ArrayList<>();
    private LayoutInflater layoutInflater=null;

    private static class ViewHolder{
        private TextView email,postdes,timee,datee;
    }

    private ViewHolder viewHolder=null;

    public CommentsAdapter01(Context activity,ArrayList<comment01class> allstudent) {
        this.activity=activity;
        this.allstudent = allstudent;
        layoutInflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return allstudent.size();
    }

    @Override
    public Object getItem(int position) {
        return allstudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        final int pos = position;
        if(view == null){
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.partfrag_comment_show,null);
            viewHolder.email = view.findViewById(R.id.getemail);
            viewHolder.postdes = view.findViewById(R.id.post_description_show);
            viewHolder.timee = view.findViewById(R.id.timeshow);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.email.setText(allstudent.get(pos).getEemail());
        viewHolder.postdes.setText(allstudent.get(pos).getCommentdes());
        viewHolder.timee.setText(allstudent.get(pos).getTimee());

        return view;
    }
}
