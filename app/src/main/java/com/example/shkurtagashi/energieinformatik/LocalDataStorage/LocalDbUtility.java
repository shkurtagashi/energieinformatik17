package com.example.shkurtagashi.energieinformatik.LocalDataStorage;


import com.example.shkurtagashi.energieinformatik.User.UsersContract;


/**
 * Created by usi on 18/01/17.
 */

public class LocalDbUtility {
    private final static int DATA_TABLES_COUNT = 5;

    public static int getDataTablesCount() {
        return DATA_TABLES_COUNT;
    }

    public static String getTableName(LocalTables table) {
        switch (table) {
            case TABLE_NAME_USERS:
                return UsersContract.UserEntry.TABLE_NAME_USERS;
            default:
                return null;
        }
    }

    public static String[] getTableColumns(LocalTables table) {
        switch (table) {
            case TABLE_NAME_USERS:
                return UsersContract.UserEntry.getColumns();
            default:
                return null;
        }
    }

}
