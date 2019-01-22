package com.luan.myapp.session_6.dals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luan.myapp.session_6.DBHelper;
import com.luan.myapp.session_6.models.Book;
import com.luan.myapp.session_6.models.Category;

import java.util.ArrayList;

public class DalCategory {
    SQLiteDatabase db;
    Context context;
    public DalCategory(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    void insert(String title, int catId){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",title);
        db.insert("category",null,contentValues);
    }

    //update
    void update(int id, String name){
        ContentValues contentValues = new ContentValues();
        if(name!="") {
            contentValues.put("name", name);
        }

        db.update("category",contentValues,"id = "+id,null);
    }

    //delete
    void delete(int id){
        db.delete("category","id = "+id,null);
    }

    //get
    public ArrayList<Category> gets(){
        ArrayList<Category> list = new ArrayList<>();
        Cursor cursor  = db.rawQuery("select * from category",null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Category category = new Category();
                category.setId(id);
                category.setName(name);
                list.add(category);
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
