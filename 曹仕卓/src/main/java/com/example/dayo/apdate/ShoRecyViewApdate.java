package com.example.dayo.apdate;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dayo.App;
import com.example.dayo.R;
import com.example.dayo.Student;
import com.example.dayo.bean.ShoBean;
import com.example.dayo.db.StudentDao;

import java.util.ArrayList;

public class ShoRecyViewApdate extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShoBean.DataBeanX.DataBean> list;

    public ShoRecyViewApdate(Context context, ArrayList<ShoBean.DataBeanX.DataBean> list) {
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        ShoBean.DataBeanX.DataBean dataBean = list.get(position);
        viewHolder.tvse.setText(dataBean.getFeedNum()+"条热门内容");
        viewHolder.tvs.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getIcon()).into(viewHolder.ivs);
        viewHolder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setImg(list.get(position).getIcon());
                student.setTvs(list.get(position).getTitle());
                student.setTvse(list.get(position).getFeedNum()+"条热门内容");
                StudentDao studentDao = App.daoSession.getStudentDao();
                viewHolder.but.setText("已关注");
                long insert = studentDao.insert(student);
                if(insert>0){
                    Log.e("TAG","添加成功");
                }else{
                    Log.e("TAG","添加失败");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyViewApdate.ViewHolder {
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
