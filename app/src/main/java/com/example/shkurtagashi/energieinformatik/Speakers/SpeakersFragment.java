package com.example.shkurtagashi.energieinformatik.Speakers;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shkurtagashi.energieinformatik.R;
import com.example.shkurtagashi.energieinformatik.Speakers.SpeakersPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakersFragment extends Fragment {


    public SpeakersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_speakers, container, false);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) rootview.findViewById(R.id.viewpager_speakers);

        // Create an adapter that knows which fragment should be shown on each page
        SpeakersPagerAdapter adapter = new SpeakersPagerAdapter(getChildFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) rootview.findViewById(R.id.speakers_data_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        return rootview;
    }

}
