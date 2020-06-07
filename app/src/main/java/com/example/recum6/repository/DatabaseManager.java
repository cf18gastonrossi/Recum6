package com.example.recum6.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.recum6.model.Hotel;

public class DatabaseManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DatabaseManager(Context c) {
        context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(Hotel hotel) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.NOMBRE, hotel.getNombre());
        contentValue.put(DatabaseHelper.CIF, hotel.getCif());
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NOMBRE, DatabaseHelper.CIF};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(Hotel hotel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NOMBRE, hotel.getNombre());
        contentValues.put(DatabaseHelper.CIF, hotel.getCif());
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.CIF + " = " + hotel.getCif(), null);
        return i;
    }

    public void delete(String cif) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.CIF + "=" + cif, null);
    }

}
