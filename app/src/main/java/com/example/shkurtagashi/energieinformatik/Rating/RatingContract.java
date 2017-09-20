package com.example.shkurtagashi.energieinformatik.Rating;

import android.provider.BaseColumns;

/**
 * Created by shkurtagashi on 9/11/17.
 */

public final class RatingContract {

    // Private constructor to prevent someone from accidentally instantiating the contract class,
    private RatingContract() {}

    /* Inner class that defines the table contents */
    public static final class RatingEntry implements BaseColumns {

        /*
        * Ratings - Table and Columns declaration
         */
        public final static String TABLE_NAME_RATINGS = "ratingsTable";

        public final static String _ID = BaseColumns._ID;
        public final static String PAPER_ID = "paperId";
        public final static String RATING_VALUE = "ratingValue";

        public final static String RATING_TERRIBLE = "Very Bad";
        public final static String RATING_BAD = "Bad";
        public final static String RATING_OKAY = "Okay";
        public final static String RATING_GOOD = "Good";
        public final static String RATING_GREAT = "Great";


        public static String[] getColumns(){
            String[] columns = {_ID, PAPER_ID, RATING_VALUE};

            return columns;
        }



    }
}
