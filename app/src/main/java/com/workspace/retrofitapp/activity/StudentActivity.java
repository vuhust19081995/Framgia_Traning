package com.workspace.retrofitapp.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.workspace.retrofitapp.R;
import com.workspace.retrofitapp.adapter.StudentAdapter;
import com.workspace.retrofitapp.data.local.StudentContract;
import com.workspace.retrofitapp.data.local.StudentModify;
import com.workspace.retrofitapp.data.model.Student;
import com.workspace.retrofitapp.utils.DialogInsertStudent;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity implements DialogInsertStudent.NoticeListener {
    private RecyclerView rcShowStudent;
    private StudentModify studentModify;
    private LinearLayoutManager linearLayoutManager;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> listStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        init();
    }

    public void init() {
        listStudent = new ArrayList<>();
        studentModify = new StudentModify(this);
        rcShowStudent = (RecyclerView) findViewById(R.id.rcShowStudent);
        linearLayoutManager = new LinearLayoutManager(this);
        rcShowStudent.setLayoutManager(linearLayoutManager);
        studentAdapter = new StudentAdapter(listStudent, new StudentAdapter.ClickStudentListener() {
            @Override
            public void onStudentClick(Student student) {
                Toast.makeText(StudentActivity.this, student.getmName() + "/n" + student.getmEmail(), Toast.LENGTH_SHORT).show();
            }
        });
        rcShowStudent.setAdapter(studentAdapter);
        displayListStudent();
    }

    public void displayListStudent(){
        Cursor cursor = studentModify.getCursorStudents();
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_EMAIL));
            listStudent.add(new Student(id,name,email));
        }
        studentAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuInsert:
                showDialogInsert();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialogInsert(){
        DialogInsertStudent dialogInsertStudent = new DialogInsertStudent();
        dialogInsertStudent.show(getSupportFragmentManager(),"DialogInsert");
    }

    @Override
    public void onDialogPositiveClick(String name, String email) {
        Student student = new Student(name,email);
        studentModify.insertStudent(student);
        displayListStudent();
    }
}
