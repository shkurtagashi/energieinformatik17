package com.example.shkurtagashi.energieinformatik.Papers;

import android.provider.BaseColumns;

/**
 * Created by shkurtagashi on 9/19/17.
 */

public class SurveyContract {

    // Private constructor to prevent someone from accidentally instantiating the contract class,
    private SurveyContract() {}

    /* Inner class that defines the table contents */
    public static final class SurveyEntry implements BaseColumns {

        public final static String TABLE_NAME_SURVEY = "surveyTable";

        public final static String _ID = BaseColumns._ID;
        public final static String TIMESTAMP = "timestamp";
        public final static String PAPER_ID = "paperId";
        public final static String QUESTION_1 = "question1";
        public final static String QUESTION_2 = "question2";
        public final static String QUESTION_3 = "question3";
        public final static String QUESTION_4 = "question4";
        public final static String QUESTION_5 = "question5";
        public final static String QUESTION_6 = "question6";
        public final static String QUESTION_7 = "question7";

        /**
         * Possible values for the question's answers of the teacher
         */
        public static final int ANSWER_1 = 1;
        public static final int ANSWER_2 = 2;
        public static final int ANSWER_3 = 3;
        public static final int ANSWER_4 = 4;
        public static final int ANSWER_5 = 5;
        public static final int ANSWER_6 = 6;
        public static final int ANSWER_7 = 7;

        public static final String ASK_QUESTION = "Asked question- ";
        public static final String MAKE_PHOTO = "Took a picture- ";
        public static final String CLAP_HANDS = "Clapped hands- ";
        public static final String CHECK_EMAIL = "Check you email- ";
        public static final String OTHER = "Other ";



        public static String[] getColumns(){
            String[] columns = {_ID, TIMESTAMP, PAPER_ID, QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4, QUESTION_5, QUESTION_6, QUESTION_7};

            return columns;
        }



    }
}
