package com.usi.shkurtagashi.energieinformatik.LocalDataStorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.usi.shkurtagashi.energieinformatik.Survey.Survey;
import com.usi.shkurtagashi.energieinformatik.Survey.SurveyContract2;

import java.util.List;


import com.usi.shkurtagashi.energieinformatik.User.User;
import com.usi.shkurtagashi.energieinformatik.User.UsersContract.UserEntry;
import com.usi.shkurtagashi.energieinformatik.Rating.RatingContract.RatingEntry;
import com.usi.shkurtagashi.energieinformatik.Rating.Rating;

import com.usi.shkurtagashi.energieinformatik.Survey.SurveyContract.SurveyEntry;




/**
 * Created by shkurtagashi on 18.12.16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = DatabaseHelper.class.getSimpleName();


    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /** Name of the database file */
    private static final String DATABASE_NAME = "energieinformatik.db";

    // Table Create Statements
    // String that contains the SQL statement to create the Users table
    private static final String SQL_CREATE_USERS_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME_USERS + " ("
            + UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserEntry.ANDROID_ID + " TEXT, "
            + UserEntry.USERNAME + " TEXT, "
            + UserEntry.EMPATICAID + " TEXT, "
            + UserEntry.EMAIL + " TEXT, "
            + UserEntry.COLUMN_GENDER + " TEXT, "
            + UserEntry.COLUMN_AGE + " TEXT, "
            + UserEntry.COLUMN_STATUS + " TEXT);";


    // String that contains the SQL statement to create the Ratings table
    private static final String SQL_CREATE_RATINGS_TABLE = "CREATE TABLE " + RatingEntry.TABLE_NAME_RATINGS + " ("
            + RatingEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + RatingEntry.TIMESTAMP + " REAL, "
            + RatingEntry.PAPER_ID + " INTEGER, "
            + RatingEntry.RATING_VALUE + " TEXT);";


    // String that contains the SQL statement to create the General Survey data table
    private static final String SQL_CREATE_SURVEY_DATA_TABLE = "CREATE TABLE "+ SurveyEntry.TABLE_NAME_SURVEY + "("
            + SurveyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SurveyEntry.TIMESTAMP + " REAL, "
            + SurveyEntry.PAPER_ID + " INTEGER, "
            + SurveyEntry.QUESTION_1 + " TEXT, "
            + SurveyEntry.QUESTION_2 + " TEXT, "
            + SurveyEntry.QUESTION_3 + " TEXT, "
            + SurveyEntry.QUESTION_4 + " TEXT, "
            + SurveyEntry.QUESTION_5 + " TEXT, "
            + SurveyEntry.QUESTION_6 + " TEXT, "
            + SurveyEntry.QUESTION_7 + " TEXT, "
            + SurveyEntry.QUESTION_ENG1 + " TEXT, "
            + SurveyEntry.QUESTION_ENG2 + " TEXT" + ")";

    // String that contains the SQL statement to create the Survey2 table
    private static final String SQL_CREATE_SURVEY2_TABLE = "CREATE TABLE " + SurveyContract2.SurveyEntry2.TABLE_NAME_SURVEY2 + " ("
            + SurveyContract2.SurveyEntry2._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SurveyContract2.SurveyEntry2.TIMESTAMP + " REAL, "
            + SurveyContract2.SurveyEntry2.QUESTION + " TEXT);";

    /**
     * Constructs a new instance of {@link DatabaseHelper}.
     *
     * @param context of the app
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db){
        // Execute the SQL statements
        db.execSQL(SQL_CREATE_USERS_TABLE);
        db.execSQL(SQL_CREATE_RATINGS_TABLE);
        db.execSQL(SQL_CREATE_SURVEY_DATA_TABLE);
        db.execSQL(SQL_CREATE_SURVEY2_TABLE);



//        insertRecords(db, UploaderUtilityTable.TABLE_UPLOADER_UTILITY, UploaderUtilityTable.getRecords());

    }


    private void insertRecords(SQLiteDatabase db, String tableName, List<ContentValues> records) {
        for(ContentValues record: records) {
            db.insert(tableName, null, record);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//        db.execSQL(SQL_DELETE_ENTRIES);
//        onCreate(db);
    }


    private static DatabaseHelper dbhelper;

    //getInstance method used where we need instance of RegDatabaseHandler to insert, update or delete data
    public static synchronized DatabaseHelper getInstance(Context context){
        if(dbhelper == null){
            dbhelper = new DatabaseHelper(context.getApplicationContext());
        }
        return dbhelper;
    }

    public User getUserInformation(String username){
        SQLiteDatabase db = this.getReadableDatabase();

        User user = new User();

        Cursor cursor = db.query(UserEntry.TABLE_NAME_USERS, new String[]{UserEntry.USERNAME, UserEntry.EMPATICAID,
                        UserEntry.COLUMN_GENDER, UserEntry.COLUMN_AGE, UserEntry.COLUMN_STATUS},
                UserEntry.USERNAME +"=?", new String[]{String.valueOf(username)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            user = new User(cursor.getString(cursor.getColumnIndex(UserEntry.USERNAME)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.EMPATICAID)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.EMAIL)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_GENDER)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_AGE)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_STATUS))
            );
            cursor.close();
        }
        return user;
    }

    public User getUserInfo(String androidID){
        SQLiteDatabase db = this.getReadableDatabase();

        User user = new User();

        Cursor cursor = db.query(UserEntry.TABLE_NAME_USERS, new String[]{UserEntry.USERNAME, UserEntry.EMPATICAID, UserEntry.EMAIL,
                        UserEntry.COLUMN_GENDER, UserEntry.COLUMN_AGE, UserEntry.COLUMN_STATUS},
                UserEntry.ANDROID_ID +"=?", new String[]{String.valueOf(androidID)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            user = new User(cursor.getString(cursor.getColumnIndex(UserEntry.USERNAME)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.EMPATICAID)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.EMAIL)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_GENDER)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_AGE)),
                    cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_STATUS))
            );
            cursor.close();
        }
        return user;
    }


    /*
        Add a user into Users table
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.v("DBBBBBBB", "WE HEREEE");


        db.beginTransaction();

        try {
            ContentValues values = new ContentValues();

            values.put(UserEntry.ANDROID_ID, user.getAndroidId());
            values.put(UserEntry.USERNAME, user.getUsername());
            values.put(UserEntry.EMPATICAID, user.getEmpaticaID());
            values.put(UserEntry.EMAIL, user.getEmail());
            values.put(UserEntry.COLUMN_GENDER, user.getGender());
            values.put(UserEntry.COLUMN_AGE, user.getAge());
            values.put(UserEntry.COLUMN_STATUS, user.getStatus());


            db.insertOrThrow(UserEntry.TABLE_NAME_USERS, null, values);
            db.setTransactionSuccessful();
            System.out.println("USER DATA INSERTED: "+ values);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "Error while trying to add USER to database");
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    /*
    Add a rating into Ratings table
 */
    public void addRating(Rating rating, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try {
            ContentValues values = new ContentValues();

            values.put(RatingEntry.TIMESTAMP, rating.getTimestamp());
            values.put(RatingEntry.PAPER_ID, rating.getPaperId());
            values.put(RatingEntry.RATING_VALUE, rating.getRatingValue());


            db.insertOrThrow(RatingEntry.TABLE_NAME_RATINGS, null, values);
            db.setTransactionSuccessful();

            System.out.println("Rating DATA INSERTED: "+ values);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "Error while trying to add RATING to database");
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    /*
        Add a SURVEY into Surveys table
    */
    public void addSurvey(Survey survey, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try {
            ContentValues values = new ContentValues();

            values.put(SurveyEntry.TIMESTAMP, survey.getTimestamp());
            values.put(SurveyEntry.PAPER_ID, survey.getPaperId());
            values.put(SurveyEntry.QUESTION_1, survey.getQuestion1());
            values.put(SurveyEntry.QUESTION_2, survey.getQuestion2());
            values.put(SurveyEntry.QUESTION_3, survey.getQuestion3());
            values.put(SurveyEntry.QUESTION_4, survey.getQuestion4());
            values.put(SurveyEntry.QUESTION_5, survey.getQuestion5());
            values.put(SurveyEntry.QUESTION_6, survey.getQuestion6());
            values.put(SurveyEntry.QUESTION_7, survey.getQuestion7());
            values.put(SurveyEntry.QUESTION_ENG1, survey.getQuestionEng1());
            values.put(SurveyEntry.QUESTION_ENG2, survey.getQuestionEng2());


            db.insertOrThrow(SurveyEntry.TABLE_NAME_SURVEY, null, values);
            db.setTransactionSuccessful();

            System.out.println("Survey DATA INSERTED: "+ values);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "Error while trying to add SURVEY to database");
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    /*
         Add a SURVEY2 into Surveys2 table
     */
    public void addSurvey2(Survey survey, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try {
            ContentValues values = new ContentValues();

            values.put(SurveyContract2.SurveyEntry2.TIMESTAMP, survey.getTimestamp());
            values.put(SurveyContract2.SurveyEntry2.QUESTION, survey.getQuestion7());


            db.insertOrThrow(SurveyContract2.SurveyEntry2.TABLE_NAME_SURVEY2, null, values);
            db.setTransactionSuccessful();

            System.out.println("Survey2 DATA INSERTED: "+ values);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "Error while trying to add SURVEY2 to database");
        } finally {
            db.endTransaction();
            db.close();
        }
    }

}
