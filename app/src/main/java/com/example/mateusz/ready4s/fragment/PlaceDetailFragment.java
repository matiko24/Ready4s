package com.example.mateusz.ready4s.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mateusz.ready4s.R;
import com.example.mateusz.ready4s.data.database.PlacesDbHelper;
import com.example.mateusz.ready4s.data.model.MyLatLng;
import com.example.mateusz.ready4s.data.model.Place;
import com.squareup.picasso.Picasso;

/**
 * Created by Mateusz on 2017-06-15.
 */

public class PlaceDetailFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView avatarImage = (ImageView) getActivity().findViewById(R.id.avatar_image);
        TextView nameTV = (TextView) getActivity().findViewById(R.id.place_name_textview);
        TextView latTV = (TextView) getActivity().findViewById(R.id.place_lat_textview);
        TextView lngTV = (TextView) getActivity().findViewById(R.id.place_lng_textview);

        int placeId = getActivity().getIntent().getExtras().getInt("id");
        Place place = getPlaceById(placeId);

        Picasso.with(getContext()).load(place.getAvatar()).into(avatarImage);
        nameTV.setText(place.getName());
        latTV.setText(MyLatLng.getLatAsStringWithNS(place.getLat()));
        lngTV.setText(MyLatLng.getLngAsStringWithWE(place.getLng()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_detail, container, false);
        return view;
    }

    public Place getPlaceById(int placeId) {
        PlacesDbHelper db = new PlacesDbHelper(getContext());
        return db.getPlaceById(placeId);
    }
}
