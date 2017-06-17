package com.example.mateusz.ready4s.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mateusz.ready4s.R;
import com.example.mateusz.ready4s.data.model.MyLatLng;

/**
 * Created by Mateusz on 2017-06-15.
 */

public class PlacesAdapter extends CursorAdapter {
    public PlacesAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row_place_list, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView placeData = (TextView) view.findViewById(R.id.place_name);
        TextView coordinates = (TextView) view.findViewById(R.id.place_coordinates);

        placeData.setText(cursor.getString(4));
        coordinates.setText(MyLatLng.getLatLngAsStringWithNSWE(cursor.getDouble(2), cursor.getDouble(3)));
        view.setTag(cursor.getInt(0));
    }
}
