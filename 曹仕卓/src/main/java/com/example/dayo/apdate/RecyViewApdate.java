package com.example.dayo.apdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dayo.R;
import com.example.dayo.bean.JavaBean;

import java.util.ArrayList;

public class RecyViewApdate extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<JavaBean.DataBeanX.DataBean> list;

    public RecyViewApdate(Context context, ArrayList<JavaBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        JavaBean.DataBeanX.DataBean dataBean = list.get(position);
        viewHolder.tv_title.setText(dataBean.getFeeds_text());
        Glide.with(context).load(dataBean.getUrl()).into(viewHolder.iv_title);
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.iv_jian);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_title;
        public TextView tv_title;
        public ImageView iv_jian;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_title = (ImageView) rootView.findViewById(R.id.iv_title);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.iv_jian = (ImageView) rootView.findViewById(R.id.iv_jian);
        }

    }
}
