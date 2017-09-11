package com.example.shkurtagashi.energieinformatik.Papers;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shkurtagashi.energieinformatik.CustomAdapter;
import com.example.shkurtagashi.energieinformatik.R;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

public class PapersActivity extends AppCompatActivity {

    private static final String TAG = "PapersActivity";

    private SmileRating mSmileRating;

    String[] paperTitlesOctober5 = {"Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices 1","Title 2","Title 3","Title 4","Title 5","Title 6","Title 7","Title 8","Title 9","Title 10"};
    String[] paperAuthorsOctober5 = {"Shkurta F. Gashi","Author 2","Author 3","Author 4","Author 5","Author 6","Author 7","Author 8","Author 9","Author 10"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager2);

        // Create an adapter that knows which fragment should be shown on each page
        PapersFragmentPagerAdapter adapter = new PapersFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.papers_data_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
