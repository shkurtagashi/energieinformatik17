package com.usi.shkurtagashi.energieinformatik.Papers;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.swipeselector.OnSwipeItemSelectedListener;
import com.usi.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.usi.shkurtagashi.energieinformatik.R;
import com.usi.shkurtagashi.energieinformatik.Survey.SurveyActivity;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;
import com.usi.shkurtagashi.energieinformatik.Rating.Rating;

import java.util.Calendar;
import java.util.Date;

public class PapersActivity extends AppCompatActivity {

    private static final String TAG = "PapersActivity";


    TextView ratePaperPlease, ratePaperPlease2, ratePaperPlease3, ratePaperPlease4, ratePaperPlease5;
    CheckBox presenceChecbox1, presenceChecbox2, presenceChecbox3, presenceChecbox4, presenceChecbox5;
    Button rateButton1, rateButton2, rateButton3, rateButton4, rateButton5;
    SwipeSelector swipeSelector1, swipeSelector2, swipeSelector3, swipeSelector4, swipeSelector5;
    RatingBar ratingBar1, ratingBar2, ratingBar3, ratingBar4, ratingBar5;

    Rating r;

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5;
    DatabaseHelper dbHelper;

    String paperTitle;
    String paperAuthor;

    Bundle extras;
    String session, paper;

    Date currentTimestamp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

        dbHelper = new DatabaseHelper(this);
        r = new Rating();
        currentTimestamp = Calendar.getInstance().getTime();


