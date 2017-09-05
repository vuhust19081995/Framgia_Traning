package com.workspace.retrofitapp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by workspace on 05/09/2017.
 */

public class StudentDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Student.db";
    private static final String SQL_CREATE_CONTACTS = "CREATE TABLE "
            + StudentContract.StudentEntry.TABLE_NAME
            + " ("
            + StudentContract.StudentEntry._ID
            + " INTEGER PRIMARY KEY,"
            + StudentContract.StudentEntry.COLUMN_NAME
            + " TEXT,"
            + StudentContract.StudentEntry.COLUMN_EMAIL
            + " TEXT)";

    private static final String SQL_DELETE_CONTACTS =
            "DROP TABLE IF EXISTS " + StudentContract.StudentEntry.TABLE_NAME;

    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_CONTACTS);
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTS);
    }
}
