package com.fai.tools.ui.fragment_viewpager.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by PVer on 2018/3/24.
 */

public class ViewPagerAdapter<T extends Fragment> extends FragmentPagerAdapter{

    private List<T> fragmentList;
    private Context context;
    private FragmentManager fm;
    private FragmentTransaction mFragmentTransaction = null;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter (FragmentManager fm,List<T> fragmentList,Context context)
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
