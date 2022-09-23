package com.kunal.lecture;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    String[] city_arr;
    int[] contact_arr,img;
    Context c;

    public MyAdapter(Context c, String[] city_arr, int[] contact_arr,int[] img) {
        this.city_arr=city_arr;
        this.contact_arr=contact_arr;
        this.c=c;
        this.img=img;
    }

    @Override
    public int getCount() {
        return city_arr.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view= LayoutInflater.from(c).inflate(R.layout.myfile,viewGroup,false);

        TextView city,contact;
        ImageView imageView;

        city=view.findViewById(R.id.city);
        contact=view.findViewById(R.id.contact);
        imageView=view.findViewById(R.id.img);

        city.setText(city_arr[i]);
        contact.setText(""+contact_arr[i]);
        imageView.setImageResource(img[i]);
//        imageView.setImageResource(R.drawable.logo);


        return view;
    }
}
