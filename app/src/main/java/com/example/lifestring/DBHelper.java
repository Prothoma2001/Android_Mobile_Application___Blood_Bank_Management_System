package com.example.lifestring;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {

        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("create Table userDetails(name TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop Table if exists userDetails");
    }

    public Boolean insertData(String name, String password) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);

        long result = Mydb.insert("userDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    public Boolean checkUserName(String name) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from userDetails where name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUserPassword(String name, String password) {
        SQLiteDatabase Mydb = getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from userDetails where name = ? and password=?", new String[]{name, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public Boolean updatePassword(String userName, String password) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long result = Mydb.update("userDetails", contentValues, "userName=?",new String[]{userName});
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

}
