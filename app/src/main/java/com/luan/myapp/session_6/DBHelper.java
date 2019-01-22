package com.luan.myapp.session_6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "books",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("create table category(id int primary key AUTOINCREMENT, name varchar)");
       sqLiteDatabase.execSQL("create table book(id int primary key AUTOINCREMENT, title varchar, cat_id int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop TABLE IF EXISTS category");
        sqLiteDatabase.execSQL("drop TABLE IF EXISTS book");
        onCreate(sqLiteDatabase);
    }
}
