package com.viane.john.mygalleryapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RegDatabase rdb;
    EditText reg_un, reg_pw, reg_cpw;
    Button btnregister, btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg_un =(EditText)findViewById(R.id.user_name);
        reg_pw =(EditText)findViewById(R.id.password);
        reg_cpw =(EditText)findViewById(R.id.confirm_password);

        btnlogin = (Button) findViewById(R.id.loginbtn);
        btnregister = (Button) findViewById(R.id.regbtn);

        rdb = new RegDatabase(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = reg_un.getText().toString();
                String password = reg_pw.getText().toString();
                String confirmpassword = reg_cpw.getText().toString();

                if(password.equals("") || username.equals("") || confirmpassword.equals("")){

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Ooops");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setMessage("Some text field are empty!")
                            .setCancelable(false)
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                else{
                    if (password.equals(confirmpassword)){
                        boolean check_username = rdb.check_username(username);
                        if (check_username ==true){
                            Boolean insert = rdb.insert(username,confirmpassword);
                            if (insert==true){
                                reg_un.setText(null);
                                reg_cpw.setText(null);
                                reg_pw.setText(null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setTitle("Registration Complete");
                                builder.setIcon(R.mipmap.ic_launcher);
                                builder.setMessage("Please Proceed to Log-in")
                                        .setCancelable(false)
                                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();

                            }
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Ooops");
                            builder.setIcon(R.mipmap.ic_launcher);
                            builder.setMessage("Username Already exist!")
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
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Ooops");
                        builder.setIcon(R.mipmap.ic_launcher);
                        builder.setMessage("Password do not match!")
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

            }
        });


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GalleryLogin.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
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


