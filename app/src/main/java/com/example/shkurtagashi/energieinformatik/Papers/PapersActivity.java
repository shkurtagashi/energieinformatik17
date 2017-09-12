package com.example.shkurtagashi.energieinformatik.Papers;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;

import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;
import com.example.shkurtagashi.energieinformatik.Rating.Rating;

public class PapersActivity extends AppCompatActivity {

    private static final String TAG = "PapersActivity";

    private SmileRating mSmileRating;

    String[] paperTitlesOctober5 = {"Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices 1","Title 2","Title 3","Title 4","Title 5","Title 6","Title 7","Title 8","Title 9","Title 10"};
    String[] paperAuthorsOctober5 = {"Shkurta F. Gashi","Author 2","Author 3","Author 4","Author 5","Author 6","Author 7","Author 8","Author 9","Author 10"};

//    private final static String[] sessions = {"Session 1", "Session 2", "Session 3","Session 4","Session 5"};
    ListView listView;

    Button rateButton1;
    Button rateButton2;
    Button rateButton3;
    Button rateButton4;
    Button rateButton5;

    SwipeSelector swipeSelector1;
    SwipeSelector swipeSelector2;
    SwipeSelector swipeSelector3;
    SwipeSelector swipeSelector4;
    SwipeSelector swipeSelector5;

    RatingBar ratingBar1;

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
        ratingBar1 = (RatingBar) findViewById(R.id.star_rating1) ;

        rateButton2 = (Button) findViewById(R.id.rateButton2);
        swipeSelector2 =(SwipeSelector) findViewById(R.id.paper_selector2);

        rateButton3 = (Button) findViewById(R.id.rateButton3);
        swipeSelector3 =(SwipeSelector) findViewById(R.id.paper_selector3);

        rateButton4 = (Button) findViewById(R.id.rateButton4);
        swipeSelector4 =(SwipeSelector) findViewById(R.id.paper_selector4);

        rateButton5 = (Button) findViewById(R.id.rateButton5);
        swipeSelector5 =(SwipeSelector) findViewById(R.id.paper_selector5);
        
        setUpSwipeSelectors();

        rateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeItem selectedItem = swipeSelector1.getSelectedItem();
                int paperId =  (Integer) selectedItem.value;

                Log.v("Fifth frag", "Selected Rating:  " + ratingBar1.getRating() + "\n \n Selected Paper: " + paperId);

                Rating r = new Rating();
                r.setPaperId(paperId);
                r.setRatingValue(ratingBar1.getRating());
                dbHelper.addRating(r);
            }
        });
    }


    private void setUpSwipeSelectors(){
        swipeSelector1.setItems(
                // The first argument is the value for that item, and should in most cases be unique for the
                // current SwipeSelector, just as you would assign values to radio buttons.
                // You can use the value later on to check what the selected item was.
                // The value can be any Object, here we're using ints.
                new SwipeItem(0, "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices", "Shkurta Gashi, Elena Di Lascio "),
                new SwipeItem(1, "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices", "Shkurta Gashi, Elena Di Lascio "),
                new SwipeItem(2, "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices", "Shkurta Gashi, Elena Di Lascio "),
                new SwipeItem(3, "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices", "Shkurta Gashi, Elena Di Lascio ")
        );


        swipeSelector2.setItems(
                new SwipeItem(4, "Paper 2", "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices"),
                new SwipeItem(5, "Paper two", "Description for slide two."),
                new SwipeItem(6, "Paper three", "Description for slide three."),
                new SwipeItem(7, "Paper three", "Description for slide three.")

        );


        swipeSelector3.setItems(
                new SwipeItem(8, "Paper 3", "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices"),
                new SwipeItem(9, "Paper two", "Description for slide two."),
                new SwipeItem(10, "Paper three", "Description for slide three."),
                new SwipeItem(11, "Paper three", "Description for slide three.")

        );

        swipeSelector4.setItems(
                new SwipeItem(12, "Paper 3", "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices"),
                new SwipeItem(13, "Paper two", "Description for slide two."),
                new SwipeItem(14, "Paper three", "Description for slide three."),
                new SwipeItem(15, "Paper three", "Description for slide three.")

        );

        swipeSelector5.setItems(
                new SwipeItem(16, "Paper 3", "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices"),
                new SwipeItem(17, "Paper two", "Description for slide two."),
                new SwipeItem(18, "Paper three", "Description for slide three."),
                new SwipeItem(19, "Paper three", "Description for slide three.")

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
}
