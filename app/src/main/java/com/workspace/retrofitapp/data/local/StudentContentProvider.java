package com.workspace.retrofitapp.data.local;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by workspace on 06/09/2017.
 */

public class StudentContentProvider extends ContentProvider {
    public final static String AUTHORITY = "com.vanvu.ContentProvider";
    public static final String SCHEME = "content://";
    public static final String URL_DATA_BASE = SCHEME + AUTHORITY + "/contact";
    public static final Uri CONTENT_URI = Uri.parse(URL_DATA_BASE);
    private static final int URI_STUDENT = 0;
    private static UriMatcher sUriMatcher;
    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY, "contact", URI_STUDENT);
    }
    private StudentDbHelper mStudentDbHelper;
    private SQLiteDatabase mSqLiteDatabase;
    @Override
    public boolean onCreate() {
        mStudentDbHelper = new StudentDbHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection
            , @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        mSqLiteDatabase = mStudentDbHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case URI_STUDENT:
                return mSqLiteDatabase.query(StudentContract.StudentEntry.TABLE_NAME,
                        projection, selection, selectionArgs, sortOrder, null, null);
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long index;
        mSqLiteDatabase = mStudentDbHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case URI_STUDENT:
                index = mSqLiteDatabase.insert(StudentContract.StudentEntry.TABLE_NAME,
                        null, contentValues);
                Uri uri_ = null;
                if (index != -1) {
                    uri_ = ContentUris.withAppendedId(CONTENT_URI, index);
                }
                return uri_;
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        mSqLiteDatabase = mStudentDbHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case URI_STUDENT:
                return mSqLiteDatabase.delete(StudentContract.StudentEntry.TABLE_NAME,
                        selection, selectionArgs);
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues
            , @Nullable String selection, @Nullable String[] selectionArgs) {
        switch (sUriMatcher.match(uri)) {
            case URI_STUDENT:
                return mSqLiteDatabase.update(StudentContract.StudentEntry.TABLE_NAME, contentValues,
                        selection, selectionArgs);
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }
}