        rateButton1 = (Button) findViewById(R.id.rateButton1);
        swipeSelector1 =(SwipeSelector) findViewById(R.id.paper_selector1);
        ratingBar1 = (RatingBar) findViewById(R.id.star_rating1);
//        surveyButton1 = (Button) findViewById(R.id.surveyButton1);

        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout11);
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout21);
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout31);
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout41);
        expandableLayout5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout51);

        rateButton1 = (Button) findViewById(R.id.rateButton1);
        swipeSelector1 = (SwipeSelector) findViewById(R.id.paper_selector1);
        ratingBar1 = (RatingBar)findViewById(R.id.star_rating1);
        presenceChecbox1 = (CheckBox) findViewById(R.id.presence1);
        ratePaperPlease = (TextView) findViewById(R.id.ratePaperPlease);


        rateButton2 =(Button) findViewById(R.id.rateButton2);
        swipeSelector2 = (SwipeSelector)findViewById(R.id.paper_selector2);
        ratingBar2 = (RatingBar)findViewById(R.id.star_rating2);
        presenceChecbox2 = (CheckBox) findViewById(R.id.presence2);
        ratePaperPlease2 = (TextView) findViewById(R.id.ratePaperPlease2);



        rateButton3 = (Button)findViewById(R.id.rateButton3);
        swipeSelector3 =(SwipeSelector) findViewById(R.id.paper_selector3);
        ratingBar3 = (RatingBar)findViewById(R.id.star_rating3);
        presenceChecbox3 = (CheckBox) findViewById(R.id.presence3);
        ratePaperPlease3 = (TextView) findViewById(R.id.ratePaperPlease3);



        rateButton4 = (Button)findViewById(R.id.rateButton4);
        swipeSelector4 = (SwipeSelector)findViewById(R.id.paper_selector4);
        ratingBar4 = (RatingBar)findViewById(R.id.star_rating4);
        presenceChecbox4 = (CheckBox) findViewById(R.id.presence4);
        ratePaperPlease4 = (TextView) findViewById(R.id.ratePaperPlease4);



        rateButton5 = (Button)findViewById(R.id.rateButton5);
        swipeSelector5 = (SwipeSelector)findViewById(R.id.paper_selector5);
        ratingBar5 =  (RatingBar) findViewById(R.id.star_rating5);
        presenceChecbox5 = (CheckBox) findViewById(R.id.presence5);
        ratePaperPlease5 = (TextView) findViewById(R.id.ratePaperPlease5);


        setUpSwipeSelectors();

        setUpCheckboxListeners(presenceChecbox1, ratingBar1, rateButton1, ratePaperPlease);
        setUpCheckboxListeners(presenceChecbox2, ratingBar2, rateButton2, ratePaperPlease2);
        setUpCheckboxListeners(presenceChecbox3, ratingBar3, rateButton3, ratePaperPlease3);
        setUpCheckboxListeners(presenceChecbox4, ratingBar4, rateButton4, ratePaperPlease4);
        setUpCheckboxListeners(presenceChecbox5, ratingBar5, rateButton5, ratePaperPlease5);

        setUpButtonListeners(rateButton1, swipeSelector1, ratingBar1);
        setUpButtonListeners(rateButton2, swipeSelector2, ratingBar2);
        setUpButtonListeners(rateButton3, swipeSelector3, ratingBar3);
        setUpButtonListeners(rateButton4, swipeSelector4, ratingBar4);
        setUpButtonListeners(rateButton5, swipeSelector5, ratingBar5);

        setUpSwipeListeners(swipeSelector1, ratingBar1, rateButton1, ratePaperPlease, presenceChecbox1);
        setUpSwipeListeners(swipeSelector2, ratingBar2, rateButton2, ratePaperPlease2, presenceChecbox2);
        setUpSwipeListeners(swipeSelector3, ratingBar3, rateButton3, ratePaperPlease3, presenceChecbox3);
        setUpSwipeListeners(swipeSelector4, ratingBar4, rateButton4, ratePaperPlease4, presenceChecbox4);
        setUpSwipeListeners(swipeSelector5, ratingBar5, rateButton5, ratePaperPlease5, presenceChecbox5);

        Intent intent = getIntent();
        if(intent.hasExtra("paper")){
            extras = getIntent().getExtras();
            if(extras.getString("paper") != null){
                paper = extras.getString("paper");
                if(!paper.isEmpty()){
                    switch (paper){
                        case "Paper 1 of Session 1":
                            expandableLayout1.setExpanded(true);
                            swipeSelector1.selectItemAt(0);
                            break;
                        case "Paper 2 of Session 1":
                            expandableLayout1.setExpanded(true);
                            swipeSelector1.selectItemAt(1);
                            break;
                        case "Paper 3 of Session 1":
                            expandableLayout1.setExpanded(true);
                            swipeSelector1.selectItemAt(2);
                            break;
                        case "Paper 4 of Session 1":
                            expandableLayout1.setExpanded(true);
                            swipeSelector1.selectItemAt(3);
                            break;
                        case "Paper 5 of Session 1":
                            expandableLayout1.setExpanded(true);
                            swipeSelector1.selectItemAt(4);
                            break;
                        case "Paper 1 of Session 2":
                            expandableLayout2.setExpanded(true);
                            swipeSelector2.selectItemAt(0);
                            break;
                        case "Paper 2 of Session 2":
                            expandableLayout2.setExpanded(true);
                            swipeSelector2.selectItemAt(1);
                            break;
                        case "Paper 3 of Session 2":
                            expandableLayout2.setExpanded(true);
                            swipeSelector2.selectItemAt(2);
                            break;
                        case "Paper 4 of Session 2":
                            expandableLayout2.setExpanded(true);
                            swipeSelector2.selectItemAt(3);
                            break;
                        case "Paper 1 of Session 3":
                            expandableLayout3.setExpanded(true);
                            swipeSelector3.selectItemAt(0);
                            break;
                        case "Paper 2 of Session 3":
                            expandableLayout3.setExpanded(true);
                            swipeSelector3.selectItemAt(1);
                            break;
                        case "Paper 3 of Session 3":
                            expandableLayout3.setExpanded(true);
                            swipeSelector3.selectItemAt(2);
                            break;
                        case "Paper 4 of Session 3":
                            expandableLayout3.setExpanded(true);
                            swipeSelector3.selectItemAt(3);
                            break;
                        case "Paper 5 of Session 3":
                            expandableLayout3.setExpanded(true);
                            swipeSelector3.selectItemAt(4);
                            break;
                        case "Paper 1 of Session 4":
                            expandableLayout4.setExpanded(true);
                            swipeSelector4.selectItemAt(0);
                            break;
                        case "Paper 2 of Session 4":
                            expandableLayout4.setExpanded(true);
                            swipeSelector4.selectItemAt(1);
                            break;
                        case "Paper 3 of Session 4":
                            expandableLayout4.setExpanded(true);
                            swipeSelector4.selectItemAt(2);
                            break;
                        case "Paper 4 of Session 4":
                            expandableLayout4.setExpanded(true);
                            swipeSelector4.selectItemAt(3);
                            break;
                        case "Paper 1 of Session 5":
                            expandableLayout5.setExpanded(true);
                            swipeSelector5.selectItemAt(0);
                            break;
                        case "Paper 2 of Session 5":
                            expandableLayout5.setExpanded(true);
                            swipeSelector5.selectItemAt(1);
                            break;
                        case "Paper 3 of Session 5":
                            expandableLayout5.setExpanded(true);
                            swipeSelector5.selectItemAt(2);
                            break;
                        case "Paper 4 of Session 5":
                            expandableLayout5.setExpanded(true);
                            swipeSelector5.selectItemAt(3);
                            break;
                        case "Paper 5 of Session 5":
                            expandableLayout5.setExpanded(true);
                            swipeSelector5.selectItemAt(4);
                            break;

                    }
                }
            }
        }

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

                r.setTimestamp(currentTimestamp+"");
                r.setPaperId(paperId);
                r.setRatingValue(rb.getRating());

                feedbackMessage();

            }
        });

    }


    private void setUpSwipeListeners(SwipeSelector s, final RatingBar rb, final Button b, final TextView t, final CheckBox c){
        s.setOnItemSelectedListener(new OnSwipeItemSelectedListener() {
            @Override
            public void onItemSelected(SwipeItem item) {
                if(rb.getVisibility() == View.GONE){
                    rb.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);
                    t.setVisibility(View.VISIBLE);
                    c.setChecked(false);
                }else{
                    rb.setRating(0);
                }
            }
        });
    }

    private void setUpCheckboxListeners(final CheckBox c, final RatingBar rb, final Button b, final TextView t){
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c.isChecked()) {
                    rb.setVisibility(View.GONE);
                    b.setVisibility(View.GONE);
                    t.setVisibility(View.GONE);
                }else{
                    rb.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);
                    t.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    private void setUpSwipeSelectors(){
        swipeSelector1.setItems(
                // The first argument is the value for that item, and should in most cases be unique for the
                // current SwipeSelector, just as you would assign values to radio buttons.
                // You can use the value later on to check what the selected item was.
                // The value can be any Object, here we're using ints.
                new SwipeItem(1, "Using Locally Produced Photovoltaic Energy to Charge Electric Vehicles", "René Buffat (ETH Zürich, CH)\nDominik Bucher (ETH Zürich, CH)"),
                new SwipeItem(2, "Modeling and Simulation of Local Flexibilities and their Effect to the Entire Power System", "Lukas Exel (Saarland University, DE)"),
                new SwipeItem(3, "Including a Virtual Battery Storage into Thermal Unit Commitment", "Reinhard German (FAU Erlangen-Nürnberg, DE)"),
                new SwipeItem(4, "Smart Grid Co-Simulation with MOSAIK and HLA: A Comparison Study", "Cornelius Steinbrink (OFFIS – Oldenburg Institute for Information Technology, DE)"),
                new SwipeItem(5, "Result processing approaches for large smart grid co-simulations", "Mike Vogt (Fraunhofer IWES, DE)")

        );


        swipeSelector2.setItems(
                new SwipeItem(6, "NIWM: Non-intrusive water monitoring to uncover heat energy use in households", "Karl Regensburger (LAGRAR, AT)"),
                new SwipeItem(7, "PROMT: Predicting Occupancy Presence in Multiple Resolution with Time Shift Agnostic Classification", "Fisayo Caleb Sangogboye (University of Southern Denmark, DK)"),
                new SwipeItem(8, "Exploring Zero-Training Algorithms for Occupancy Detection based on Smart Meter Measurements", "Vincent Becker (ETH Zürich, CH)"),
                new SwipeItem(9, "Phase preserving Profile Generation from Measurement Data by Clustering and Performance Analysis", "Paul Zehetbauer (AIT – Austrian Institute of Technology, AT)")

        );


        swipeSelector3.setItems(
                new SwipeItem(10, "Automated Deserializer Generation from CIM Ontologies", "Lukas Razik (RWTH Aachen, DE)"),
                new SwipeItem(11, "Integrating distribution system operator system landscapes", "Dominik Ascher (TU Munich, DE)"),
                new SwipeItem(12, "A Comprehensive Modelling Framework for Demand Side Flexibility in Smart Grids", "Nicole Ludwig (KIT, DE)"),
                new SwipeItem(13, "Efficiently Solving DSM Problems - Are We There Yet?", "Marc Schmidt (KIT, DE)"),
                new SwipeItem(14, "A Threat Analysis of the Vehicle-to-Grid Charging Protocol ISO 15118", "Kaibin Bao (KIT, DE)\nManuela Wagner(KIT, DE)")

        );

        swipeSelector4.setItems(

                new SwipeItem(15, "Privacy-preserving Blockchain-based Electric Vehicle Charging with Dynamic Tariff Decisions", "Fabian Knirsch (Salzburg University of Applied Sciences, AT)"),
                new SwipeItem(16, "A Blockchain-Based Smart Grid: Towards Sustainable Local Energy Markets", "Esther Mengelkamp (KIT, DE)"),
                new SwipeItem(17, "Exploiting Flexibility in Smart Grids at Scale", "Lukas Barth (KIT, DE)"),
                new SwipeItem(18, "Using Demand Side Management and CHP in renewable dominated decentral energy systems", "Niklas Hartmann (Fraunhofer Institute for Solar Energy Systems ISE, DE)")

        );

        swipeSelector5.setItems(
                new SwipeItem(19, "Economic nonlinear MPC for a population of thermostatically controlled loads", "Nikita Zemtsov (Technical University of Liberec, CZ)"),
                new SwipeItem(20, "Understanding Price Functions to Control Domestic Electric Water Heaters for Demand Response", "Tobias Lübkert  (Hamburg University of Technology, DE)"),
                new SwipeItem(21, "Provision of Frequency Containment Reserve with an Aggregate of Air Handling Units", "Julian Rominger (FZI Research Center for Information Technology Karlsruhe, DE)"),
                new SwipeItem(22, "A Market-Based Smart Grid Approach to Doubling the Power Grid Capacity Without Physical Grid Expansion", "Holger Wache (University of Applied Sciences and Arts Northwestern Switzerland, CH)"),
                new SwipeItem(23, "Shaping aggregated load profiles based on optimized local scheduling of home appliances", "Christoph Hunziker (University of Applied Sciences Northwestern Switzerland, CH)")
        );

    }

    public void expandableButton11(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout11);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton21(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout21);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton31(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout31);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton41(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout41);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButton51(View view) {
        expandableLayout5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout51);
        expandableLayout5.toggle(); // toggle expand and collapse
    }


    public void feedbackMessage(){

//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PapersActivity.this);
//        alertDialog.setTitle("Rating Paper");
//        alertDialog.setMessage("Are you sure you want to save the rating for this paper?");
//        alertDialog.setIcon(R.drawable.logo);
//
//        alertDialog.setNegativeButton(R.string.yes,
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.addRating(r, getApplicationContext());
                        Toast.makeText(getApplicationContext(), "Thank you!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SurveyActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("paperID", r.getPaperId());
                        bundle.putString("paperTitle", paperTitle);
                        bundle.putString("paperAuthor", paperAuthor);

                        Log.v("PapersAct", r.getPaperId()+"");
                        intent.putExtras(bundle);

                        startActivity(intent);
//                    }
//                });
//
//        alertDialog.setPositiveButton(R.string.no,
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//
//        alertDialog.show();
    }
}
