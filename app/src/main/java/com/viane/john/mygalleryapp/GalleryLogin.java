package com.viane.john.mygalleryapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class GalleryLogin extends AppCompatActivity {


    EditText log_user, log_pw;
    Button log;
    RegDatabase rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_login);

        log_user = (EditText)findViewById(R.id.user_login);
        log_pw = (EditText)findViewById(R.id.pw_login);
        log = (Button)findViewById(R.id.btnlg);
        rdb = new RegDatabase(this);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = log_user.getText().toString();
                String password = log_pw.getText().toString();

                boolean userpass = rdb.user_password(username,password);
                if(userpass==true){
                    log_pw.setText(null);
                    log_user.setText(null);
                    Intent i = new Intent(GalleryLogin.this, GalleryMain.class);
                    startActivity(i);
                }

                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(GalleryLogin.this);
                    builder.setTitle("Ooops");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setMessage("Username and Password do no match!")
                            .setCancelable(false)
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });
    }
}
