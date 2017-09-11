package com.example.shkurtagashi.energieinformatik.Program;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shkurtagashi.energieinformatik.Papers.FifthOctoberFragment;
import com.example.shkurtagashi.energieinformatik.Papers.SixthOctoberFragment;
import com.example.shkurtagashi.energieinformatik.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramFragmentPagerAdapter extends FragmentPagerAdapter {


    public ProgramFragmentPagerAdapter(FragmentManager fm) {
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
                return new FifthOctoberSchedule();
            case 1:
                return new SixthOctoberSchedule();
            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "October 5";
            case 1:
                return "October 6";
            default:
                return null;

        }

    }

}
