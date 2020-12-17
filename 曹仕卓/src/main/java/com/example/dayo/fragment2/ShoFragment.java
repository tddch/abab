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
import com.example.dayo.R;
import com.example.dayo.Student;
import com.example.dayo.apdate.StuRecyViewApdate;
import com.example.dayo.bean.ShoBean;
import com.example.dayo.db.StudentDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoFragment extends Fragment {


    private RecyclerView rv;
    private ArrayList<Student> list;
    private StuRecyViewApdate stuRecyViewApdate;

    public ShoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sho, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        StudentDao studentDao = App.daoSession.getStudentDao();
        List<Student> students = studentDao.loadAll();
        list.addAll(students);
        stuRecyViewApdate.notifyDataSetChanged();
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rf);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        stuRecyViewApdate = new StuRecyViewApdate(getActivity(),list);
        rv.setAdapter(stuRecyViewApdate);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            initData();
        }
    }

    //    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if(isVisibleToUser){
//            initData();
//        }
//    }
}
