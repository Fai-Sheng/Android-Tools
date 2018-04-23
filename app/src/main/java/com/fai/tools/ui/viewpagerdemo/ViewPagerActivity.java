package com.fai.tools.ui.viewpagerdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import com.fai.tools.R;
import com.fai.tools.ui.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PVer on 2018/4/21.
 */

public class ViewPagerActivity extends BaseActivity{

    @BindView(R.id.vp_demo_toolBar)
    Toolbar toolBar;

    @BindView(R.id.selectable_items_pager)
    ViewPager itemsPager;

    private Adapter adapter;

    @Override
    protected void init(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        initToolBar();
        initPager();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager_demo;
    }


    private void initToolBar()
    {
        Window window = getWindow();
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

//        window.setStatusBarColor(Color.TRANSPARENT);

        setSupportActionBar(toolBar);

        setTitle("ViewPager的例子");

        // 安卓5.0以上
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
        {
            toolBar.setNavigationIcon(R.drawable.back_icon_white_24dp);
        }
        else
        {
            // 安卓5.0以下 没有效果
//            @SuppressLint("RestrictedApi")
//            Drawable navigationDrawable = AppCompatDrawableManager.get().getDrawable(this, R.drawable.back_icon_white_24dp);
//            toolBar.setNavigationIcon(navigationDrawable);
        }

        toolBar.setSubtitle("子title");

    }


    private void initPager()
    {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.vp_item_1);
        list.add(R.mipmap.vp_item_2);
        list.add(R.mipmap.vp_item_3);
        list.add(R.mipmap.vp_item_4);
        list.add(R.mipmap.vp_item_5);
        list.add(R.mipmap.vp_item_6);
        list.add(R.mipmap.vp_item_7);
        list.add(R.mipmap.vp_item_8);

        adapter = new Adapter(list,this);
        itemsPager.setAdapter(adapter);
        itemsPager.setPageMargin(80);
        itemsPager.setOffscreenPageLimit(3);
    }
}
