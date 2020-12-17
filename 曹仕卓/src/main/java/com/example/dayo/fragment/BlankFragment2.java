package com.example.dayo.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dayo.R;
import com.example.dayo.ViewPerApdate;
import com.example.dayo.fragment1.ShiFragment;
import com.example.dayo.fragment1.TextFragment;
import com.example.dayo.fragment1.TuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment  {


    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list;
    private ViewPerApdate viewPerApdate;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(view);
        return view;
    }



    private void initView(View view) {
        vp = view.findViewById(R.id.vp);
        tab = view.findViewById(R.id.tab);
        list = new ArrayList<>();
        list.add(new TuFragment());
        list.add(new ShiFragment());
        list.add(new TextFragment());
        viewPerApdate = new ViewPerApdate(getChildFragmentManager(), list);
        vp.setAdapter(viewPerApdate);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }


}
