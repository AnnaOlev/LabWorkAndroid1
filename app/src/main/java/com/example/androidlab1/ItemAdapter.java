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

    private List<Item> mItemList;
    private Context context;

    public static class MyViewHolder {
        TextView numbers;
        ImageView pic;
    }

    ItemAdapter(Context context, List<Item> list) {
        super();

        this.context = context;
        mItemList = list;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder;
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        holder = new MyViewHolder();
        holder.numbers = convertView.findViewById(R.id.number);
        holder.pic = convertView.findViewById(R.id.picture);

        convertView.setTag(holder);
        holder = (MyViewHolder) convertView.getTag();

        holder.numbers.setText(convert(position+1));
        if ((position & 1) == 1) {
            convertView.setBackgroundColor(Color.rgb(170, 170, 170));
        } else {
            convertView.setBackgroundColor(Color.rgb(255, 255, 255));
        }

        return convertView;
    }

    private static String convert(int n) {
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty",
                "seventy", "eighty", "ninety"};
        if (n < 20 && n > 0)
            return units[n];
        if (n < 100)
            return tens[n / 10] + (n % 10 != 0 ? " " : "") + units[n % 10];
        if (n < 1000)
            return units[n / 100] + " hundred" + (n % 100 != 0 ? " " : "") + convert(n % 100);
        if (n < 1000000)
            return convert(n / 1000) + " thousand" + (n % 1000 != 0 ? " " : "") + convert(n % 1000);
        return "million";
    }
}
