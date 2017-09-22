package com.example.shkurtagashi.energieinformatik.Papers;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.Papers.PapersActivity;
import com.example.shkurtagashi.energieinformatik.Papers.SurveyActivity;
import com.example.shkurtagashi.energieinformatik.R;
import com.example.shkurtagashi.energieinformatik.Rating.Rating;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;


/**
 * A simple {@link Fragment} subclass.
 */
public class PapersFragment extends Fragment {

    Button rateButton1, rateButton2, rateButton3, rateButton4, rateButton5;

    SwipeSelector swipeSelector1, swipeSelector2, swipeSelector3, swipeSelector4, swipeSelector5;
    RatingBar ratingBar1, ratingBar2, ratingBar3, ratingBar4, ratingBar5;

    Rating r;

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5;
    DatabaseHelper dbHelper;

    View rootview;

    String paperTitle;
    String paperAuthor;


    public PapersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_papers, container, false);

        dbHelper = new DatabaseHelper(getContext());
        r = new Rating();

        rateButton1 = rootview.findViewById(R.id.rateButton1);
        swipeSelector1 = rootview.findViewById(R.id.paper_selector1);
        ratingBar1 = rootview.findViewById(R.id.star_rating1);

        rateButton2 = rootview.findViewById(R.id.rateButton2);
        swipeSelector2 = rootview.findViewById(R.id.paper_selector2);
        ratingBar2 = rootview.findViewById(R.id.star_rating2);


        rateButton3 = rootview.findViewById(R.id.rateButton3);
        swipeSelector3 = rootview.findViewById(R.id.paper_selector3);
        ratingBar3 = rootview.findViewById(R.id.star_rating3);


        rateButton4 = rootview.findViewById(R.id.rateButton4);
        swipeSelector4 = rootview.findViewById(R.id.paper_selector4);
        ratingBar4 = rootview.findViewById(R.id.star_rating4);


        rateButton5 = rootview.findViewById(R.id.rateButton5);
        swipeSelector5 = rootview.findViewById(R.id.paper_selector5);
        ratingBar5 =  rootview.findViewById(R.id.star_rating5);

        expandableLayout1 = rootview.findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse

        setUpSwipeSelectors();
        setUpButtonListeners(rateButton1, swipeSelector1, ratingBar1);
        setUpButtonListeners(rateButton2, swipeSelector2, ratingBar2);
        setUpButtonListeners(rateButton3, swipeSelector3, ratingBar3);
        setUpButtonListeners(rateButton4, swipeSelector4, ratingBar4);
        setUpButtonListeners(rateButton5, swipeSelector5, ratingBar5);


        return rootview;
    }


    /**
     *
     */
    private void setUpButtonListeners(Button b, final SwipeSelector s, final RatingBar rb){
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeItem selectedItem = s.getSelectedItem();
                int paperId =  (Integer) selectedItem.value;
                paperTitle = selectedItem.title;
                paperAuthor = selectedItem.description;


                Log.v("PapersActivity", "Selected Rating:  " + rb.getRating() + "\n \n Selected Paper: " + paperId);

                r.setPaperId(paperId);
                r.setRatingValue(rb.getRating());

                feedbackMessage();

            }
        });

    }

    private void setUpSwipeSelectors(){
        swipeSelector1.setItems(
                // The first argument is the value for that item, and should in most cases be unique for the
                // current SwipeSelector, just as you would assign values to radio buttons.
                // You can use the value later on to check what the selected item was.
                // The value can be any Object, here we're using ints.
                new SwipeItem(1, "Using Locally Produced Photovoltaic Energy to Charge Electric Vehicles", "René Buffat"),
                new SwipeItem(2, "Modeling and Simulation of Local Flexibilities and their Effect to the Entire Power System", "Lukas Exel"),
                new SwipeItem(3, "Including a Virtual Battery Storage into Thermal Unit Commitment", "David Steber"),
                new SwipeItem(4, "Smart Grid Co-Simulation with MOSAIK and HLA: A Comparison Study", "Cornelius Steinbrink"),
                new SwipeItem(5, "Result processing approaches for large smart grid co-simulations", "Frank Marten")

        );


        swipeSelector2.setItems(
                new SwipeItem(6, "NIWM: Non-intrusive water monitoring to uncover heat energy use in households", "Samuel Schöb"),
                new SwipeItem(7, "PROMT: Predicting Occupancy Presence in Multiple Resolution with Time Shift Agnostic Classification", "Fisayo Caleb Sangogboye"),
                new SwipeItem(8, "Exploring Zero-Training Algorithms for Occupancy Detection based on Smart Meter Measurements", "Vincent Becker"),
                new SwipeItem(9, "Phase preserving Profile Generation from Measurement Data by Clustering and Performance Analysis", "Paul Zehetbauer")

        );


        swipeSelector3.setItems(
                new SwipeItem(10, "Automated Deserializer Generation from CIM Ontologies", "Lukas Razik"),
                new SwipeItem(11, "Integrating distribution system operator system landscapes", "Dominik Ascher"),
                new SwipeItem(12, "A Comprehensive Modelling Framework for Demand Side Flexibility in Smart Grids", "Nicole Ludwig"),
                new SwipeItem(13, "Efficiently Solving DSM Problems - Are We There Yet?", "Florian Salah"),
                new SwipeItem(14, "A Threat Analysis of the Vehicle-to-Grid Charging Protocol ISO 15118", "Kaibin Bao")

        );

        swipeSelector4.setItems(

                new SwipeItem(15, "Privacy-preserving Blockchain-based Electric Vehicle Charging with Dynamic Tariff Decisions", "Fabian Knirsch"),
                new SwipeItem(16, "A Blockchain-Based Smart Grid: Towards Sustainable Local Energy Markets", "Esther Mengelkamp"),
                new SwipeItem(17, "Exploiting Flexibility in Smart Grids at Scale", "Lukas Barth"),
                new SwipeItem(18, "Using Demand Side Management and CHP in renewable dominated decentral energy systems", "Niklas Hartmann")

        );

        swipeSelector5.setItems(
                new SwipeItem(19, "Economic nonlinear MPC for a population of thermostatically controlled loads", "Nikita Zemtsov"),
                new SwipeItem(20, "Understanding Price Functions to Control Domestic Electric Water Heaters for Demand Response", "Tobias Lübkert"),
                new SwipeItem(21, "Provision of Frequency Containment Reserve with an Aggregate of Air Handling Units", "Julian Rominger"),
                new SwipeItem(22, "A Market-Based Smart Grid Approach to Doubling the Power Grid Capacity Without Physical Grid Expansion", "Gwendolin Wilke"),
                new SwipeItem(23, "Shaping aggregated load profiles based on optimized local scheduling of home appliances", "Christoph Hunziker")



        );

    }

