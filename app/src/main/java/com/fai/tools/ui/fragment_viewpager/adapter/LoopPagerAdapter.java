package com.fai.tools.ui.fragment_viewpager.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by PVer on 2018/4/22.
 */

public  class LoopPagerAdapter<T> extends PagerAdapter{


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
