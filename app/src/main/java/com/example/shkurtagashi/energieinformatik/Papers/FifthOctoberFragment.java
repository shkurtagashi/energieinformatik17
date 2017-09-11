package com.example.shkurtagashi.energieinformatik.Papers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.shkurtagashi.energieinformatik.CustomAdapter;
import com.example.shkurtagashi.energieinformatik.R;
import com.hsalf.smilerating.SmileRating;

/**
 * A simple {@link Fragment} subclass.
 */
public class FifthOctoberFragment extends Fragment {

    private SmileRating mSmileRating;

    String[] paperTitlesOctober5 = {"Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices 1","Title 2","Title 3","Title 4","Title 5","Title 6","Title 7","Title 8","Title 9","Title 10"};
    String[] paperAuthorsOctober5 = {"Shkurta F. Gashi","Author 2","Author 3","Author 4","Author 5","Author 6","Author 7","Author 8","Author 9","Author 10"};

    ListView listView;


    public FifthOctoberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_fifth_october, container, false);

        CustomAdapter adapter = new CustomAdapter(getContext(), paperTitlesOctober5, paperAuthorsOctober5);

        listView = (ListView) rootview.findViewById(R.id.fifthOctober_list);
        listView.setAdapter(adapter);

        return rootview;

    }

}
