package com.example.messenger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataDB {
    private DatabaseHelper databaseHelper;
    private Context ctx;

    public DataDB(Context ctx){
        this.ctx = ctx;
        databaseHelper = new DatabaseHelper(ctx);
    }

    public int getItemCount(){
        String COUNT_QUERY = "SELECT * FROM " + DatabaseHelper.TABLE_DATA;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(COUNT_QUERY,null);
        return cursor.getCount();
    }

    public Data getData(int id){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selection = "id = ?";
        String[] selectionArgs = {"" + id};
        Cursor cursor = db.query(DatabaseHelper.TABLE_DATA,null,selection, selectionArgs,null,null,null);
        cursor.moveToFirst();
        Data data = new Data(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_NAME)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_CHAT)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_IMAGE_URL)));
        cursor.close();
        db.close();
        return data;
    }

    public ArrayList<Data> getAllData(){
        ArrayList<Data> dat = new ArrayList<Data>();
        String QUERY_GET_ALL_DATA = "SELECT * FROM " + DatabaseHelper.TABLE_DATA;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(QUERY_GET_ALL_DATA,null);
        if(cursor.moveToFirst()){
            do{
                Data data = new Data(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_NAME)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_CHAT)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_DATA_IMAGE_URL)));
                dat.add(data);
            }
            while(cursor.moveToNext());
        }
        return dat;
    }

    public void insertData(Data data){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.FIELD_DATA_NAME,data.getName());
        cv.put(DatabaseHelper.FIELD_DATA_CHAT,data.getChat());
        cv.put(DatabaseHelper.FIELD_DATA_IMAGE_URL,data.getImageURL());
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.insert(DatabaseHelper.TABLE_DATA,null,cv);
        db.close();
    }

    public void updateData(Data data){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.FIELD_DATA_NAME,data.getName());
        cv.put(DatabaseHelper.FIELD_DATA_CHAT,data.getChat());
        cv.put(DatabaseHelper.FIELD_DATA_IMAGE_URL,data.getImageURL());
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.update(DatabaseHelper.TABLE_DATA,cv,"id = ?", new String[]{String.valueOf(data.getId())});
        db.close();
    }

}
