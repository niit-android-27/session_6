package com.luan.myapp.session_6.dals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luan.myapp.session_6.DBHelper;
import com.luan.myapp.session_6.models.Book;

import java.util.ArrayList;

public class DalBook {
    SQLiteDatabase db;
    Context context;
    public DalBook(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();

    }

    //insert
    void insert(String title, int catId){
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("cat_id",catId);
        db.insert("book",null,contentValues);
    }

    //update
    void update(int id, String title, int catId){
        ContentValues contentValues = new ContentValues();
        if(title!="") {
            contentValues.put("title", title);
        }
        if(catId>=1) {
            contentValues.put("cat_id", catId);
        }

        db.update("book",contentValues,"id = "+id,null);
    }

    //delete
    void delete(int id){
        db.delete("book","id = "+id,null);
    }

    //get
    public ArrayList<Book> gets(){
        ArrayList<Book> list = new ArrayList<>();
       Cursor cursor  = db.rawQuery("select * from book",null);
       if(cursor!=null && cursor.moveToFirst()){
           do {
               int id = cursor.getInt(cursor.getColumnIndex("id"));
               String title = cursor.getString(cursor.getColumnIndex("title"));
               int catId = cursor.getInt(cursor.getColumnIndex("catId"));
               Book book = new Book();
               book.setId(id);
               book.setTitle(title);
               book.setCatId(catId);
               list.add(book);
           }while (cursor.moveToNext());
       }
       return list;
    }

    void close(){
        if(db!=null) {
            db.close();
        }
    }

}
