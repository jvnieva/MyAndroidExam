package com.viane.john.mygalleryapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegDatabase extends SQLiteOpenHelper {
    public RegDatabase(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("Create table user(username text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");

    }

    public boolean insert(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put("username", username);
        CV.put("password", password);

        long ins = db.insert("user",null,CV);
        if (ins==-1) return false;
        else return true;

    }

    public boolean check_username(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user where username=?", new String[]{username});

        if (c.getCount()>0) return false;
        else return true;
    }

    public boolean user_password(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user where username=? and password=?", new String[]{username,password});
        if (c.getCount()>0) return true;
        else return false;
    }
}
