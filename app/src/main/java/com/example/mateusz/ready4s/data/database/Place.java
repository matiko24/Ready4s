package com.example.mateusz.ready4s.data.database;

import android.provider.BaseColumns;

/**
 * Created by Mateusz on 2017-06-15.
 */

public class Place {

    private Place() {
    }

    public static class PlaceEntry implements BaseColumns {
        public static final String PLACE_TABLE_NAME = "place";
        public static final String PLACE_AVATAR_URL = "avatar";
        public static final String PLACE_LNG = "lng";
        public static final String PLACE_LAT = "lat";
        public static final String PLACE_NAME = "name";
        public static final String TIME_STAMP = "timestamp";
    }

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + PlaceEntry.PLACE_TABLE_NAME + " (" +
                    PlaceEntry._ID + " INTEGER PRIMARY KEY," +
                    PlaceEntry.PLACE_AVATAR_URL + " STRING," +
                    PlaceEntry.PLACE_LAT + " REAL," +
                    PlaceEntry.PLACE_LNG + " REAL," +
                    PlaceEntry.PLACE_NAME + " STRING," +
                    PlaceEntry.TIME_STAMP + " DATE DEFAULT CURRENT_TIMESTAMP)";
}
