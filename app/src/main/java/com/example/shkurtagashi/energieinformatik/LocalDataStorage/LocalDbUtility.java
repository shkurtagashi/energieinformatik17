package com.example.shkurtagashi.energieinformatik.LocalDataStorage;


import com.example.shkurtagashi.energieinformatik.Papers.SurveyContract;
import com.example.shkurtagashi.energieinformatik.Rating.RatingContract;
import com.example.shkurtagashi.energieinformatik.User.UsersContract;


/**
 * Created by usi on 18/01/17.
 */

public class LocalDbUtility {
    private final static int DATA_TABLES_COUNT = 3;

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
            default:
                return null;
        }
    }

}
