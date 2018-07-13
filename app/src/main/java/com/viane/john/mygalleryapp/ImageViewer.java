package com.viane.john.mygalleryapp;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageViewer extends BaseAdapter {

    private Context context;

    public Integer[] img = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j
    };

    public ImageViewer (Context c){
        context = c;
    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int i) {
        return img[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgview = new ImageView(context);
        imgview.setImageResource(img[i]);
        imgview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imgview;
    }
}
