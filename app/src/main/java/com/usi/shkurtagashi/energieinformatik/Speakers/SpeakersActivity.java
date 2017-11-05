package com.usi.shkurtagashi.energieinformatik.Speakers;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.usi.shkurtagashi.energieinformatik.R;

public class SpeakersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_speakers);

        // Create an adapter that knows which fragment should be shown on each page
        SpeakersPagerAdapter adapter = new SpeakersPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.speakers_data_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
}

