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
public class FifthOctoberSchedule extends Fragment{
    Bundle bundle;
    ImageButton paper11pdf,paper12pdf,paper13pdf,paper14pdf,paper15pdf;
    ImageButton paper21pdf, paper22pdf, paper23pdf,paper24pdf;
    ImageButton paper31pdf,paper32pdf,paper33pdf,paper34pdf,paper35pdf;



    public FifthOctoberSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fifth_october_schedule, container, false);

        paper11pdf = (ImageButton) rootview.findViewById(R.id.paper11pdf);
        paper12pdf = (ImageButton) rootview.findViewById(R.id.paper12pdf);
        paper13pdf = (ImageButton) rootview.findViewById(R.id.paper13pdf);
        paper14pdf = (ImageButton) rootview.findViewById(R.id.paper14pdf);
        paper15pdf = (ImageButton) rootview.findViewById(R.id.paper15pdf);

        paper21pdf = (ImageButton) rootview.findViewById(R.id.paper21pdf);
        paper22pdf = (ImageButton) rootview.findViewById(R.id.paper22pdf);
        paper23pdf = (ImageButton) rootview.findViewById(R.id.paper23pdf);
        paper24pdf = (ImageButton) rootview.findViewById(R.id.paper24pdf);


        paper31pdf = (ImageButton) rootview.findViewById(R.id.paper31pdf);
        paper32pdf = (ImageButton) rootview.findViewById(R.id.paper32pdf);
        paper33pdf = (ImageButton) rootview.findViewById(R.id.paper33pdf);
        paper34pdf = (ImageButton) rootview.findViewById(R.id.paper34pdf);
        paper35pdf = (ImageButton) rootview.findViewById(R.id.paper35pdf);

        paper11pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0345-8"));
                startActivity(browserIntent);
            }
        });

        paper12pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0346-7"));
                startActivity(browserIntent);
            }
        });

        paper13pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0362-7"));
                startActivity(browserIntent);
            }
        });

        paper14pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0379-y"));
                startActivity(browserIntent);
            }
        });

        paper15pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0359-2"));
                startActivity(browserIntent);
            }
        });

        paper21pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0353-8"));
                startActivity(browserIntent);
            }
        });

        paper22pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0351-x"));
                startActivity(browserIntent);
            }
        });

        paper23pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.springerprofessional.de/en/exploring-zero-training-algorithms-for-occupancy-detection-based/14958374"));
                startActivity(browserIntent);
            }
        });

        paper24pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0381-4"));
                startActivity(browserIntent);
            }
        });


        paper31pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0350-y"));
                startActivity(browserIntent);
            }
        });
        paper32pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0355-6"));
                startActivity(browserIntent);
            }
        });
        paper33pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0343-x"));
                startActivity(browserIntent);
            }
        });
        paper34pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0352-9"));
                startActivity(browserIntent);
            }
        });
        paper35pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://link.springer.com/article/10.1007/s00450-017-0342-y"));
                startActivity(browserIntent);
            }
        });

        bundle = new Bundle();

        setUpPaperListeners(rootview, R.id.session1, "Paper 1 of Session 1");
        setUpPaperListeners(rootview, R.id.paper11, "Paper 1 of Session 1");
        setUpPaperListeners(rootview, R.id.paper12, "Paper 2 of Session 1");
        setUpPaperListeners(rootview, R.id.paper13, "Paper 3 of Session 1");
        setUpPaperListeners(rootview, R.id.paper14, "Paper 4 of Session 1");
        setUpPaperListeners(rootview, R.id.paper15, "Paper 5 of Session 1");

        setUpPaperListeners(rootview, R.id.session2, "Paper 1 of Session 2");
        setUpPaperListeners(rootview, R.id.paper21, "Paper 1 of Session 2");
        setUpPaperListeners(rootview, R.id.paper22, "Paper 2 of Session 2");
        setUpPaperListeners(rootview, R.id.paper23, "Paper 3 of Session 2");
        setUpPaperListeners(rootview, R.id.paper24, "Paper 4 of Session 2");

        setUpPaperListeners(rootview, R.id.session3, "Paper 1 of Session 3");
        setUpPaperListeners(rootview, R.id.paper31, "Paper 1 of Session 3");
        setUpPaperListeners(rootview, R.id.paper32, "Paper 2 of Session 3");
        setUpPaperListeners(rootview, R.id.paper33, "Paper 3 of Session 3");
        setUpPaperListeners(rootview, R.id.paper34, "Paper 4 of Session 3");
        setUpPaperListeners(rootview, R.id.paper35, "Paper 5 of Session 3");

        View ripple = rootview.findViewById(R.id.ripple);
        ripple.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent((getContext()), SpeakersActivity.class));
            }
        });


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
