package com.example.messenger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DataDB";
    private static final int DB_VERSION = 1;

    public static final String TABLE_DATA = "data";
    public static final String FIELD_DATA_ID = "id";
    public static final String FIELD_DATA_NAME = "name";
    public static final String FIELD_DATA_CHAT = "chat";
    public static final String FIELD_DATA_IMAGE_URL = "image_url";

    private static final String CREATE_TABLE_DATA =
            "CREATE TABLE IF NOT EXISTS " + TABLE_DATA + "(" +
                    FIELD_DATA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FIELD_DATA_NAME + " TEXT, " +
                    FIELD_DATA_CHAT + " TEXT," +
                    FIELD_DATA_IMAGE_URL + " TEXT);";

    private static final String DROP_TABLE_DATA = "DROP TABLE IF EXISTS " + TABLE_DATA + ";";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_DATA);
        onCreate(db);
    }
}

