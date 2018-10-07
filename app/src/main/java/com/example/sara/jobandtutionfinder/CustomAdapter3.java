package com.example.sara.jobandtutionfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter3 extends BaseAdapter {
    List<PostInformation4> stuinfo;
    Context context;
    private LayoutInflater inflater;

    public CustomAdapter3(Context c,List l) {
        this.context=c;
        this.stuinfo = l;
    }

    @Override
    public int getCount() {
        return stuinfo.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.sample4,viewGroup,false);

        }

        TextView textView1=view.findViewById(R.id.hsamplet1);
        TextView textView3=view.findViewById(R.id.hsamplet3);
        TextView textView2=view.findViewById(R.id.hsamplet2);


        textView1.setText(stuinfo.get(i).getUsername());
        textView3.setText(stuinfo.get(i).getDateh());
        textView2.setText(stuinfo.get(i).getPosth());
        return  view;
    }
}
