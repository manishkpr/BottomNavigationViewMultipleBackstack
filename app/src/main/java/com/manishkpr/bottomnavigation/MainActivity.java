package com.manishkpr.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.manishkpr.bottomnavigation.adapters.CustomPagerAdapter;
import com.manishkpr.bottomnavigation.utils.BackStackFragment;
import com.manishkpr.bottomnavigation.utils.CustomViewPager;
import com.manishkpr.bottomnavigation.utils.HostFragment;


public class MainActivity extends AppCompatActivity {
    private CustomPagerAdapter customPagerAdapter;
    private CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setupViewPager();

    }

    void setupViewPager(){
        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());

        // increase this limit if you have more tabs!
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(customPagerAdapter);
        viewPager.setPagingEnabled(false);
    }

    @Override
    public void onBackPressed()
    {
        if(!BackStackFragment.handleBackPressed(getSupportFragmentManager())){
            super.onBackPressed();
        }
    }

    public void createSubFragment(Fragment fragment) {
        HostFragment hostFragment = (HostFragment) customPagerAdapter.getItem(viewPager.getCurrentItem());
        hostFragment.replaceFragment(fragment, true);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int index = customPagerAdapter.getIndexMenuItemId(item.getItemId());
            viewPager.setCurrentItem(index);
            toggleHomeBackIcon();
            return true;

        }

    };


    public void toggleHomeBackIcon() {

        if(BackStackFragment.handleBackHome(getSupportFragmentManager())){

            if(getSupportActionBar()!=null) {
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                //getSupportActionBar().setDisplayShowTitleEnabled(false);
            }

        }else{
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }
}
