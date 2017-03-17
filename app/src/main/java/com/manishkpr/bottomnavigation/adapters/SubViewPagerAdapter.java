package com.manishkpr.bottomnavigation.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.manishkpr.bottomnavigation.models.FragmentItem;
import com.manishkpr.bottomnavigation.fragments.FragmentOne;
import com.manishkpr.bottomnavigation.fragments.FragmentTwoSub;
import com.manishkpr.bottomnavigation.utils.HostFragment;

import java.util.ArrayList;
import java.util.List;

public class SubViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<FragmentItem> fragmentItemList;


    public SubViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        fragmentItemList = new ArrayList(0);
        initializeTabs();
    }

    public void addFragment(Fragment fragment, String title, int idMenuItem) {

        fragmentItemList.add(new FragmentItem(fragment, title, idMenuItem));
    }


    public void addFragmentItem(FragmentItem fragmentItem) {

        fragmentItemList.add(fragmentItem);
    }

    public int getIndexMenuItemId(int idMenuItem) {

        int index = 0;

        for(FragmentItem item : fragmentItemList) {

            if(item.getIdMenuItem() == idMenuItem) {

                break;
            }

            index++;
        }

        return index;
    }

    private void initializeTabs() {
        addFragment(HostFragment.newInstance(new FragmentTwoSub()), "Sub First Fragment", 3);
        addFragment(HostFragment.newInstance(new FragmentOne()), "Sub Second Fragment", 4);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentItemList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentItemList.size();
    }


}
