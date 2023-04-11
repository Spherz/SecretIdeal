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

    public static final String FOOD_TABLE = "FOOD";

    public static final String FOOD_ID = "id";
    public static final String FOOD_NAME = "food_name";
    public static final String FOOD_CALORIES = "food_calories";
    public static final String FOOD_FATS = "food_fats";
    public static final String FOOD_CARBOHYDRATES = "food_carbohydrates";
    public static final String FOOD_PROTEIN = "food_protein";

    static final String DB_NAME = "SECRET_IDEAL.DB";

    static final int DB_VERSION = 3;

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL + " TEXT, " + FULLNAME + " TEXT NOT NULL, "
            + PHONE + " TEXT, " + PASSWORD + " TEXT NOT NULL, " + AGE + " TEXT, " + GENDER + " TEXT, "
            + ACTIVITY + " TEXT, " + WEIGHT + " TEXT, " + HEIGHT + " TEXT, " + GOAL + " TEXT);";

    public static final String CREATE_FOOD_TABLE = "create table " + FOOD_TABLE + "(" + FOOD_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FOOD_NAME + " TEXT, " + FOOD_CALORIES + " TEXT, "
            + FOOD_FATS + " TEXT, " + FOOD_CARBOHYDRATES + " TEXT, " + FOOD_PROTEIN + " TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_TABLE);
        onCreate(db);
    }
}
