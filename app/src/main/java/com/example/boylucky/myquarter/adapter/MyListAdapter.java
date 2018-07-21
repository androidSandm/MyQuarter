package com.example.boylucky.myquarter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boylucky.myquarter.R;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/20.
 */

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> img;
    private List<String> tv_list;

    public MyListAdapter(Context context, List<Integer> img, List<String> tv_list) {
        this.context = context;
        this.img = img;
        this.tv_list = tv_list;
    }

    @Override
    public int getCount() {
        return tv_list.size();
    }

    @Override
    public Object getItem(int position) {
        return tv_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder hold;
        if (convertView == null) {
            hold = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_item, null);
            convertView.setTag(hold);
        } else {
            hold = (ViewHolder) convertView.getTag();
        }

        hold.textView =  convertView.findViewById(R.id.tv);
        hold.img =  convertView.findViewById(R.id.img);

        hold.textView.setText(tv_list.get(position));
        hold.img.setImageResource(img.get(position));
        return convertView;
    }

    class ViewHolder{
        ImageView img;
        TextView textView;
    }
}
