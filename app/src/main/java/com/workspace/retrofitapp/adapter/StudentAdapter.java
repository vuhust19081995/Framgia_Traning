package com.workspace.retrofitapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.workspace.retrofitapp.R;
import com.workspace.retrofitapp.data.model.Student;

import java.util.ArrayList;

/**
 * Created by workspace on 05/09/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private ArrayList<Student> listStudent;
    private ClickStudentListener mListener;

    public StudentAdapter(ArrayList<Student> listStudent, ClickStudentListener mListener) {
        this.listStudent = listStudent;
        this.mListener = mListener;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_student,parent,false);
        return new StudentViewHolder(view,this.mListener);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student student = listStudent.get(position);
        holder.tvNameStudent.setText(student.getmName());
        holder.tvEmailStudent.setText(student.getmEmail());
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvNameStudent;
        private TextView tvEmailStudent;
        private ClickStudentListener clickStudentListener;

        public StudentViewHolder(View itemView,ClickStudentListener clickStudentListener) {
            super(itemView);
            tvNameStudent = itemView.findViewById(R.id.tvNameStudent);
            tvEmailStudent = itemView.findViewById(R.id.tvEmailStudent);
            this.clickStudentListener = clickStudentListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Student student = listStudent.get(getAdapterPosition());
            this.clickStudentListener.onStudentClick(student);
        }
    }

    public interface ClickStudentListener{
        public void onStudentClick(Student student);
    }
}
