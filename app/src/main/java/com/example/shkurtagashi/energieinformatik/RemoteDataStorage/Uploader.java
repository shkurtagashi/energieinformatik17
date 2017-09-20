package com.example.shkurtagashi.energieinformatik.RemoteDataStorage;

/**
 *
 * Code partially contributed from Luca Dotti
 */

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.LocalDataStorage.LocalDbUtility;
import com.example.shkurtagashi.energieinformatik.LocalDataStorage.LocalStorageController;
import com.example.shkurtagashi.energieinformatik.LocalDataStorage.LocalTables;
import com.example.shkurtagashi.energieinformatik.User.UserData;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Uploader {
    private DatabaseHelper dbHelper;
    private RemoteStorageController switchDriveController;
    private LocalStorageController localController;
    private LocalTables tableToClean;
    private String userId;

    public Uploader(String userId, RemoteStorageController remoteController, LocalStorageController localController, DatabaseHelper dbHelper) {
        this.switchDriveController = remoteController;
        this.localController = localController;
        //the start table to clean
        tableToClean = LocalTables.values()[0];
        //user id is the phone id
        this.userId = userId;
        this.dbHelper = dbHelper;
    }

    /**
     * Upload function to upload Users tables' data to Switch Drive
     * Local Tables: Users, Survey, Ratings
     *
     */
//    public int uploadUsersTable(){
//        int response = 0;
//        //number of tables
//        Cursor c;
//        //current table to clean
//        LocalTables currTable;
//        String fileName;
//
//        currTable = LocalTables.values()[0];
//
//        //build name of Users file to upload
//        fileName = buildUsersFileName(currTable);
//
//        //get all data currently in the table
//        c = getRecords(currTable);
//
//        if (c.getCount() > 0) {
//            c.moveToFirst();
//
//            //upload the data to the server
//            response = switchDriveController.upload(fileName, toCSV(c, currTable));
//
//            //if the file was put, delete records and update the arrays
//            if (response >= 200 && response <= 207) {
//                response = 200;
//            } else {
//                response = 404;
//                Log.d("DATA UPLOAD SERVICE", "Owncould's response: " + Integer.toString(response));
//            }
//        }
//
//        return response;
//    }


    /**
     * Upload function to upload local tables' data to Switch Drive
     * Local Tables: Users, Eda, Acc, Bvp, Temp
     *
     */
    public int upload(){
        int response = 0;
        //number of tables
        int nbTableToClean = LocalTables.values().length;
        int i = 0; //Start it from EDA table not USERS table **********************
        Cursor c;
        //current table to clean
        LocalTables currTable;
        String fileName;

        while(i < nbTableToClean) {
            currTable = LocalTables.values()[i];

            //build name of file to upload
            fileName = buildFileName(currTable);

            //get all data currently in the table
            c = getRecords(currTable);

            if (c.getCount() > 0) {
                c.moveToFirst();

                //upload the data to the server
                response = switchDriveController.upload(fileName, toCSV(c, currTable));

                //if the file was put, delete records and update the arrays
                if (response >= 200 && response <= 207) {
                    response = 200;
                    //delete from the db the records where id > startId and id <= endId
    //                    if(currTable.name() == "TABLE_NAME_ACC_DATA"){
    //                        dbHelper.deleteAllFromTable(AccSensorContract.AccSensorDataEntry.TABLE_NAME_ACC_DATA);
    //                    }else if(currTable.name().equals("TABLE_NAME_BVP_DATA")){
    //                        dbHelper.deleteAllFromTable(BvpSensorContract.BvpSensorDataEntry.TABLE_NAME_BVP_DATA);
    //                    }else if(currTable.name().equals("TABLE_NAME_EDA_DATA")){
    //                        dbHelper.deleteAllFromTable(EdaSensorContract.EdaSensorDataEntry.TABLE_NAME_EDA_DATA);
    //                    }else if(currTable.name().equals("TABLE_NAME_TEMP_DATA")){
    //                        dbHelper.deleteAllFromTable(TempSensorContract.TempSensorDataEntry.TABLE_NAME_TEMP_DATA);
    //                    }
                } else {
                    response=404;
                    Log.d("DATA UPLOAD SERVICE", "Owncould's response: " + Integer.toString(response));
                }
            }
            i++;
        }

        return response;
    }


    /**
     * Generate the csv data from the given cursor (Local Tables)
     *
     * @param records
     * @param table
     * @return
     */
    private String toCSV(Cursor records, LocalTables table) {
        String csv = "";
        String[] columns = LocalDbUtility.getTableColumns(table);

        for(int i = 0; i < columns.length; i++) {
            csv += columns[i] + ",";
        }

        csv = csv.substring(0, csv.length()-1);
        csv += "\n";

        do {
            for(int i = 0; i < columns.length; i++) {
                csv += records.getString(i) + ",";
            }
            csv = csv.substring(0, csv.length()-1);
            csv += "\n";
        } while(records.moveToNext());
        csv = csv.substring(0, csv.length()-1);

        return csv;
    }



    /**
     * Build the file name.
     *
     * <subjectid>_<date>_<table>_<username>.csv
     *
     * @param table
     * @return
     */
    private String buildUsersFileName(LocalTables table) {
        //get current date
        String today = buildDate();
        String fileName = today + "_" + UserData._username + "_" + userId + "_" + LocalDbUtility.getTableName(table) + ".csv";
        return fileName;
    }

    /**
     * Build the file name.
     *
     * <subjectid>_<date>_<table>_<username>.csv
     *
     * @param table
     * @return
     */
    private String buildFileName(LocalTables table) {
        //get current date
        String today = buildDate();
        String fileName = today + "_" + userId + "_" + LocalDbUtility.getTableName(table) + ".csv";
        return fileName;
    }


    /*
    * Utility function to get the string representation of the today date.
    * @return
    */
    private String buildDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("MM-dd-yyyy");
        return mdformat.format(calendar.getTime());
    }

    /*
    * Build the query to select all records from the given local table.
    * @param table
     */
    private Cursor getRecords(LocalTables table) {
        String query = "SELECT * FROM " + LocalDbUtility.getTableName(table);
        return localController.rawQuery(query, null);
    }

    /**
     * Build the query to remove the records from the given table, where primary key id in ]start, end].
     *
     * @param table
     * @param start
     * @param end
     */
    private void removeRecords(LocalTables table, int start, int end) {
        Log.d("UPLOAD DATA SERVICE", "Removing from " + Integer.toString(start) + " to " + Integer.toString(end));

        String clause = LocalDbUtility.getTableColumns(table)[0] + " > " + Integer.toString(start) + " AND " +
                LocalDbUtility.getTableColumns(table)[0] + " <= " + Integer.toString(end);
        localController.delete(LocalDbUtility.getTableName(table), clause);
    }
}