package com.example.dayo.fragment2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dayo.App;
import com.example.dayo.HomeForPecese;
import com.example.dayo.IView;
import com.example.dayo.R;
import com.example.dayo.apdate.ShoRecyViewApdate;
import com.example.dayo.bean.ShoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuiFragment extends Fragment implements IView {


    private RecyclerView rv;
    private ArrayList<ShoBean.DataBeanX.DataBean> list;
    private ShoRecyViewApdate shoRecyViewApdate;

    public TuiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tui, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        HomeForPecese homeForPecese = new HomeForPecese(this);
        homeForPecese.start();
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rt);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        shoRecyViewApdate = new ShoRecyViewApdate(getActivity(),list);
        rv.setAdapter(shoRecyViewApdate);
    }

    @Override
    public void sudshd(Object object) {
        if(object instanceof ShoBean){
            ShoBean shoBean = (ShoBean) object;
            List<ShoBean.DataBeanX.DataBean> data = shoBean.getData().getData();
            list.addAll(data);
            shoRecyViewApdate.notifyDataSetChanged();
        }
    }

    @Override
    public void fisjd(String msg) {

    }
}
