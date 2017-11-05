package com.usi.shkurtagashi.energieinformatik.Survey;

import android.provider.BaseColumns;

/**
 * Created by shkurtagashi on 9/25/17.
 */

public class SurveyContract2 {
    // Private constructor to prevent someone from accidentally instantiating the contract class,
    private SurveyContract2() {}

    /* Inner class that defines the table contents */
    public static final class SurveyEntry2 implements BaseColumns {

        public final static String TABLE_NAME_SURVEY2 = "surveyTable2";

        public final static String _ID = BaseColumns._ID;
        public final static String TIMESTAMP = "timestamp";
        public final static String QUESTION = "question";

        public static String[] getColumns(){
            String[] columns = {_ID, TIMESTAMP, QUESTION};

            return columns;
        }
    }
}
