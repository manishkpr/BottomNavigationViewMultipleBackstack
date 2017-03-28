package com.manishkpr.bottomnavigation.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manishkpr.bottomnavigation.MainActivity;
import com.manishkpr.bottomnavigation.R;

public class HostFragment extends BackStackFragment {
    private Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.host_fragment, container, false);
        if (fragment != null) {
            replaceFragment(fragment, false);
        }
        return view;
    }

    public void replaceFragment(Fragment fragment, boolean addToBackstack) {
        if (addToBackstack) {
            getChildFragmentManager().beginTransaction().replace(R.id.hosted_fragment, fragment).addToBackStack(null).commit();
            getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                @Override
                public void onBackStackChanged() {
                    ((MainActivity)getActivity()).toggleHomeBackIcon();
                }
            });
        } else {
            getChildFragmentManager().beginTransaction().replace(R.id.hosted_fragment, fragment).commit();
        }
    }

    public static HostFragment newInstance(Fragment fragment) {
        HostFragment hostFragment = new HostFragment();
        hostFragment.fragment = fragment;
        return hostFragment;
    }
}
