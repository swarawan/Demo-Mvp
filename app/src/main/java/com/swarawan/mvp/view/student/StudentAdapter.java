package com.swarawan.mvp.view.student;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.swarawan.mvp.MvpApp;
import com.swarawan.mvp.R;

import java.util.List;

/**
 * Created by rioswarawan on 7/13/16.
 */
public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StudentModel> data;
    private LayoutInflater inflater;
    private OnStudentSelectedListener listener;

    public StudentAdapter(List<StudentModel> data, OnStudentSelectedListener listener) {
        this.data = data;
        this.listener = listener;
        this.inflater = LayoutInflater.from(MvpApp.context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_student, parent, false);
        return new BodyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        StudentModel model = data.get(position);
        BodyViewHolder body = (BodyViewHolder) holder;
        body.nim.setText(model.nim);
        body.name.setText(model.name);
        body.address.setText(model.address);
        body.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSelected(position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class BodyViewHolder extends RecyclerView.ViewHolder {

        TextView nim;
        TextView name;
        TextView address;
        LinearLayout layout;

        BodyViewHolder(View itemView) {
            super(itemView);
            nim = (TextView) itemView.findViewById(R.id.text_nim);
            name = (TextView) itemView.findViewById(R.id.text_name);
            address = (TextView) itemView.findViewById(R.id.text_address);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);
        }
    }
}