package com.example.shkurtagashi.energieinformatik.Program;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.shkurtagashi.energieinformatik.CustomAdapter;
import com.example.shkurtagashi.energieinformatik.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FifthOctoberSchedule extends Fragment {


    public FifthOctoberSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fifth_october_schedule, container, false);


        

        return rootview;
    }

}
