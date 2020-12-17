package com.example.dayo.apdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dayo.R;
import com.example.dayo.Student;

import java.util.ArrayList;

public class StuRecyViewApdate extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Student> list;

    public StuRecyViewApdate(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sho, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Student student = list.get(position);
        viewHolder.tvs.setText(student.getTvs());
        viewHolder.tvse.setText(student.getTvse());
        Glide.with(context).load(student.getImg()).into(viewHolder.ivs);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView ivs;
        public TextView tvs;
        public TextView tvse;
        public Button but;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ivs = (ImageView) rootView.findViewById(R.id.ivs);
            this.tvs = (TextView) rootView.findViewById(R.id.tvs);
            this.tvse = (TextView) rootView.findViewById(R.id.tvse);
            this.but = (Button) rootView.findViewById(R.id.but);
        }

    }
}
