package com.fai.tools.ui.surfaceview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.SurfaceView;
import com.fai.tools.R;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by PVer on 2018/3/20.
 */

public class SurfaceViewActivity extends AutoLayoutActivity{

    private SurfaceView surfaceView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface);

    }

}
