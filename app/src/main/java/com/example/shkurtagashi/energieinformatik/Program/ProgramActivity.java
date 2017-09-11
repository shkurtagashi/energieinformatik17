package com.example.shkurtagashi.energieinformatik.Program;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shkurtagashi.energieinformatik.Papers.PapersFragmentPagerAdapter;
import com.example.shkurtagashi.energieinformatik.R;

public class ProgramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_program);

        // Create an adapter that knows which fragment should be shown on each page
        ProgramFragmentPagerAdapter adapter = new ProgramFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.program_data_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
