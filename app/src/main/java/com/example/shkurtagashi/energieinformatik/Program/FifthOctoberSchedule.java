package com.example.shkurtagashi.energieinformatik.Program;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.balysv.materialripple.MaterialRippleLayout;
import com.example.shkurtagashi.energieinformatik.MainActivity;
import com.example.shkurtagashi.energieinformatik.Papers.PapersFragment;
import com.example.shkurtagashi.energieinformatik.Speakers.Keynote1Fragment;
import com.example.shkurtagashi.energieinformatik.Speakers.SpeakersActivity;
import com.example.shkurtagashi.energieinformatik.Speakers.SpeakersFragment;
import com.example.shkurtagashi.energieinformatik.Papers.PapersActivity;
import com.example.shkurtagashi.energieinformatik.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FifthOctoberSchedule extends Fragment{


    public FifthOctoberSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fifth_october_schedule, container, false);


        rootview.findViewById(R.id.ripple).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent((getContext()), SpeakersActivity.class));

            }
        });

        rootview.findViewById(R.id.ripple2).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(getContext(), PapersActivity.class));
            }
        });

        rootview.findViewById(R.id.ripple3).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(getContext(), PapersActivity.class));
            }
        });

        rootview.findViewById(R.id.ripple4).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(getContext(), PapersActivity.class));
            }
        });


        return rootview;
    }



    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, someFragment);
        Log.v("FifthFrag", "We are ehre");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
