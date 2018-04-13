package com.fai.tools.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by PVer on 2018/3/23.
 */

public abstract class BaseActivity extends RxAppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init(savedInstanceState);
    }

    protected abstract void init(Bundle savedInstanceState);

    protected abstract @LayoutRes int getLayoutId();
}
