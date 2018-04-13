package com.fai.tools.ui.fragment_viewpager.fragment;

import android.os.Bundle;
import android.view.View;

import com.fai.tools.R;
import com.fai.tools.ui.base.LazyBaseFragment;

import butterknife.ButterKnife;


public class ExchangeFragment extends LazyBaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_exchange;
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected void initViewAndEvent(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        setTargetView(view);
        TAG = "ExchangeFragment";
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        TAG = "ExchangeFragment";
        super.setUserVisibleHint(isVisibleToUser);
    }
}
