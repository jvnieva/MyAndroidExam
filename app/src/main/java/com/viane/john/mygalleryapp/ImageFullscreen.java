package com.viane.john.mygalleryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageFullscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_fullscreen);

        Intent i = getIntent();

        int fullscreen = i.getExtras().getInt("id");
        ImageViewer imgview = new ImageViewer(this);

        ImageView img = (ImageView)findViewById(R.id.imgfull);
        img.setImageResource(imgview.img[fullscreen]);
    }
}
