package com.usi.shkurtagashi.energieinformatik.LocalDataStorage;


import com.usi.shkurtagashi.energieinformatik.Survey.SurveyContract;
import com.usi.shkurtagashi.energieinformatik.Rating.RatingContract;
import com.usi.shkurtagashi.energieinformatik.Survey.SurveyContract2;
import com.usi.shkurtagashi.energieinformatik.User.UsersContract;


/**
 * Created by usi on 18/01/17.
 */

public class LocalDbUtility {
    private final static int DATA_TABLES_COUNT = 4;

    public static int getDataTablesCount() {
        return DATA_TABLES_COUNT;
    }

    public static String getTableName(LocalTables table) {
        switch (table) {
            case TABLE_NAME_USERS:
                return UsersContract.UserEntry.TABLE_NAME_USERS;
            case TABLE_NAME_SURVEY:
                return SurveyContract.SurveyEntry.TABLE_NAME_SURVEY;
            case TABLE_NAME_RATINGS:
                return RatingContract.RatingEntry.TABLE_NAME_RATINGS;
            case TABLE_NAME_SURVEY2:
                return SurveyContract2.SurveyEntry2.TABLE_NAME_SURVEY2;
            default:
                return null;
        }
    }

    public static String[] getTableColumns(LocalTables table) {
        switch (table) {
            case TABLE_NAME_USERS:
                return UsersContract.UserEntry.getColumns();
            case TABLE_NAME_SURVEY:
                return SurveyContract.SurveyEntry.getColumns();
            case TABLE_NAME_RATINGS:
                return RatingContract.RatingEntry.getColumns();
            case TABLE_NAME_SURVEY2:
                return SurveyContract2.SurveyEntry2.getColumns();
            default:
                return null;
        }
    }

}
