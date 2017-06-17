package com.example.mateusz.ready4s.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mateusz.ready4s.R;
import com.example.mateusz.ready4s.activity.PlaceDetailActivity;
import com.example.mateusz.ready4s.adapter.PlacesAdapter;
import com.example.mateusz.ready4s.data.database.PlacesDbHelper;

public class HistoryFragment extends ListFragment {

    PlacesDbHelper db;
    PlacesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        db = new PlacesDbHelper(getContext());
        adapter = new PlacesAdapter(getContext(), db.getAllPlaces(), 0);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        adapter = new PlacesAdapter(getContext(), db.getAllPlaces(), 0);
        setListAdapter(adapter);
        super.onResume();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getContext(), PlaceDetailActivity.class);
        intent.putExtra("id", (int) v.getTag());
        startActivity(intent);
    }
}
