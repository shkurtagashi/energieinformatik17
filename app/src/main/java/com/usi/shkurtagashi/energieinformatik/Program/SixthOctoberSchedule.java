package com.usi.shkurtagashi.energieinformatik.Program;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.usi.shkurtagashi.energieinformatik.Speakers.SpeakersActivity;
import com.usi.shkurtagashi.energieinformatik.Papers.PapersActivity;
import com.usi.shkurtagashi.energieinformatik.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SixthOctoberSchedule extends Fragment {
    Bundle bundle;

    ImageButton paper41pdf, paper42pdf, paper43pdf,paper44pdf;
    ImageButton paper51pdf,paper52pdf,paper53pdf,paper54pdf,paper55pdf;




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

        paper41pdf = (ImageButton) rootview.findViewById(R.id.pape41pdf);
        paper42pdf = (ImageButton) rootview.findViewById(R.id.pape42pdf);
        paper43pdf = (ImageButton) rootview.findViewById(R.id.pape43pdf);
        paper44pdf = (ImageButton) rootview.findViewById(R.id.pape44pdf);


        paper51pdf = (ImageButton) rootview.findViewById(R.id.pape51pdf);
        paper52pdf = (ImageButton) rootview.findViewById(R.id.pape52pdf);
        paper53pdf = (ImageButton) rootview.findViewById(R.id.pape53pdf);
        paper54pdf = (ImageButton) rootview.findViewById(R.id.pape54pdf);
        paper55pdf = (ImageButton) rootview.findViewById(R.id.pape55pdf);

        paper41pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0348-5"));
                startActivity(browserIntent);
            }
        });

        paper42pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0360-9"));
                startActivity(browserIntent);
            }
        });

        paper43pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0357-4"));
                startActivity(browserIntent);
            }
        });

        paper44pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0358-3"));
                startActivity(browserIntent);
            }
        });


        paper51pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0354-7"));
                startActivity(browserIntent);
            }
        });
        paper52pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0349-4"));
                startActivity(browserIntent);
            }
        });
        paper53pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0361-8"));
                startActivity(browserIntent);
            }
        });
        paper54pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0356-5"));
                startActivity(browserIntent);
            }
        });
        paper55pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0347-6"));
                startActivity(browserIntent);
            }
        });

        bundle = new Bundle();

        setUpPaperListeners(rootview, R.id.session4, "Paper 1 of Session 4");
        setUpPaperListeners(rootview, R.id.paper41, "Paper 1 of Session 4");
        setUpPaperListeners(rootview, R.id.paper42, "Paper 2 of Session 4");
        setUpPaperListeners(rootview, R.id.paper43, "Paper 3 of Session 4");
        setUpPaperListeners(rootview, R.id.paper44, "Paper 4 of Session 4");

        setUpPaperListeners(rootview, R.id.session5, "Paper 1 of Session 5");
        setUpPaperListeners(rootview, R.id.paper51, "Paper 1 of Session 5");
        setUpPaperListeners(rootview, R.id.paper52, "Paper 2 of Session 5");
        setUpPaperListeners(rootview, R.id.paper53, "Paper 3 of Session 5");
        setUpPaperListeners(rootview, R.id.paper54, "Paper 4 of Session 5");
        setUpPaperListeners(rootview, R.id.paper55, "Paper 5 of Session 5");

        return rootview;
    }

    public void setUpPaperListeners(View rootview, int viewId, final String paper){
        rootview.findViewById(viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), PapersActivity.class);
                bundle.putString("paper", paper);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

}
