package com.swarawan.mvp.view.student;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.mvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rioswarawan on 7/23/17.
 */

public class StudentActivity extends Activity {

    private StudentPresenter presenter;
    private StudentAdapter adapter;
    private List<StudentModel> students;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        presenter = new StudentPresenter();
        presenter.attachView(onStudentListener);

        students = new ArrayList<>();
        adapter = new StudentAdapter(students, onStudentSelectedListener);

        ((RecyclerView) findViewById(R.id.list_student)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) findViewById(R.id.list_student)).setHasFixedSize(true);
        ((RecyclerView) findViewById(R.id.list_student)).setAdapter(adapter);

        findViewById(R.id.btn_save).setOnClickListener(onSaveClicked);
    }

    private View.OnClickListener onSaveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StudentModel model = new StudentModel();
            model.nim = ((EditText) findViewById(R.id.input_nim)).getText().toString();
            model.name = ((EditText) findViewById(R.id.input_name)).getText().toString();
            model.address = ((EditText) findViewById(R.id.input_address)).getText().toString();

            presenter.addStudent(model);
        }
    };

    private OnStudentListener onStudentListener = new OnStudentListener() {
        @Override
        public void onStudentAdded(StudentModel model) {
            students.add(model);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void showLoading() {
            // add dialog show here
        }

        @Override
        public void hideLoading() {
            // add dialog dismiss here
        }

        @Override
        public void onError(String message) {
            Toast.makeText(StudentActivity.this, message, Toast.LENGTH_LONG).show();
        }
    };

    private OnStudentSelectedListener onStudentSelectedListener = new OnStudentSelectedListener() {
        @Override
        public void onSelected(int position) {
            StudentModel student = students.get(position);
            Toast.makeText(StudentActivity.this, student.name + " dipilih!", Toast.LENGTH_SHORT).show();
        }
    };
}
