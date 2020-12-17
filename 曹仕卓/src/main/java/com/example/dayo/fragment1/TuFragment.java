package com.example.dayo.fragment1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dayo.HomeForPecese;
import com.example.dayo.IView;
import com.example.dayo.R;
import com.example.dayo.apdate.RecyViewApdate;
import com.example.dayo.bean.JavaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuFragment extends Fragment implements IView {


    private RecyclerView rv;
    private ArrayList<JavaBean.DataBeanX.DataBean> list;
    private RecyViewApdate recyViewApdate;

    public TuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tu, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        HomeForPecese homeForPecese = new HomeForPecese(this);
        homeForPecese.start();
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        recyViewApdate = new RecyViewApdate(getActivity(),list);
        rv.setAdapter(recyViewApdate);
    }

    @Override
    public void sudshd(Object object) {
        if(object instanceof JavaBean){
            JavaBean javaBean = (JavaBean) object;
            List<JavaBean.DataBeanX.DataBean> data = javaBean.getData().getData();
            list.addAll(data);
            recyViewApdate.notifyDataSetChanged();
        }

    }

    @Override
    public void fisjd(String msg) {

    }
}
