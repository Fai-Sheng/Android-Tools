package com.fai.tools.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.rxlifecycle2.components.support.RxFragment;
import butterknife.ButterKnife;

/**
 * Created by PVer on 2018/3/24.
 */

public abstract class LazyBaseFragment extends RxFragment{

    protected boolean isFirstUserVisible = true;
    protected boolean isPrepared = false;
    private View targetView;
    private boolean isFirstUserInVisible = true;
    protected String TAG = "LazyBaseFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.v(TAG,"onCreateView");

        if (getLayoutId() != 0) {
            return inflater.inflate(getLayoutId(), container,false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewAndEvent(view,savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
        Log.v(TAG,"onActivityCreated");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG,"onStop");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        Log.v(TAG,"setUserVisibleHint:" + String.valueOf(isVisibleToUser));

        if(isVisibleToUser)
        {
            //可见
            if(isFirstUserVisible)
            {
                //第一次用户可见
                isFirstUserVisible = false;
                initPrepare();
            }
            else
            {
                onUserVisible();
            }
        }
        else
        {
            //不可见
            if(isFirstUserInVisible)
            {
                isFirstUserInVisible = false;
                onFirstUserInvisible();
            }
            else
            {
                onUserInvisible();
            }
        }
    }


    private synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    public View getTargetView() {
        return targetView;
    }

    public void setTargetView(View targetView) {
        this.targetView = targetView;
    }

    protected abstract @LayoutRes int getLayoutId();

    protected abstract void onFirstUserVisible();  //第一次用户可见

    protected abstract void onUserVisible();

    private void onFirstUserInvisible(){}

    protected abstract void onUserInvisible();

    protected abstract void initViewAndEvent(View view,Bundle savedInstanceState);
}
