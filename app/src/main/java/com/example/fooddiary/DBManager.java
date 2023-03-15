package com.example.fooddiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String email, String fullname, String password, String phone) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.EMAIL, email);
        contentValue.put(DatabaseHelper.FULLNAME, fullname);
        contentValue.put(DatabaseHelper.PASSWORD, password);
        contentValue.put(DatabaseHelper.PHONE, phone);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] {DatabaseHelper._ID, DatabaseHelper.EMAIL, DatabaseHelper.FULLNAME, DatabaseHelper.PASSWORD, DatabaseHelper.PHONE};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String email, String fullname, String password, String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.EMAIL, email);
        contentValues.put(DatabaseHelper.FULLNAME, fullname);
        contentValues.put(DatabaseHelper.PASSWORD, password);
        contentValues.put(DatabaseHelper.PHONE, phone);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

    public Boolean checkUser(String email) {
        database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from USERS where email = ?", new String[] {email});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUsersPassword(String email, String password) {
        database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from USERS where email = ? and password = ?", new String[] {email, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
