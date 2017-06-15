package com.example.mateusz.ready4s;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Mateusz on 2017-06-15.
 */

public class DetailsFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String avatar = getActivity().getIntent().getExtras().getString("avatar");
        Double lat = getActivity().getIntent().getExtras().getDouble("lat");
        Double lng = getActivity().getIntent().getExtras().getDouble("lng");

        ImageView avatarImage = (ImageView) getActivity().findViewById(R.id.avatar_image);
        TextView latTV = (TextView) getActivity().findViewById(R.id.lat_textview);
        TextView lngTV = (TextView) getActivity().findViewById(R.id.lng_textview);

        latTV.setText(String.valueOf(lat));
        lngTV.setText(String.valueOf(lng));
        Picasso.with(getContext()).load(avatar).into(avatarImage);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);


        return view;
    }
}
