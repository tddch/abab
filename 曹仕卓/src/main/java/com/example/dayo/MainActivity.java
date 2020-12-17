package com.example.dayo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dayo.fragment.BlankFragment1;
import com.example.dayo.fragment.BlankFragment2;
import com.example.dayo.fragment.BlankFragment3;
import com.example.dayo.fragment.BlankFragment4;
import com.example.dayo.fragment.BlankFragment5;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list;
    private ViewPerApdate viewPerApdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        list = new ArrayList<>();
        list.add(new BlankFragment1());
        list.add(new BlankFragment2());
        list.add(new BlankFragment3());
        list.add(new BlankFragment4());
        list.add(new BlankFragment5());
        viewPerApdate = new ViewPerApdate(getSupportFragmentManager(), list);
        vp.setAdapter(viewPerApdate);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页").setIcon(R.drawable.a);
        tab.getTabAt(1).setText("沙发").setIcon(R.drawable.b);
        tab.getTabAt(2).setText("").setIcon(R.drawable.e);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.c);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.d);
    }
}
