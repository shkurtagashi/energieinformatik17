package com.example.shkurtagashi.energieinformatik.Program;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shkurtagashi.energieinformatik.Speakers.SpeakersActivity;
import com.example.shkurtagashi.energieinformatik.Speakers.SpeakersFragment;
import com.example.shkurtagashi.energieinformatik.Papers.PapersActivity;
import com.example.shkurtagashi.energieinformatik.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SixthOctoberSchedule extends Fragment {


    public SixthOctoberSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_sixth_october_schedule, container, false);

        rootview.findViewById(R.id.ripple5).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(getContext(), SpeakersActivity.class));
            }
        });

        rootview.findViewById(R.id.ripple6).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(getContext(), PapersActivity.class));
            }
        });

        rootview.findViewById(R.id.ripple7).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(getContext(), PapersActivity.class));
            }
        });

        return rootview;
    }

}
