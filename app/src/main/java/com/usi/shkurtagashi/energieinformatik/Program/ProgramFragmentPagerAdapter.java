package com.usi.shkurtagashi.energieinformatik.Program;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
