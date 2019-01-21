package com.example.emoticon.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.emoticon.Fragment.LatestFragment;
import com.example.emoticon.Fragment.PopularFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList=new ArrayList<>();

    public MainPageAdapter(FragmentManager fm) {
        super(fm);

        this.fragmentList.add(new LatestFragment());
        this.fragmentList.add(new PopularFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
