package com.workspace.retrofitapp.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.workspace.retrofitapp.data.model.Student;

/**
 * Created by workspace on 05/09/2017.
 */

public class StudentModify {
    private StudentDbHelper studentDbHelper;

    public StudentModify(Context context) {
        studentDbHelper = new StudentDbHelper(context);
    }

    public void insertStudent(Student mStudent){
        SQLiteDatabase sqLiteDatabase = studentDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentContract.StudentEntry.COLUMN_NAME,mStudent.getmName());
        contentValues.put(StudentContract.StudentEntry.COLUMN_EMAIL,mStudent.getmEmail());
        sqLiteDatabase.insert(StudentContract.StudentEntry.TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public void updateStudent(Student mStudent){
        SQLiteDatabase sqLiteDatabase = studentDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentContract.StudentEntry.COLUMN_NAME,mStudent.getmName());
        contentValues.put(StudentContract.StudentEntry.COLUMN_EMAIL,mStudent.getmEmail());
        String selection = StudentContract.StudentEntry._ID+"=?";
        String[] selectionArgs = {mStudent.getmId()+""};
        sqLiteDatabase.update(StudentContract.StudentEntry.TABLE_NAME,contentValues,selection,selectionArgs);
        sqLiteDatabase.close();
    }

    public void deleteStudent(int student_id){
        SQLiteDatabase sqLiteDatabase = studentDbHelper.getWritableDatabase();
        String selection = StudentContract.StudentEntry._ID+"=?";
        String[] selectionArgs = {student_id+""};
        sqLiteDatabase.delete(StudentContract.StudentEntry.TABLE_NAME,selection,selectionArgs);
        sqLiteDatabase.close();
    }

    public Cursor getCursorStudents(){
        SQLiteDatabase db = studentDbHelper.getReadableDatabase();
        String[] projection = {
                StudentContract.StudentEntry._ID,
                StudentContract.StudentEntry.COLUMN_NAME,
                StudentContract.StudentEntry.COLUMN_EMAIL
        };
        Cursor cursor = db.query(StudentContract.StudentEntry.TABLE_NAME,projection,null,null,null,null,null);
//        db.close();
        return cursor;
    }
}
