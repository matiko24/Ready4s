package com.example.mateusz.ready4s.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.mateusz.ready4s.R;
import com.example.mateusz.ready4s.fragment.HistoryFragment;
import com.example.mateusz.ready4s.fragment.MapFragment;

/**
 * Created by Mateusz on 2017-06-13.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 2;

    private final String[] tabsTitle = {"Mapa", "Ostatnie"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public View getTabView(int position, Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_view_pager, null);
        TextView title = (TextView) view.findViewById(R.id.navigation_title);
        title.setText(tabsTitle[position]);
        return view;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MapFragment();
            case 1:
                return new HistoryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

}
