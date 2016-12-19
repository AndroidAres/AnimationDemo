package com.ares.animationdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Ares on 2016/10/8/008.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] title;
    private List<Fragment> list;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context, String[] title, List<Fragment> list) {
        super(fm);
        this.context = context;
        this.title = title;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
