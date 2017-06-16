package com.example.mateusz.ready4s;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    MyPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        setActionBarTitle("Mapa");

        //getBaseContext().deleteDatabase(DBHelper.DATABASE_NAME);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(ResourcesCompat.getColor(getResources(), R.color.colorSelected, null));
        tabLayout.setTabTextColors(ResourcesCompat.getColor(getResources(), R.color.colorUnselectedText, null), ResourcesCompat.getColor(getResources(), R.color.colorSelectedText, null));

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapterViewPager.getTabView(i, getBaseContext()));
            }
        }
        tabLayout.getTabAt(0).getCustomView().setSelected(true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    setActionBarTitle("Mapa");
                } else
                    setActionBarTitle("Ostatnio oglądane");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setActionBarTitle(String title) {
        TextView actionBarTitle = (TextView) findViewById(getResources().getIdentifier("action_bar_title", "id", getPackageName()));
        actionBarTitle.setText(title);

    }
}
