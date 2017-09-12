package com.example.shkurtagashi.energieinformatik;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

/**
 * Created by shkurtagashi on 9/10/17.
 */

public class CustomAdapter extends BaseAdapter implements SmileRating.OnSmileySelectionListener, SmileRating.OnRatingSelectedListener{

    private static final String TAG = "CustomAdapter";

    Context context;
    String [] paperTitlesOctober5;
    String[] paperAuthorsOctober5;

    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] titlesList, String[] authorsList) {
        this.context = applicationContext;
        this.paperTitlesOctober5 = titlesList;
        this.paperAuthorsOctober5 = authorsList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return paperTitlesOctober5.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.listview, null);
        TextView title = view.findViewById(R.id.paper_title);
        TextView author = view.findViewById(R.id.paper_author);
//        LinearLayout smileRate = view.findViewById(R.id.smile_rating);


        title.setText(paperTitlesOctober5[i]);
        author.setText(paperAuthorsOctober5[i]);

        SmileRating sRating = new SmileRating(context);

        for(int j=0; j <paperTitlesOctober5.length; j++){
            if(sRating.getParent()!= null){
                ((ViewGroup)sRating.getParent()).removeView(sRating);
            }
//            smileRate.addView(sRating);
//            smileRate.setId(j);
        }

        return view;
    }

    @Override
    public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
        switch (smiley) {
            case SmileRating.BAD:
                Log.i(TAG, "Bad");
                break;
            case SmileRating.GOOD:
                Log.i(TAG, "Good");
                break;
            case SmileRating.GREAT:
                Log.i(TAG, "Great");
                break;
            case SmileRating.OKAY:
                Log.i(TAG, "Okay");
                break;
            case SmileRating.TERRIBLE:
                Log.i(TAG, "Terrible");
                break;
            case SmileRating.NONE:
                Log.i(TAG, "None");
                break;
        }
    }

    @Override
    public void onRatingSelected(int level, boolean reselected) {
        Log.i(TAG, "Rated as: " + level + " - " + reselected);
    }
}
