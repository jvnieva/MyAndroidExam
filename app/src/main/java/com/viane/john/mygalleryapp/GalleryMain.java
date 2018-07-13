package com.viane.john.mygalleryapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class GalleryMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_main);

        GridView gview = (GridView)findViewById(R.id.grid);
        gview.setAdapter(new ImageViewer(this));

        Button lgoutbtn = (Button)findViewById(R.id.logoutbtn);

        configureHomeButton();


        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ii = new Intent(getApplicationContext(), ImageFullscreen.class);
                ii.putExtra("id",i);
                startActivity(ii);


            }
        });
    }

    public void configureHomeButton(){
        Button homeButton = (Button) findViewById(R.id.logoutbtn);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GalleryMain.this);
                builder.setTitle("Log-out");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Confirm log-out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(GalleryMain.this);
        builder.setTitle("Log-out");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Confirm log-out?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
