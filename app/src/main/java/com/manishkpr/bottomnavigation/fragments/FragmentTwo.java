package com.manishkpr.bottomnavigation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manishkpr.bottomnavigation.R;
import com.manishkpr.bottomnavigation.adapters.SubViewPagerAdapter;


public class FragmentTwo extends Fragment {

    ViewPager viewPager;
    SubViewPagerAdapter subViewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);
        setUpViewPager(view);
        return view;
    }

    void setUpViewPager(View view){
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        subViewPagerAdapter = new SubViewPagerAdapter(getChildFragmentManager());

        // increase this limit if you have more tabs!
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(subViewPagerAdapter);
    }

}
