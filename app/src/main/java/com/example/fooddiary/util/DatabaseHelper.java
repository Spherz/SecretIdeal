package com.example.fooddiary.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "USERS";

    public static final String _ID = "id";
    public static final String EMAIL = "email";
    public static final String FULLNAME = "fullname";
    public static final String PASSWORD = "password";
    public static final String AGE = "age";
    public static final String GENDER = "gender";
    public static final String ACTIVITY = "activity";
    public static final String WEIGHT = "weight";
    public static final String HEIGHT = "height";
    public static final String GOAL = "goal";
    public static final String PHONE = "phone";

    static final String DB_NAME = "SECRET_IDEAL.DB";

    static final int DB_VERSION = 1;

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL + " TEXT, " + FULLNAME + " TEXT NOT NULL, "
            + PHONE + " TEXT, " + PASSWORD + " TEXT NOT NULL, " + AGE + " TEXT, " + GENDER + " TEXT, "
            + ACTIVITY + " TEXT, " + WEIGHT + " TEXT, " + HEIGHT + " TEXT, " + GOAL + " TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