//    public void expandableButton1(View view) {
//        expandableLayout1 = (ExpandableRelativeLayout) rootview.findViewById(R.id.expandableLayout1);
//        expandableLayout1.toggle(); // toggle expand and collapse
//    }
//
//    public void expandableButton2(View view) {
//        expandableLayout2 = (ExpandableRelativeLayout) rootview.findViewById(R.id.expandableLayout2);
//        expandableLayout2.toggle(); // toggle expand and collapse
//    }
//
//    public void expandableButton3(View view) {
//        expandableLayout3 = (ExpandableRelativeLayout) rootview.findViewById(R.id.expandableLayout3);
//        expandableLayout3.toggle(); // toggle expand and collapse
//    }
//
//    public void expandableButton4(View view) {
//        expandableLayout4 = (ExpandableRelativeLayout) rootview.findViewById(R.id.expandableLayout4);
//        expandableLayout4.toggle(); // toggle expand and collapse
//    }
//
//    public void expandableButton5(View view) {
//        expandableLayout5 = (ExpandableRelativeLayout) rootview.findViewById(R.id.expandableLayout5);
//        expandableLayout5.toggle(); // toggle expand and collapse
//    }


    public void feedbackMessage(){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Submit Rating");
        alertDialog.setMessage("Rating submission requires completion of a survey regarding the presentation of this paper. Do you want to continue?");
        alertDialog.setIcon(R.drawable.logo);

        alertDialog.setNegativeButton(R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.addRating(r, getContext());
                        Toast.makeText(getContext(), "Thank you!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), SurveyActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("paperID", r.getPaperId());
                        bundle.putString("paperTitle", paperTitle);
                        bundle.putString("paperAuthor", paperAuthor);

                        Log.v("PapersAct", r.getPaperId()+"");
                        intent.putExtras(bundle);

                        startActivity(intent);
                    }
                });

        alertDialog.setPositiveButton(R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

}
