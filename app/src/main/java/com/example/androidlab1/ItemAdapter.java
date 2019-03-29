package com.example.androidlab1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    public static class MyViewHolder {
        TextView numbers;
        ImageView pic;
    }

    private Context context;

    @Override
    public int getCount() {
        return 1000000;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    ItemAdapter(Context context) {
        this.context = context;

    }

    @SuppressLint({"ViewHolder", "CutPasteId"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyViewHolder holder;
        view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false );
        holder = new MyViewHolder();
        holder.numbers = view.findViewById(R.id.number);
        holder.pic = view.findViewById(R.id.picture);
        holder.pic.setImageResource(R.drawable.strange_dom);
        if (i % 2 == 1) {
            view.setBackgroundColor(Color.rgb(170, 170, 170));
        } else {
            view.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        
        holder.numbers.setText(Converter.toString(i+1));
        return view;
    }
}
