package com.fai.tools.ui.fragment_viewpager.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by PVer on 2018/3/24.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{


    private List<Fragment> fragmentList;
    private Context context;
    private FragmentManager fm;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter (FragmentManager fm,List<Fragment> fragmentList,Context context)
    {
        super(fm);
        this.context = context;
        this.fm = fm;
        this.fragmentList = fragmentList;
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
