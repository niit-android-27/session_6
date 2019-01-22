package com.luan.myapp.session_6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SQLiteDatabase db = openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        //thuc thi lenh tao
//        db.execSQL("create table hocsinh(id INT PRIMARY KEY, " +
//                "name VARCHAR," +
//                " lop VARCHAR )");



        //thuc thi lenh insert
        //db.execSQL("insert into hocsinh(id,name,lop) values(1,'Luan','Android')");
        //db.execSQL("insert into hocsinh(id,name,lop) values(2,'Luan 1','Android 1')");
        //db.execSQL("insert into hocsinh(id,name,lop) values(3,'Luan 2','Android 2')");

//        Cursor cursor= db.rawQuery("select * from hocsinh " +
//                " where name = ? ",new String[]{"Luan"});
//
//        Cursor cursor= db.rawQuery("select * from hocsinh",null
//                );
//        if(cursor!=null && cursor.moveToFirst()){
//            do {
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                Log.e("SESSION6",name);
//                //khi con tro van con tro duoc den ben ghi tiep theo, tien hanh doc
//            }while (cursor.moveToNext());
//        }

        DBHelper dbHelper = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }
}
