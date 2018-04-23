package com.fai.tools.ui.fragment_viewpager.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

/**
 * Created by PVer on 2018/3/24.
 */

public class ViewPagerStateAdapter<T extends Fragment> extends FragmentStatePagerAdapter{

    private List<T> fragmentList;
    private Context context;
    private FragmentManager fm;

    public ViewPagerStateAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerStateAdapter(FragmentManager fm , List<T> fragmentList,Context context)
    {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.fm = fm;
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
