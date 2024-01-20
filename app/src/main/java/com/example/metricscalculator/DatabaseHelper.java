package com.example.metricscalculator;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAppDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Define the user registration table schema
    private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EDUCATION = "education";
    private static final String COLUMN_CONNECTED = "connected"; // Added column for user connection status

    private static final String TABLE_SST = "SST";
    private static final String COLUMN_SST_ID = "id";
    private static final String COLUMN_SST_USER_ID = "user_id"; // Foreign key
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_RESULTS = "results";
    private static final String TABLE_BBS = "BBS";
    private static final String COLUMN_BBS_ID = "bbs_id";
    private static final String COLUMN_BBS_USER_ID = "user_id"; // Foreign key
    private static final String COLUMN_SITTING_TO_STANDING = "sitting_to_standing";
    private static final String COLUMN_STANDING_UNSUPPORTED = "standing_unsupported";
    private static final String COLUMN_SITTING_UNSUPPORTED = "sitting_unsupported";
    private static final String COLUMN_STANDING_TO_SITTING = "standing_to_sitting";
    private static final String COLUMN_TRANSFERS = "transfers";
    private static final String COLUMN_STANDING_WITH_EYES_CLOSED = "standing_with_eyes_closed";
    private static final String COLUMN_STANDING_WITH_FEET_TOGETHER = "standing_with_feet_together";
    private static final String COLUMN_REACHING_FORWARD_WITH_OUTSTRETCHED_ARM = "reaching_forward_with_outstretched_arm";
    private static final String COLUMN_RETRIEVING_OBJECT_FROM_FLOOR = "retrieving_object_from_floor";
    private static final String COLUMN_TURNING_TO_LOOK_BEHIND = "turning_to_look_behind";
    private static final String COLUMN_TURNING_360_DEGREES = "turning_360_degrees";
    private static final String COLUMN_PLACING_ALTERNATE_FOOT_ON_STOOL = "placing_alternate_foot_on_stool";
    private static final String COLUMN_STANDING_WITH_ONE_FOOT_IN_FRONT = "standing_with_one_foot_in_front";
    private static final String COLUMN_STANDING_ON_ONE_FOOT = "standing_on_one_foot";
    private static final String COLUMN_TOTAL = "total";
    public static final String TABLE_FRT = "frt";
    public static final String COLUMN_FRT_ID = "frt_id";
    public static final String COLUMN_FRT_USER_ID = "user_id";
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_RESULT = "result";
    public static final String TABLE_TUG = "tug";
    public static final String COLUMN_TUG_ID = "tug_id";
    public static final String COLUMN_TUG_USER_ID = "user_id";
    public static final String COLUMN_TIMEINSECONDS = "timeinseconds";
    public static final String COLUMN_TUG_RESULT = "result";
    public static final String TABLE_MOCA = "moca";
    public static final String COLUMN_MOCA_ID = "moca_id";
    public static final String COLUMN_MOCA_USER_ID = "user_id";
    public static final String COLUMN_OPTICOCHORIKES = "opticochorikes";
    public static final String COLUMN_KATONOMASIA = "ktonomasia";
    public static final String COLUMN_PROSOXI1 = "prosoxi1";
    public static final String COLUMN_PROSOXI2 = "prosoxi2";
    public static final String COLUMN_PROSOXI3 = "prosoxi3";
    public static final String COLUMN_GLOSSA = "glossa";
    public static final String COLUMN_ROI = "roi";
    public static final String COLUMN_AFAIROTIKI_SKEPSI = "afairotiki_skepsi";
    public static final String COLUMN_KATISTIMENI_ANAKLISI = "katistimeni_anaklisi";
    public static final String COLUMN_PROSANAFORELISMO = "prosanaforlismo";
    public static final String COLUMN_MOCA_RESULTS = "results";
    public static final String TABLE_MMSE = "mmse";
    public static final String COLUMN_MMSE_ID = "mmse_id";
    public static final String COLUMN_MMSE_USER_ID = "user_id";
    public static final String COLUMN_ORIENTATION = "orientation";
    public static final String COLUMN_REGISTRATION = "registration";
    public static final String COLUMN_ATTENTIONANDCALCULATION = "attentionandcalculation";
    public static final String COLUMN_RECALL = "recall";
    public static final String COLUMN_LANGUAGE = "language";
    public static final String COLUMN_MMSE_RESULTS = "results";
    public static final String TABLE_TRAIL = "trail";
    public static final String COLUMN_TRAIL_ID = "trail_id";
    public static final String COLUMN_TRAIL_USER_ID = "user_id";
    public static final String COLUMN_PARTA = "parta";
    public static final String COLUMN_PARTB = "partb";
    public static final String COLUMN_TRAIL_AGE = "age";
    public static final String COLUMN_TRAIL_RESULT = "result";
    public static final String TABLE_DIGIT_SPAN = "digit_span";
    public static final String COLUMN_DIGIT_SPAN_ID = "digit_span_id";
    public static final String COLUMN_DIGIT_SPAN_USER_ID = "user_id";
    public static final String COLUMN_LENGTH = "length";
    public static final String COLUMN_PRESENTED = "presented";
    public static final String COLUMN_RESPONSE = "response";
    public static final String COLUMN_DIGIT_SPAN_RESULT = "result";
    public static final String TABLE_STROOP = "stroop";
    public static final String COLUMN_STROOP_ID = "stroop_id";
    public static final String COLUMN_STROOP_USER_ID = "user_id";
    public static final String COLUMN_CONGRUENT = "congruent";
    public static final String COLUMN_INCOGRUENT = "incogruent";
    public static final String COLUMN_STROOP_EFFECT = "stroop_effect";
    public static final String TABLE_SUS = "sus";
    public static final String COLUMN_SUS_ID = "sus_id";
    public static final String COLUMN_SUS_USER_ID = "user_id";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_MULTIPLIED_SCORE = "multiplied_score";
    public static final String COLUMN_SUS_RESULT = "result";
    public static final String TABLE_IGEQ = "igeq";
    public static final String COLUMN_IGEQ_ID = "igeq_id";
    public static final String COLUMN_IGEQ_USER_ID = "user_id";
    public static final String COLUMN_COMPETENCE = "competence";
    public static final String COLUMN_IMMERSION = "immersion";
    public static final String COLUMN_FLOW = "flow";
    public static final String COLUMN_TENSION = "tension";
    public static final String COLUMN_CHALLENGE = "challenge";
    public static final String COLUMN_NEGATIVE = "negative";
    public static final String COLUMN_POSITIVE = "positive";
    public static final String TABLE_PACES = "paces";
    public static final String COLUMN_PACES_ID = "paces_id";
    public static final String COLUMN_PACES_USER_ID = "user_id";
    public static final String COLUMN_ITEM1 = "item1";
    public static final String COLUMN_ITEM2 = "item2";
    public static final String COLUMN_ITEM3 = "item3";
    public static final String COLUMN_ITEM4 = "item4";
    public static final String COLUMN_ITEM5 = "item5";
    public static final String COLUMN_ITEM6 = "item6";
    public static final String COLUMN_ITEM7 = "item7";
    public static final String COLUMN_ITEM8 = "item8";
    public static final String COLUMN_ITEM9 = "item9";
    public static final String COLUMN_ITEM10 = "item10";
    public static final String COLUMN_ITEM11 = "item11";
    public static final String COLUMN_ITEM12 = "item12";
    public static final String COLUMN_ITEM13 = "item13";
    public static final String COLUMN_ITEM14 = "item14";
    public static final String COLUMN_ITEM15 = "item15";
    public static final String COLUMN_ITEM16 = "item16";
    public static final String COLUMN_ITEM17 = "item17";
    public static final String COLUMN_ITEM18 = "item18";
    public static final String COLUMN_SUM = "sum";
    public static final String TABLE_TECHNOLOGY_ACCEPTANCE = "technology_acceptance";
    public static final String COLUMN_TECHNOLOGY_ACCEPTANCE_ID = "technology_acceptance_id";
    public static final String COLUMN_TECHNOLOGY_ACCEPTANCE_USER_ID = "user_id";
    public static final String COLUMN_TAM1 = "tam1";
    public static final String COLUMN_TAM2 = "tam2";
    public static final String COLUMN_TAM3 = "tam3";
    public static final String COLUMN_TAM4 = "tam4";
    public static final String COLUMN_TAM5 = "tam5";
    public static final String COLUMN_TAM6 = "tam6";
    public static final String COLUMN_TAM7 = "tam7";
    public static final String COLUMN_TAM8 = "tam8";
    public static final String COLUMN_TAM9 = "tam9";
    public static final String COLUMN_TAM10 = "tam10";
    public static final String COLUMN_TAM11 = "tam11";
    public static final String COLUMN_TAM12 = "tam12";
    public static final String COLUMN_PU = "pu";
    public static final String COLUMN_PEU = "peu";
    public static final String TABLE_CSRT = "csrt";
    public static final String COLUMN_CSRT_ID = "csrt_id";
    public static final String COLUMN_CSRT_USER_ID = "user_id";
    public static final String COLUMN_CSRT_GENDER = "gender";
    public static final String COLUMN_CSRT_AGE = "age";
    public static final String COLUMN_REACTION_TIME = "reaction_time";
    public static final String TABLE_SUBSTITUTION = "substitution";
    public static final String COLUMN_SUBSTITUTION_ID = "substitution_id";
    public static final String COLUMN_SUBSTITUTION_USER_ID = "user_id";
    public static final String COLUMN_SUBSTITUTION_CORRECT = "correct";
    public static final String COLUMN_SUBSTITUTION_RESPONSE_TIME = "response_time";
    // Define the SQL statement to create the user registration table
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " ("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USERNAME + " TEXT NOT NULL, "
            + COLUMN_FIRST_NAME + " TEXT, "
            + COLUMN_LAST_NAME + " TEXT, "
            + COLUMN_DATE_OF_BIRTH + " TEXT, "
            + COLUMN_PASSWORD + " TEXT, "
            + COLUMN_EDUCATION + " TEXT, "
            + COLUMN_CONNECTED + " INTEGER DEFAULT 0);"; // Default to 0 (not connected)

    private static final String CREATE_SST_TABLE = "CREATE TABLE " + TABLE_SST + " ("
            + COLUMN_SST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SST_USER_ID + " INTEGER, "
            + COLUMN_AGE + " INTEGER, "
            + COLUMN_NUMBER + " INTEGER, "
            + COLUMN_GENDER + " TEXT, "
            + COLUMN_RESULTS + " TEXT, "
            + "FOREIGN KEY(" + COLUMN_SST_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_BBS_TABLE = "CREATE TABLE " + TABLE_BBS + " ("
            + COLUMN_BBS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_BBS_USER_ID + " INTEGER, "
            + COLUMN_SITTING_TO_STANDING + " INTEGER, "
            + COLUMN_STANDING_UNSUPPORTED + " INTEGER, "
            + COLUMN_SITTING_UNSUPPORTED + " INTEGER, "
            + COLUMN_STANDING_TO_SITTING + " INTEGER, "
            + COLUMN_TRANSFERS + " INTEGER, "
            + COLUMN_STANDING_WITH_EYES_CLOSED + " INTEGER, "
            + COLUMN_STANDING_WITH_FEET_TOGETHER + " INTEGER, "
            + COLUMN_REACHING_FORWARD_WITH_OUTSTRETCHED_ARM + " INTEGER, "
            + COLUMN_RETRIEVING_OBJECT_FROM_FLOOR + " INTEGER, "
            + COLUMN_TURNING_TO_LOOK_BEHIND + " INTEGER, "
            + COLUMN_TURNING_360_DEGREES + " INTEGER, "
            + COLUMN_PLACING_ALTERNATE_FOOT_ON_STOOL + " INTEGER, "
            + COLUMN_STANDING_WITH_ONE_FOOT_IN_FRONT + " INTEGER, "
            + COLUMN_STANDING_ON_ONE_FOOT + " INTEGER, "
            + COLUMN_TOTAL + " INTEGER, "
            + "FOREIGN KEY(" + COLUMN_BBS_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_CSRT_TABLE = "CREATE TABLE " + TABLE_CSRT + " ("
            + COLUMN_CSRT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CSRT_USER_ID + " INTEGER, "
            + COLUMN_CSRT_GENDER + " TEXT, "
            + COLUMN_CSRT_AGE + " INTEGER, "
            + COLUMN_REACTION_TIME + " REAL, "
            + "FOREIGN KEY(" + COLUMN_CSRT_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";


    private static final String CREATE_FRT_TABLE = "CREATE TABLE " + TABLE_FRT + "(" +
                    COLUMN_FRT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_FRT_USER_ID + " INTEGER," +
                    COLUMN_DISTANCE + " REAL ," +
                    COLUMN_RESULT + " TEXT ,"
                    + "FOREIGN KEY(" + COLUMN_FRT_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_TUG_TABLE = "CREATE TABLE " + TABLE_TUG + "(" +
            COLUMN_TUG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_TUG_USER_ID + " INTEGER," +
            COLUMN_TIMEINSECONDS + " REAL NOT NULL," +
            COLUMN_TUG_RESULT + " TEXT NOT NULL,"
            + "FOREIGN KEY(" + COLUMN_TUG_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    public static final String CREATE_MOCA_TABLE = "CREATE TABLE " + TABLE_MOCA + " (" +
                    COLUMN_MOCA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_MOCA_USER_ID + " INTEGER," +
                    COLUMN_OPTICOCHORIKES + " INTEGER," +
                    COLUMN_KATONOMASIA + " INTEGER," +
                    COLUMN_PROSOXI1 + " INTEGER," +
                    COLUMN_PROSOXI2 + " INTEGER," +
                    COLUMN_PROSOXI3 + " INTEGER," +
                    COLUMN_GLOSSA + " INTEGER," +
                    COLUMN_ROI + " INTEGER," +
                    COLUMN_AFAIROTIKI_SKEPSI + " INTEGER," +
                    COLUMN_KATISTIMENI_ANAKLISI + " INTEGER," +
                    COLUMN_PROSANAFORELISMO + " INTEGER," +
                    COLUMN_MOCA_RESULTS + " INTEGER,"
                    + "FOREIGN KEY(" + COLUMN_MOCA_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    public static final String CREATE_MMSE_TABLE = "CREATE TABLE " + TABLE_MMSE + " (" +
            COLUMN_MMSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_MMSE_USER_ID + " INTEGER," +
            COLUMN_ORIENTATION + " INTEGER," +
            COLUMN_REGISTRATION + " INTEGER," +
            COLUMN_ATTENTIONANDCALCULATION  + " INTEGER," +
            COLUMN_RECALL + " INTEGER," +
            COLUMN_LANGUAGE + " INTEGER," +
            COLUMN_MMSE_RESULTS  + " INTEGER,"
            + "FOREIGN KEY(" + COLUMN_MMSE_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_TABLE_TRAIL = "CREATE TABLE " + TABLE_TRAIL + " ("
            + COLUMN_TRAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TRAIL_USER_ID + " INTEGER, "
            + COLUMN_PARTA + " INTEGER, "
            + COLUMN_PARTB + " INTEGER, "
            + COLUMN_TRAIL_AGE + " INTEGER, "
            + COLUMN_TRAIL_RESULT + " TEXT, "
            + "FOREIGN KEY(" + COLUMN_TRAIL_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + ")"
            + ");";

    private static final String CREATE_DIGIT_SPAN_TABLE = "CREATE TABLE " + TABLE_DIGIT_SPAN + " ("
            + COLUMN_DIGIT_SPAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DIGIT_SPAN_USER_ID + " INTEGER, "
            + COLUMN_LENGTH + " TEXT, "
            + COLUMN_PRESENTED + " TEXT, "
            + COLUMN_RESPONSE + " TEXT, "
            + COLUMN_DIGIT_SPAN_RESULT + " INTEGER, "
            + "FOREIGN KEY(" + COLUMN_DIGIT_SPAN_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";


    private static final String CREATE_STROOP_TABLE = "CREATE TABLE " + TABLE_STROOP + " ("
            + COLUMN_STROOP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_STROOP_USER_ID + " INTEGER, "
            + COLUMN_CONGRUENT + " REAL NOT NULL, "
            + COLUMN_INCOGRUENT + " REAL NOT NULL, "
            + COLUMN_STROOP_EFFECT + " REAL NOT NULL, "
            + "FOREIGN KEY(" + COLUMN_STROOP_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";
    private static final String CREATE_SUS_TABLE = "CREATE TABLE " + TABLE_SUS + " ("
            + COLUMN_SUS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SUS_USER_ID + " INTEGER, "
            + COLUMN_SCORE + " INTEGER, "
            + COLUMN_MULTIPLIED_SCORE + " REAL, "
            + COLUMN_SUS_RESULT + " TEXT, "
            + "FOREIGN KEY(" + COLUMN_SUS_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_IGEQ_TABLE = "CREATE TABLE " + TABLE_IGEQ + " ("
            + COLUMN_IGEQ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_IGEQ_USER_ID + " INTEGER, "
            + COLUMN_COMPETENCE + " REAL, "
            + COLUMN_IMMERSION + " REAL, "
            + COLUMN_FLOW + " REAL, "
            + COLUMN_TENSION + " REAL, "
            + COLUMN_CHALLENGE + " REAL, "
            + COLUMN_NEGATIVE + " REAL, "
            + COLUMN_POSITIVE + " REAL, "
            + "FOREIGN KEY(" + COLUMN_IGEQ_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_PACES_TABLE = "CREATE TABLE " + TABLE_PACES + " ("
            + COLUMN_PACES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PACES_USER_ID + " INTEGER, "
            + COLUMN_ITEM1 + " INTEGER, "
            + COLUMN_ITEM2 + " INTEGER, "
            + COLUMN_ITEM3 + " INTEGER, "
            + COLUMN_ITEM4 + " INTEGER, "
            + COLUMN_ITEM5 + " INTEGER, "
            + COLUMN_ITEM6 + " INTEGER, "
            + COLUMN_ITEM7 + " INTEGER, "
            + COLUMN_ITEM8 + " INTEGER, "
            + COLUMN_ITEM9 + " INTEGER, "
            + COLUMN_ITEM10 + " INTEGER, "
            + COLUMN_ITEM11 + " INTEGER, "
            + COLUMN_ITEM12 + " INTEGER, "
            + COLUMN_ITEM13 + " INTEGER, "
            + COLUMN_ITEM14 + " INTEGER, "
            + COLUMN_ITEM15 + " INTEGER, "
            + COLUMN_ITEM16 + " INTEGER, "
            + COLUMN_ITEM17 + " INTEGER, "
            + COLUMN_ITEM18 + " INTEGER, "
            + COLUMN_SUM + " INTEGER, "
            + "FOREIGN KEY(" + COLUMN_PACES_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_TECHNOLOGY_ACCEPTANCE_TABLE = "CREATE TABLE " + TABLE_TECHNOLOGY_ACCEPTANCE + " ("
            + COLUMN_TECHNOLOGY_ACCEPTANCE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TECHNOLOGY_ACCEPTANCE_USER_ID + " INTEGER, "
            + COLUMN_TAM1 + " REAL, "
            + COLUMN_TAM2 + " REAL, "
            + COLUMN_TAM3 + " REAL, "
            + COLUMN_TAM4 + " REAL, "
            + COLUMN_TAM5 + " REAL, "
            + COLUMN_TAM6 + " REAL, "
            + COLUMN_TAM7 + " REAL, "
            + COLUMN_TAM8 + " REAL, "
            + COLUMN_TAM9 + " REAL, "
            + COLUMN_TAM10 + " REAL, "
            + COLUMN_TAM11 + " REAL, "
            + COLUMN_TAM12 + " REAL, "
            + COLUMN_PU + " REAL, "
            + COLUMN_PEU + " REAL, "
            + "FOREIGN KEY(" + COLUMN_TECHNOLOGY_ACCEPTANCE_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    private static final String CREATE_SUBSTITUTION_TABLE = "CREATE TABLE " + TABLE_SUBSTITUTION + " ("
            + COLUMN_SUBSTITUTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SUBSTITUTION_USER_ID + " INTEGER, "
            + COLUMN_SUBSTITUTION_CORRECT + " INTEGER, "
            + COLUMN_SUBSTITUTION_RESPONSE_TIME + " REAL, "
            + "FOREIGN KEY(" + COLUMN_SUBSTITUTION_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the user registration table
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_SST_TABLE);
        db.execSQL(CREATE_BBS_TABLE);
        db.execSQL(CREATE_CSRT_TABLE);
        db.execSQL(CREATE_FRT_TABLE);
        db.execSQL(CREATE_TUG_TABLE);
        db.execSQL(CREATE_MOCA_TABLE);
        db.execSQL(CREATE_MMSE_TABLE);
        db.execSQL(CREATE_TABLE_TRAIL);
        db.execSQL(CREATE_DIGIT_SPAN_TABLE);
        db.execSQL(CREATE_STROOP_TABLE);
        db.execSQL(CREATE_SUS_TABLE);
        db.execSQL(CREATE_IGEQ_TABLE);
        db.execSQL(CREATE_PACES_TABLE);
        db.execSQL(CREATE_TECHNOLOGY_ACCEPTANCE_TABLE);
        db.execSQL(CREATE_SUBSTITUTION_TABLE);
        // Create additional tables here as needed
        // db.execSQL(CREATE_ANOTHER_TABLE);
        // db.execSQL(CREATE_YET_ANOTHER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades, if necessary
    }

    @SuppressLint("Range")
    public UserData getUserData(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        UserData userData = new UserData(); // Create a UserData class to hold user attributes

        String[] columns = {COLUMN_USERNAME, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_DATE_OF_BIRTH, COLUMN_EDUCATION};
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            userData.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
            userData.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
            userData.setLastName(cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME)));
            userData.setDateOfBirth(cursor.getString(cursor.getColumnIndex(COLUMN_DATE_OF_BIRTH)));
            userData.setEducation(cursor.getString(cursor.getColumnIndex(COLUMN_EDUCATION)));
        }

        cursor.close();
        db.close();

        return userData;
    }
    public int getUserIdByUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int userId = -1; // Default value if user not found

        String[] projection = {"user_id"};
        String selection = "username=?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query("User", projection, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            userId = cursor.getInt(cursor.getColumnIndexOrThrow("user_id"));
        }

        cursor.close();
        db.close();

        return userId;
    }
    public void insertResultSST(int userId, int age, int number, String gender, String results) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SST_USER_ID, userId);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_NUMBER, number);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_RESULTS, results);

        db.insert(TABLE_SST, null, values);
        db.close();
    }
    public void insertBBSMetrics(int userId, int sittingToStanding, int standingUnsupported, int sittingUnsupported, int standingToSitting, int transfers,
                                 int standingWithEyesClosed, int standingWithFeetTogether, int reachingForwardWithOutstretchedArm,
                                 int retrievingObjectFromFloor, int turningToLookBehind, int turning360Degrees,
                                 int placingAlternateFootOnStool, int standingWithOneFootInFront, int standingOnOneFoot, int total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BBS_USER_ID, userId);
        values.put(COLUMN_SITTING_TO_STANDING, sittingToStanding);
        values.put(COLUMN_STANDING_UNSUPPORTED, standingUnsupported);
        values.put(COLUMN_SITTING_UNSUPPORTED, sittingUnsupported);
        values.put(COLUMN_STANDING_TO_SITTING, standingToSitting);
        values.put(COLUMN_TRANSFERS, transfers);
        values.put(COLUMN_STANDING_WITH_EYES_CLOSED, standingWithEyesClosed);
        values.put(COLUMN_STANDING_WITH_FEET_TOGETHER, standingWithFeetTogether);
        values.put(COLUMN_REACHING_FORWARD_WITH_OUTSTRETCHED_ARM, reachingForwardWithOutstretchedArm);
        values.put(COLUMN_RETRIEVING_OBJECT_FROM_FLOOR, retrievingObjectFromFloor);
        values.put(COLUMN_TURNING_TO_LOOK_BEHIND, turningToLookBehind);
        values.put(COLUMN_TURNING_360_DEGREES, turning360Degrees);
        values.put(COLUMN_PLACING_ALTERNATE_FOOT_ON_STOOL, placingAlternateFootOnStool);
        values.put(COLUMN_STANDING_WITH_ONE_FOOT_IN_FRONT, standingWithOneFootInFront);
        values.put(COLUMN_STANDING_ON_ONE_FOOT, standingOnOneFoot);
        values.put(COLUMN_TOTAL, total);

        db.insert(TABLE_BBS, null, values);
        db.close();
    }

    public void insertCSRTResult(int userId, String gender, int age, double reactionTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CSRT_USER_ID, userId);
        values.put(COLUMN_CSRT_GENDER, gender);
        values.put(COLUMN_CSRT_AGE, age);
        values.put(COLUMN_REACTION_TIME, reactionTime);

        db.insert(TABLE_CSRT, null, values);
        db.close();
    }

    public void insertFRTResult(int userId, double distance, String result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FRT_USER_ID,userId);
        values.put(COLUMN_DISTANCE, distance);
        values.put(COLUMN_RESULT, result);

        db.insert(TABLE_FRT, null, values);
        db.close();
    }
    public void insertTUGResult(int userId, double timeInSeconds, String result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TUG_USER_ID,userId);
        values.put(COLUMN_TIMEINSECONDS, timeInSeconds);
        values.put(COLUMN_TUG_RESULT, result);

        db.insert(TABLE_TUG, null, values);
        db.close();
    }

    public void insertMOCAResult(int userId, int opticochorikes, int ktonomasia, int prosoxi1, int prosoxi2,
                                 int prosoxi3, int glossa, int roi, int afairotikiSkepsi,
                                 int katistimeniAnaklisi, int prosanaforlismo, int results) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_MOCA_USER_ID, userId);
        values.put(COLUMN_OPTICOCHORIKES, opticochorikes);
        values.put(COLUMN_KATONOMASIA, ktonomasia);
        values.put(COLUMN_PROSOXI1, prosoxi1);
        values.put(COLUMN_PROSOXI2, prosoxi2);
        values.put(COLUMN_PROSOXI3, prosoxi3);
        values.put(COLUMN_GLOSSA, glossa);
        values.put(COLUMN_ROI, roi);
        values.put(COLUMN_AFAIROTIKI_SKEPSI, afairotikiSkepsi);
        values.put(COLUMN_KATISTIMENI_ANAKLISI, katistimeniAnaklisi);
        values.put(COLUMN_PROSANAFORELISMO, prosanaforlismo);
        values.put(COLUMN_MOCA_RESULTS, results);

        db.insert(TABLE_MOCA, null, values);
        db.close();
    }
    public void insertMMSEResult(int userId, int orientation, int registration, int attentionAndCalculation,
                                 int recall, int language, int results) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_MMSE_USER_ID, userId);
        values.put(COLUMN_ORIENTATION, orientation);
        values.put(COLUMN_REGISTRATION, registration);
        values.put(COLUMN_ATTENTIONANDCALCULATION, attentionAndCalculation);
        values.put(COLUMN_RECALL, recall);
        values.put(COLUMN_LANGUAGE, language);
        values.put(COLUMN_MMSE_RESULTS, results);

        db.insert(TABLE_MMSE, null, values);
        db.close();
    }

    public void insertTrailResult(int userId, int partA, int partB, int age, String result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TRAIL_USER_ID, userId);
        values.put(COLUMN_PARTA, partA);
        values.put(COLUMN_PARTB, partB);
        values.put(COLUMN_TRAIL_AGE, age);
        values.put(COLUMN_TRAIL_RESULT, result);

        db.insert(TABLE_TRAIL, null, values);
        db.close();
    }
    public void insertDigitSpanResult(int userId, String length, String presented, String response, int result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_DIGIT_SPAN_USER_ID, userId);
        values.put(COLUMN_LENGTH, length);
        values.put(COLUMN_PRESENTED, presented);
        values.put(COLUMN_RESPONSE, response);
        values.put(COLUMN_DIGIT_SPAN_RESULT, result);

        db.insert(TABLE_DIGIT_SPAN, null, values);
        db.close();
    }
    public void insertStroopResult(int userId, double congruentTime, double incongruentTime, double stroopEffect) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_STROOP_USER_ID, userId);
        values.put(COLUMN_CONGRUENT, congruentTime);
        values.put(COLUMN_INCOGRUENT, incongruentTime);
        values.put(COLUMN_STROOP_EFFECT, stroopEffect);

        db.insert(TABLE_STROOP, null, values);
        db.close();
    }
    public void insertSUSResult(int userId, int score, double multipliedScore, String result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUS_USER_ID, userId);
        values.put(COLUMN_SCORE, score);
        values.put(COLUMN_MULTIPLIED_SCORE, multipliedScore);
        values.put(COLUMN_SUS_RESULT, result);

        db.insert(TABLE_SUS, null, values);
        db.close();
    }

    public void insertIGEQResult(int userId, double competence, double immersion, double flow,double tension, double challenge, double negative, double positive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IGEQ_USER_ID, userId);
        values.put(COLUMN_COMPETENCE, competence);
        values.put(COLUMN_IMMERSION, immersion);
        values.put(COLUMN_FLOW, flow);
        values.put(COLUMN_TENSION, tension);
        values.put(COLUMN_CHALLENGE, challenge);
        values.put(COLUMN_NEGATIVE, negative);
        values.put(COLUMN_POSITIVE, positive);

        db.insert(TABLE_IGEQ, null, values);
        db.close();
    }

    public void insertPACESResult(int userId, int item1, int item2, int item3, int item4, int item5, int item6,
                                  int item7, int item8, int item9, int item10, int item11, int item12, int item13,
                                  int item14, int item15, int item16, int item17, int item18, int sum) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PACES_USER_ID, userId);
        values.put(COLUMN_ITEM1, item1);
        values.put(COLUMN_ITEM2, item2);
        values.put(COLUMN_ITEM3, item3);
        values.put(COLUMN_ITEM4, item4);
        values.put(COLUMN_ITEM5, item5);
        values.put(COLUMN_ITEM6, item6);
        values.put(COLUMN_ITEM7, item7);
        values.put(COLUMN_ITEM8, item8);
        values.put(COLUMN_ITEM9, item9);
        values.put(COLUMN_ITEM10, item10);
        values.put(COLUMN_ITEM11, item11);
        values.put(COLUMN_ITEM12, item12);
        values.put(COLUMN_ITEM13, item13);
        values.put(COLUMN_ITEM14, item14);
        values.put(COLUMN_ITEM15, item15);
        values.put(COLUMN_ITEM16, item16);
        values.put(COLUMN_ITEM17, item17);
        values.put(COLUMN_ITEM18, item18);
        values.put(COLUMN_SUM, sum);

        db.insert(TABLE_PACES, null, values);
        db.close();
    }
    public void insertTechnologyAcceptanceResult(int userId, double tam1, double tam2, double tam3, double tam4,
                                                 double tam5, double tam6, double tam7, double tam8,
                                                 double tam9, double tam10, double tam11, double tam12,
                                                 double pu, double peu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TECHNOLOGY_ACCEPTANCE_USER_ID, userId);
        values.put(COLUMN_TAM1, tam1);
        values.put(COLUMN_TAM2, tam2);
        values.put(COLUMN_TAM3, tam3);
        values.put(COLUMN_TAM4, tam4);
        values.put(COLUMN_TAM5, tam5);
        values.put(COLUMN_TAM6, tam6);
        values.put(COLUMN_TAM7, tam7);
        values.put(COLUMN_TAM8, tam8);
        values.put(COLUMN_TAM9, tam9);
        values.put(COLUMN_TAM10, tam10);
        values.put(COLUMN_TAM11, tam11);
        values.put(COLUMN_TAM12, tam12);
        values.put(COLUMN_PU, pu);
        values.put(COLUMN_PEU, peu);

        db.insert(TABLE_TECHNOLOGY_ACCEPTANCE, null, values);
        db.close();
    }

    public void insertSubstitutionResult(int userId, int correct, double responseTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBSTITUTION_USER_ID, userId);
        values.put(COLUMN_SUBSTITUTION_CORRECT, correct);
        values.put(COLUMN_SUBSTITUTION_RESPONSE_TIME, responseTime);

        db.insert(TABLE_SUBSTITUTION, null, values);
        db.close();
    }

    public List<ResultData> getResultsForUserSST(int userId) {
        List<ResultData> resultList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_AGE, COLUMN_NUMBER, COLUMN_GENDER, COLUMN_RESULTS};
        String selection = COLUMN_SST_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_SST, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE));
            @SuppressLint("Range") int number = cursor.getInt(cursor.getColumnIndex(COLUMN_NUMBER));
            @SuppressLint("Range") String gender = cursor.getString(cursor.getColumnIndex(COLUMN_GENDER));
            @SuppressLint("Range") String results = cursor.getString(cursor.getColumnIndex(COLUMN_RESULTS));

            ResultData resultData = new ResultData(age, number, gender, results);
            resultList.add(resultData);
        }

        cursor.close();
        db.close();

        return resultList;
    }

    @SuppressLint("Range")
    public List<BBSMetricData> getBBSMetricsForUser(int userId) {
        List<BBSMetricData> bbsMetricsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_SITTING_TO_STANDING, COLUMN_STANDING_UNSUPPORTED, COLUMN_SITTING_UNSUPPORTED,
                COLUMN_STANDING_TO_SITTING, COLUMN_TRANSFERS, COLUMN_STANDING_WITH_EYES_CLOSED, COLUMN_STANDING_WITH_FEET_TOGETHER,
                COLUMN_REACHING_FORWARD_WITH_OUTSTRETCHED_ARM, COLUMN_RETRIEVING_OBJECT_FROM_FLOOR, COLUMN_TURNING_TO_LOOK_BEHIND,
                COLUMN_TURNING_360_DEGREES, COLUMN_PLACING_ALTERNATE_FOOT_ON_STOOL, COLUMN_STANDING_WITH_ONE_FOOT_IN_FRONT,
                COLUMN_STANDING_ON_ONE_FOOT, COLUMN_TOTAL};
        String selection = COLUMN_BBS_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_BBS, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int sittingToStanding = cursor.getInt(cursor.getColumnIndex(COLUMN_SITTING_TO_STANDING));
            int standingUnsupported = cursor.getInt(cursor.getColumnIndex(COLUMN_STANDING_UNSUPPORTED));
            int sittingUnsupported = cursor.getInt(cursor.getColumnIndex(COLUMN_SITTING_UNSUPPORTED));
            int standingToSitting = cursor.getInt(cursor.getColumnIndex(COLUMN_STANDING_TO_SITTING));
            int transfers = cursor.getInt(cursor.getColumnIndex(COLUMN_TRANSFERS));
            int standingWithEyesClosed = cursor.getInt(cursor.getColumnIndex(COLUMN_STANDING_WITH_EYES_CLOSED));
            int standingWithFeetTogether = cursor.getInt(cursor.getColumnIndex(COLUMN_STANDING_WITH_FEET_TOGETHER));
            int reachingForwardWithOutstretchedArm = cursor.getInt(cursor.getColumnIndex(COLUMN_REACHING_FORWARD_WITH_OUTSTRETCHED_ARM));
            int retrievingObjectFromFloor = cursor.getInt(cursor.getColumnIndex(COLUMN_RETRIEVING_OBJECT_FROM_FLOOR));
            int turningToLookBehind = cursor.getInt(cursor.getColumnIndex(COLUMN_TURNING_TO_LOOK_BEHIND));
            int turning360Degrees = cursor.getInt(cursor.getColumnIndex(COLUMN_TURNING_360_DEGREES));
            int placingAlternateFootOnStool = cursor.getInt(cursor.getColumnIndex(COLUMN_PLACING_ALTERNATE_FOOT_ON_STOOL));
            int standingWithOneFootInFront = cursor.getInt(cursor.getColumnIndex(COLUMN_STANDING_WITH_ONE_FOOT_IN_FRONT));
            int standingOnOneFoot = cursor.getInt(cursor.getColumnIndex(COLUMN_STANDING_ON_ONE_FOOT));
            int total = cursor.getInt(cursor.getColumnIndex(COLUMN_TOTAL));

            BBSMetricData bbsMetricData = new BBSMetricData(sittingToStanding, standingUnsupported, sittingUnsupported,
                    standingToSitting, transfers, standingWithEyesClosed, standingWithFeetTogether,
                    reachingForwardWithOutstretchedArm, retrievingObjectFromFloor, turningToLookBehind,
                    turning360Degrees, placingAlternateFootOnStool, standingWithOneFootInFront, standingOnOneFoot, total);
            bbsMetricsList.add(bbsMetricData);
        }

        cursor.close();
        db.close();

        return bbsMetricsList;
    }

    @SuppressLint("Range")
    public List<CSRTResultData> getCSRTResultsForUser(int userId) {
        List<CSRTResultData> csrtResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_CSRT_GENDER, COLUMN_CSRT_AGE, COLUMN_REACTION_TIME};
        String selection = COLUMN_CSRT_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_CSRT, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            String gender = cursor.getString(cursor.getColumnIndex(COLUMN_CSRT_GENDER));
            int age = cursor.getInt(cursor.getColumnIndex(COLUMN_CSRT_AGE));
            double reactionTime = cursor.getDouble(cursor.getColumnIndex(COLUMN_REACTION_TIME));

            CSRTResultData csrtResultData = new CSRTResultData(gender, age, reactionTime);
            csrtResultsList.add(csrtResultData);
        }

        cursor.close();
        db.close();

        return csrtResultsList;
    }

    @SuppressLint("Range")
    public List<FRTResultData> getFRTResultsForUser(int userId) {
        List<FRTResultData> frtResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_DISTANCE, COLUMN_RESULT};
        String selection = COLUMN_FRT_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_FRT, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            double distance = cursor.getDouble(cursor.getColumnIndex(COLUMN_DISTANCE));
            String result = cursor.getString(cursor.getColumnIndex(COLUMN_RESULT));

            FRTResultData frtResultData = new FRTResultData(distance, result);
            frtResultsList.add(frtResultData);
        }

        cursor.close();
        db.close();

        return frtResultsList;
    }

    @SuppressLint("Range")
    public List<TUGResultData> getTUGResultsForUser(int userId) {
        List<TUGResultData> tugResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_TIMEINSECONDS, COLUMN_TUG_RESULT};
        String selection = COLUMN_TUG_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_TUG, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            double timeInSeconds = cursor.getDouble(cursor.getColumnIndex(COLUMN_TIMEINSECONDS));
            String result = cursor.getString(cursor.getColumnIndex(COLUMN_TUG_RESULT));

            TUGResultData tugResultData = new TUGResultData(timeInSeconds, result);
            tugResultsList.add(tugResultData);
        }

        cursor.close();
        db.close();

        return tugResultsList;
    }

    @SuppressLint("Range")
    public List<MOCAResultData> getMOCAResultsForUser(int userId) {
        List<MOCAResultData> mocaResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_OPTICOCHORIKES, COLUMN_KATONOMASIA, COLUMN_PROSOXI1,
                COLUMN_PROSOXI2, COLUMN_PROSOXI3, COLUMN_GLOSSA, COLUMN_ROI, COLUMN_AFAIROTIKI_SKEPSI,
                COLUMN_KATISTIMENI_ANAKLISI, COLUMN_PROSANAFORELISMO,COLUMN_MOCA_RESULTS};

        String selection = COLUMN_MOCA_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_MOCA, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int opticochorikes = cursor.getInt(cursor.getColumnIndex(COLUMN_OPTICOCHORIKES));
            int ktonomasia = cursor.getInt(cursor.getColumnIndex(COLUMN_KATONOMASIA));
            int prosoxi1 = cursor.getInt(cursor.getColumnIndex(COLUMN_PROSOXI1));
            int prosoxi2 = cursor.getInt(cursor.getColumnIndex(COLUMN_PROSOXI2));
            int prosoxi3 = cursor.getInt(cursor.getColumnIndex(COLUMN_PROSOXI3));
            int glossa = cursor.getInt(cursor.getColumnIndex(COLUMN_GLOSSA));
            int roi = cursor.getInt(cursor.getColumnIndex(COLUMN_ROI));
            int afairotikiSkepsi = cursor.getInt(cursor.getColumnIndex(COLUMN_AFAIROTIKI_SKEPSI ));
            int katistimeniAnaklisi = cursor.getInt(cursor.getColumnIndex(COLUMN_KATISTIMENI_ANAKLISI));
            int prosanaforlismo = cursor.getInt(cursor.getColumnIndex(COLUMN_PROSANAFORELISMO));
            int results = cursor.getInt(cursor.getColumnIndex(COLUMN_MOCA_RESULTS));

            MOCAResultData mocaResultData = new MOCAResultData(opticochorikes, ktonomasia, prosoxi1,
                    prosoxi2, prosoxi3, glossa, roi, afairotikiSkepsi, katistimeniAnaklisi, prosanaforlismo, results);

            mocaResultsList.add(mocaResultData);
        }

        cursor.close();
        db.close();

        return mocaResultsList;
    }

    @SuppressLint("Range")
    public List<MMSEResultData> getMMSEResultsForUser(int userId) {
        List<MMSEResultData> mmseResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_ORIENTATION, COLUMN_REGISTRATION, COLUMN_ATTENTIONANDCALCULATION,
                COLUMN_RECALL, COLUMN_LANGUAGE, COLUMN_MMSE_RESULTS};

        String selection = COLUMN_MMSE_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_MMSE, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int orientation = cursor.getInt(cursor.getColumnIndex(COLUMN_ORIENTATION));
            int registration = cursor.getInt(cursor.getColumnIndex(COLUMN_REGISTRATION));
            int attentionAndCalculation = cursor.getInt(cursor.getColumnIndex(COLUMN_ATTENTIONANDCALCULATION));
            int recall = cursor.getInt(cursor.getColumnIndex(COLUMN_RECALL));
            int language = cursor.getInt(cursor.getColumnIndex(COLUMN_LANGUAGE));
            int results = cursor.getInt(cursor.getColumnIndex(COLUMN_MMSE_RESULTS));

            MMSEResultData mmseResultData = new MMSEResultData(orientation, registration,
                    attentionAndCalculation, recall, language, results);

            mmseResultsList.add(mmseResultData);
        }

        cursor.close();
        db.close();

        return mmseResultsList;
    }

    @SuppressLint("Range")
    public List<TrailResultData> getTrailResultsForUser(int userId) {
        List<TrailResultData> trailResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_PARTA, COLUMN_PARTB, COLUMN_TRAIL_AGE, COLUMN_TRAIL_RESULT};

        String selection = COLUMN_TRAIL_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_TRAIL, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int partA = cursor.getInt(cursor.getColumnIndex(COLUMN_PARTA));
            int partB = cursor.getInt(cursor.getColumnIndex(COLUMN_PARTB));
            int age = cursor.getInt(cursor.getColumnIndex(COLUMN_TRAIL_AGE));
            String result = cursor.getString(cursor.getColumnIndex(COLUMN_TRAIL_RESULT));

            TrailResultData trailResultData = new TrailResultData(partA, partB, age, result);

            trailResultsList.add(trailResultData);
        }

        cursor.close();
        db.close();

        return trailResultsList;
    }

    @SuppressLint("Range")
    public List<DigitSpanResultData> getDigitSpanResultsForUser(int userId) {
        List<DigitSpanResultData> digitSpanResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_LENGTH, COLUMN_PRESENTED, COLUMN_RESPONSE, COLUMN_DIGIT_SPAN_RESULT};

        String selection = COLUMN_DIGIT_SPAN_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_DIGIT_SPAN, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            String length = cursor.getString(cursor.getColumnIndex(COLUMN_LENGTH));
            String presented = cursor.getString(cursor.getColumnIndex(COLUMN_PRESENTED));
            String response = cursor.getString(cursor.getColumnIndex(COLUMN_RESPONSE));
            int result = cursor.getInt(cursor.getColumnIndex(COLUMN_DIGIT_SPAN_RESULT));

            DigitSpanResultData digitSpanResultData = new DigitSpanResultData(length, presented, response, result);

            digitSpanResultsList.add(digitSpanResultData);
        }

        cursor.close();
        db.close();

        return digitSpanResultsList;
    }
    @SuppressLint("Range")
    public List<StroopResultData> getStroopResultsForUser(int userId) {
        List<StroopResultData> resultList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_CONGRUENT, COLUMN_INCOGRUENT, COLUMN_STROOP_EFFECT};
        String selection = COLUMN_STROOP_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_STROOP, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            double congruentTime = cursor.getDouble(cursor.getColumnIndex(COLUMN_CONGRUENT));
            double incongruentTime = cursor.getDouble(cursor.getColumnIndex(COLUMN_INCOGRUENT));
            double stroopEffect = cursor.getDouble(cursor.getColumnIndex(COLUMN_STROOP_EFFECT));

            StroopResultData stroopResultData = new StroopResultData(congruentTime, incongruentTime, stroopEffect);
            resultList.add(stroopResultData);
        }

        cursor.close();
        db.close();

        return resultList;
    }
    @SuppressLint("Range")
    public List<SUSResultData> getSUSResultsForUser(int userId) {
        List<SUSResultData> susResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_SCORE, COLUMN_MULTIPLIED_SCORE, COLUMN_SUS_RESULT};
        String selection = COLUMN_SUS_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_SUS, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int score = cursor.getInt(cursor.getColumnIndex(COLUMN_SCORE));
            double multipliedScore = cursor.getDouble(cursor.getColumnIndex(COLUMN_MULTIPLIED_SCORE));
            String result = cursor.getString(cursor.getColumnIndex(COLUMN_SUS_RESULT));

            SUSResultData susResultData = new SUSResultData(score, multipliedScore, result);
            susResultsList.add(susResultData);
        }

        cursor.close();
        db.close();

        return susResultsList;
    }

    @SuppressLint("Range")
    public List<IGEQResultData> getIGEQResultsForUser(int userId) {
        List<IGEQResultData> igeqResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_COMPETENCE, COLUMN_IMMERSION, COLUMN_FLOW, COLUMN_TENSION, COLUMN_CHALLENGE, COLUMN_NEGATIVE, COLUMN_POSITIVE};
        String selection = COLUMN_IGEQ_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_IGEQ, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            double competence = cursor.getDouble(cursor.getColumnIndex(COLUMN_COMPETENCE));
            double immersion = cursor.getDouble(cursor.getColumnIndex(COLUMN_IMMERSION));
            double flow = cursor.getDouble(cursor.getColumnIndex(COLUMN_FLOW));
            double tension = cursor.getDouble(cursor.getColumnIndex(COLUMN_TENSION));
            double challenge = cursor.getDouble(cursor.getColumnIndex(COLUMN_CHALLENGE));
            double negative = cursor.getDouble(cursor.getColumnIndex(COLUMN_NEGATIVE));
            double positive = cursor.getDouble(cursor.getColumnIndex(COLUMN_POSITIVE));

            IGEQResultData igeqResultData = new IGEQResultData(competence, immersion, flow, tension, challenge, negative, positive);
            igeqResultsList.add(igeqResultData);
        }

        cursor.close();
        db.close();

        return igeqResultsList;
    }
    @SuppressLint("Range")
    public List<PACESMetricData> getPACESMetricsForUser(int userId) {
        List<PACESMetricData> pacesMetricsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_ITEM1, COLUMN_ITEM2, COLUMN_ITEM3, COLUMN_ITEM4, COLUMN_ITEM5, COLUMN_ITEM6,
                COLUMN_ITEM7, COLUMN_ITEM8, COLUMN_ITEM9, COLUMN_ITEM10, COLUMN_ITEM11, COLUMN_ITEM12,
                COLUMN_ITEM13, COLUMN_ITEM14, COLUMN_ITEM15, COLUMN_ITEM16, COLUMN_ITEM17, COLUMN_ITEM18, COLUMN_SUM};
        String selection = COLUMN_PACES_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_PACES, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int item1 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM1));
            int item2 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM2));
            int item3 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM3));
            int item4 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM4));
            int item5 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM5));
            int item6 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM6));
            int item7 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM7));
            int item8 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM8));
            int item9 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM9));
            int item10 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM10));
            int item11 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM11));
            int item12 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM12));
            int item13 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM13));
            int item14 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM14));
            int item15 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM15));
            int item16 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM16));
            int item17 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM17));
            int item18 = cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM18));
            int sum = cursor.getInt(cursor.getColumnIndex(COLUMN_SUM));

            PACESMetricData pacesMetricData = new PACESMetricData(item1, item2, item3, item4, item5, item6, item7,
                    item8, item9, item10, item11, item12, item13, item14, item15, item16, item17, item18, sum);
            pacesMetricsList.add(pacesMetricData);
        }

        cursor.close();
        db.close();

        return pacesMetricsList;
    }
    @SuppressLint("Range")
    public List<TechnologyAcceptanceResultData> getTechnologyAcceptanceResultsForUser(int userId) {
        List<TechnologyAcceptanceResultData> techAcceptanceResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_TAM1, COLUMN_TAM2, COLUMN_TAM3, COLUMN_TAM4,
                COLUMN_TAM5, COLUMN_TAM6, COLUMN_TAM7, COLUMN_TAM8,
                COLUMN_TAM9, COLUMN_TAM10, COLUMN_TAM11, COLUMN_TAM12,
                COLUMN_PU, COLUMN_PEU};
        String selection = COLUMN_TECHNOLOGY_ACCEPTANCE_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_TECHNOLOGY_ACCEPTANCE, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            double tam1 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM1));
            double tam2 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM2));
            double tam3 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM3));
            double tam4 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM4));
            double tam5 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM5));
            double tam6 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM6));
            double tam7 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM7));
            double tam8 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM8));
            double tam9 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM9));
            double tam10 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM10));
            double tam11 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM11));
            double tam12 = cursor.getDouble(cursor.getColumnIndex(COLUMN_TAM12));
            double pu = cursor.getDouble(cursor.getColumnIndex(COLUMN_PU));
            double peu = cursor.getDouble(cursor.getColumnIndex(COLUMN_PEU));

            TechnologyAcceptanceResultData techAcceptanceResultData = new TechnologyAcceptanceResultData(
                    tam1, tam2, tam3, tam4, tam5, tam6, tam7, tam8, tam9, tam10, tam11, tam12, pu, peu);
            techAcceptanceResultsList.add(techAcceptanceResultData);
        }

        cursor.close();
        db.close();

        return techAcceptanceResultsList;
    }

    @SuppressLint("Range")
    public List<SubstitutionResultData> getSubstitutionResultsForUser(int userId) {
        List<SubstitutionResultData> substitutionResultsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_SUBSTITUTION_CORRECT, COLUMN_SUBSTITUTION_RESPONSE_TIME};
        String selection = COLUMN_SUBSTITUTION_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_SUBSTITUTION, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int correct = cursor.getInt(cursor.getColumnIndex(COLUMN_SUBSTITUTION_CORRECT));
            double responseTime = cursor.getDouble(cursor.getColumnIndex(COLUMN_SUBSTITUTION_RESPONSE_TIME));

            SubstitutionResultData substitutionResultData = new SubstitutionResultData(correct, responseTime);
            substitutionResultsList.add(substitutionResultData);
        }

        cursor.close();
        db.close();

        return substitutionResultsList;
    }

    public boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USERNAME};
        String selection = COLUMN_USERNAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        boolean isValid = cursor.getCount() > 0;

        cursor.close();
        db.close();

        return isValid;
    }

    public void updateConnectedStatus(String username, int connectedStatus) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONNECTED, connectedStatus);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USER, values, whereClause, whereArgs);
        db.close();
    }

}
