package com.example.shkurtagashi.energieinformatik.Papers;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;
import com.example.shkurtagashi.energieinformatik.Rating.Rating;

public class PapersActivity extends AppCompatActivity {

    private static final String TAG = "PapersActivity";


    Button rateButton1, rateButton2, rateButton3, rateButton4, rateButton5;

    SwipeSelector swipeSelector1, swipeSelector2, swipeSelector3, swipeSelector4, swipeSelector5;
    RatingBar ratingBar1, ratingBar2, ratingBar3, ratingBar4, ratingBar5;

    Rating r;

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

        dbHelper = new DatabaseHelper(this);
        r = new Rating();

        rateButton1 = (Button) findViewById(R.id.rateButton1);
        swipeSelector1 =(SwipeSelector) findViewById(R.id.paper_selector1);
        ratingBar1 = (RatingBar) findViewById(R.id.star_rating1);
//        surveyButton1 = (Button) findViewById(R.id.surveyButton1);

        rateButton2 = (Button) findViewById(R.id.rateButton2);
        swipeSelector2 =(SwipeSelector) findViewById(R.id.paper_selector2);
        ratingBar2 = (RatingBar) findViewById(R.id.star_rating2);


        rateButton3 = (Button) findViewById(R.id.rateButton3);
        swipeSelector3 =(SwipeSelector) findViewById(R.id.paper_selector3);
        ratingBar3 = (RatingBar) findViewById(R.id.star_rating3);


        rateButton4 = (Button) findViewById(R.id.rateButton4);
        swipeSelector4 =(SwipeSelector) findViewById(R.id.paper_selector4);
        ratingBar4 = (RatingBar) findViewById(R.id.star_rating4);


        rateButton5 = (Button) findViewById(R.id.rateButton5);
        swipeSelector5 =(SwipeSelector) findViewById(R.id.paper_selector5);
        ratingBar5 = (RatingBar) findViewById(R.id.star_rating5);

        setUpSwipeSelectors();
        setUpButtonListeners(rateButton1, swipeSelector1, ratingBar1);
        setUpButtonListeners(rateButton2, swipeSelector2, ratingBar2);
        setUpButtonListeners(rateButton3, swipeSelector3, ratingBar3);
        setUpButtonListeners(rateButton4, swipeSelector4, ratingBar4);
        setUpButtonListeners(rateButton5, swipeSelector5, ratingBar5);

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

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButton5(View view) {
        expandableLayout5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }


    public void feedbackMessage(){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PapersActivity.this);
        alertDialog.setTitle("Rating Paper");
        alertDialog.setMessage("Are you sure you want to save the rating for this paper?");
        alertDialog.setIcon(R.drawable.logo);

        alertDialog.setNegativeButton(R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.addRating(r, getApplicationContext());
                        Toast.makeText(getApplicationContext(), "Thank you!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SurveyActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("paperID", r.getPaperId());
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
