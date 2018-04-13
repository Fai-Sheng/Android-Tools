package com.fai.tools.ui.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.fai.tools.R;
import com.fai.tools.app.ToolsApplication;
import com.fai.tools.dagger.component.DaggerToolBarComponent;

import javax.inject.Inject;

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Inject
    ToolsApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        initActionBar();

        DaggerToolBarComponent.builder().appComponent(((ToolsApplication)getApplication()).getAppComponent()).build().inject(this);

        application.toast();
    }



    private void initActionBar()
    {
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        setTitle("测试ToolBar");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}
