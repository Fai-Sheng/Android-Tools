package com.fai.tools.ui.fragment_viewpager.network;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

/**
 * Created by PVer on 2018/3/25.
 */

public class NetModel {


    /**
     * 模拟一个网络请求
     * @return
     */
    public Flowable<Long> queryServer()
    {
        return Flowable.timer(10, TimeUnit.SECONDS);
    }
}
