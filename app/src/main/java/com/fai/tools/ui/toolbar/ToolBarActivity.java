package com.fai.tools.ui.toolbar;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.fai.tools.R;
import com.fai.tools.app.ToolsApplication;
import com.fai.tools.dagger.component.DaggerToolBarComponent;
import com.fai.tools.ui.base.BaseActivity;
import javax.inject.Inject;

public class ToolBarActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener{

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    private Toolbar toolbar;

    @Inject
    ToolsApplication application;


    @Override
    protected void init(Bundle savedInstanceState) {
        initActionBar();

        DaggerToolBarComponent.builder().appComponent(((ToolsApplication)getApplication()).getAppComponent()).build().inject(this);

        application.toast();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tool_bar;
    }


    private void initActionBar()
    {
        toolbar = findViewById(R.id.activity_toolBar);

        setSupportActionBar(toolbar);

        setTitle("ToolBar例子");

        //这里我们设置了一个SVG矢量图为 navigationIcon，只支持5.0以上的机器使用
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
        {
            toolbar.setNavigationIcon(R.drawable.back_icon_white_24dp);
        }
        toolbar.setSubtitle("奔跑吧，兄弟");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setOnMenuItemClickListener(this);
    }


    // 显示 菜单 三个竖着的点 和 menu中需要显示的 item都会显示出来
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return true;
    }

    // 点击menu的item
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.first_menu:
                Toast.makeText(getApplicationContext(),"firstMenu clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.second_menu:
                Toast.makeText(getApplicationContext(),"secondMenu clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.third_menu:
                Toast.makeText(getApplicationContext(),"thirdMenu clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fourth_menu:
                Toast.makeText(getApplicationContext(),"fourthMenu clicked",Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //给导航按钮添加返回功能
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
