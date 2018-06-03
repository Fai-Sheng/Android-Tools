package com.fai.tools.ui.fragments_in_one_activity.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.fai.tools.R;
import com.fai.tools.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoogleMainActivity extends BaseActivity {

    @BindView(R.id.navi_view)
    NavigationView navigationView;

    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void init(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Toast.makeText(GoogleMainActivity.this,item.getItemId() + "被点击了",Toast.LENGTH_SHORT).show();


                return true;
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_google;
    }
}
