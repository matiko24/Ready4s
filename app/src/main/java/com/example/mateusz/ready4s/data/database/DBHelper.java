package com.example.mateusz.ready4s.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Mateusz on 2017-06-15.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ready4s.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Place.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllPlaces() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + Place.PlaceEntry.PLACE_TABLE_NAME + " ORDER BY timestamp desc", null);
    }

    public com.example.mateusz.ready4s.data.model.Place getPlaceById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Place.PlaceEntry.PLACE_TABLE_NAME, null, Place.PlaceEntry._ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        com.example.mateusz.ready4s.data.model.Place place = null;
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            place = new com.example.mateusz.ready4s.data.model.Place(String.valueOf(cursor.getInt(0)), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3), cursor.getString(4));
        }
        return place;
    }

    public void insertPlace(int id, String avatarUrl, Double lat, Double lng, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (getPlaceById(id) == null) {
            ContentValues values = new ContentValues();
            values.put(Place.PlaceEntry._ID, id);
            values.put(Place.PlaceEntry.PLACE_AVATAR_URL, avatarUrl);
            values.put(Place.PlaceEntry.PLACE_LAT, lat);
            values.put(Place.PlaceEntry.PLACE_LNG, lng);
            values.put(Place.PlaceEntry.PLACE_NAME, name);
            db.insert(Place.PlaceEntry.PLACE_TABLE_NAME, null, values);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date date = new Date();
            String s = dateFormat.format(date);
            ContentValues values = new ContentValues();
            values.put(Place.PlaceEntry.TIME_STAMP, s);
            db.update(Place.PlaceEntry.PLACE_TABLE_NAME, values, Place.PlaceEntry._ID + "=" + id, null);
        }
    }
}
