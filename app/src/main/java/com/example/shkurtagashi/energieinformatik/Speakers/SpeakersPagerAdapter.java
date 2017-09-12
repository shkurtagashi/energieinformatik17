package com.example.shkurtagashi.energieinformatik.Speakers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.shkurtagashi.energieinformatik.Program.FifthOctoberSchedule;
import com.example.shkurtagashi.energieinformatik.Program.SixthOctoberSchedule;

/**
 * Created by shkurtagashi on 9/12/17.
 */

public class SpeakersPagerAdapter extends FragmentPagerAdapter {

    public SpeakersPagerAdapter(FragmentManager fm) {
        // Required empty public constructor
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new Keynote1Fragment();
            case 1:
                return new Keynote2Fragment();
            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Keynote 1";
            case 1:
                return "Keynote 2";
            default:
                return null;

        }

    }

}
