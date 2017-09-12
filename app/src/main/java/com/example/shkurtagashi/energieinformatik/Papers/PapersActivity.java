package com.example.shkurtagashi.energieinformatik.Papers;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.andexert.expandablelayout.library.ExpandableLayoutItem;
import com.andexert.expandablelayout.library.ExpandableLayoutListView;
import com.example.shkurtagashi.energieinformatik.CustomAdapter;
import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.R;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;

public class PapersActivity extends AppCompatActivity {

    private static final String TAG = "PapersActivity";

    private SmileRating mSmileRating;

    String[] paperTitlesOctober5 = {"Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices 1","Title 2","Title 3","Title 4","Title 5","Title 6","Title 7","Title 8","Title 9","Title 10"};
    String[] paperAuthorsOctober5 = {"Shkurta F. Gashi","Author 2","Author 3","Author 4","Author 5","Author 6","Author 7","Author 8","Author 9","Author 10"};

    private final static String[] sessions = {"Session 1", "Session 2", "Session 3","Session 4","Session 5"};
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

    SmileRating smileRating1;
    SmileRating smileRating2;
    SmileRating smileRating3;
    SmileRating smileRating4;
    SmileRating smileRating5;

//    Rating r;


    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

//        dbHelper = new DatabaseHelper(this);
//        r = new Rating();
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.view_row, R.id.header_text, sessions);
//        final ExpandableLayoutListView expandableLayoutListView = (ExpandableLayoutListView) findViewById(R.id.listview);
//
//        expandableLayoutListView.setAdapter(arrayAdapter);

        rateButton1 = (Button) findViewById(R.id.rateButton1);
        swipeSelector1 =(SwipeSelector) findViewById(R.id.paper_selector1);
        smileRating1 = (SmileRating) findViewById(R.id.smile_rating1);


        rateButton2 = (Button) findViewById(R.id.rateButton2);
        swipeSelector2 =(SwipeSelector) findViewById(R.id.paper_selector2);
        smileRating2 = (SmileRating) findViewById(R.id.smile_rating2);

        rateButton3 = (Button) findViewById(R.id.rateButton3);
        swipeSelector3 =(SwipeSelector) findViewById(R.id.paper_selector3);
        smileRating3 = (SmileRating) findViewById(R.id.smile_rating3);

        rateButton4 = (Button) findViewById(R.id.rateButton4);
        swipeSelector4 =(SwipeSelector) findViewById(R.id.paper_selector4);
        smileRating4 = (SmileRating) findViewById(R.id.smile_rating4);

        rateButton5 = (Button) findViewById(R.id.rateButton5);
        swipeSelector5 =(SwipeSelector) findViewById(R.id.paper_selector5);
        smileRating5 = (SmileRating) findViewById(R.id.smile_rating5);



        setUpSwipeSelectors();

        rateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeItem selectedItem = swipeSelector1.getSelectedItem();
                String paperId = (String) selectedItem.value;
                Log.v("Fifth frag", "Selected ID:  " + paperId);

//                int ratingValue = smileRating.getRating();

//                Rating r = new Rating();
//                r.setPaperId(paperId);
//                r.setRatingValue(ratingValue);
//                dbHelper.addRating(r);
            }
        });

    }

    private void setUpSwipeSelectors(){
        swipeSelector1.setItems(
                // The first argument is the value for that item, and should in most cases be unique for the
                // current SwipeSelector, just as you would assign values to radio buttons.
                // You can use the value later on to check what the selected item was.
                // The value can be any Object, here we're using ints.
                new SwipeItem(0, "Studying Physiological Synchrony Between Teachers and Students using Mobile and Wearable Devices", "Shkurta Gashi, Elena Di Lascio \n \n \n This is an abstract abstract This is an abstract of the paper This is an abstract of the paper This is an abstract of the paper This is an abstract of the paper This is an abstract of the paper This is an abstract of the paper This is an abstract of the paper"),
                new SwipeItem(1, "Studying whateva between whomeva", "Silvia Santini, Lirak Kadriu, Agon Bexheti"),
                new SwipeItem(2, "Paper three is awesome between awesomeness", "Aferdita Gashi, Shkurta Gashi"),
                new SwipeItem(3, "Paper three", "This is another example of the paper.")
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

    }
}
