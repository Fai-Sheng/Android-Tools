package com.fai.tools;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fai.autoassignment.core.Resolver;
import com.fai.autoassignment.imp.FieldResolver;
import com.fai.tools.model.Friend;
import com.fai.tools.model.ParcelData;
import com.fai.tools.model.Person;
import com.fai.tools.model.User;
import com.fai.tools.ui.fragment_viewpager.ViewPagerFragmentActivity;
import com.fai.tools.ui.fragments_in_one_activity.activity.FragmentsDemoNavActivity;
import com.fai.tools.ui.mvp.MVPLoginActivity;
import com.fai.tools.ui.base.BaseActivity;
import com.fai.tools.ui.toolbar.ToolBarActivity;
import com.fai.tools.ui.viewpagerdemo.ViewPagerActivity;
import com.fai.tools.ui.zxing.ZxingActivity;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private Button btnZxing;
    private Button btnMvp;
    private Button btnToolBar;
    private Button viewPager_fragmentBtn;

    @BindView(R.id.viewPagerDemoBtn)
    Button viewPagerDemoBtn;

    @BindView(R.id.oneActManyFratsBtn)
    Button oneActManyFragmetsBtn;

    private static final String TAG = "GoogleMainActivity";

    static class MainHandler extends Handler{

        private WeakReference<MainActivity> weakReferenceMainActivity;

        public MainHandler(MainActivity mainActivity)
        {
            WeakReference<MainActivity> weakReference = new WeakReference<>(mainActivity);
            this.weakReferenceMainActivity = weakReference;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void init(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        init();
        ceshi();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void ceshi()
    {
        User user = new User();
        user.age = 23;
        user.career = "软件工程师";
        user.name = "sheng";
        user.family = new User.Family();
        user.family.father = "szl";
        user.family.mother = "wp";
        user.family.grandMom = "nainai";
        user.family.grandPa = "yeye";
        user.x = new User.XXX();
        user.x.xxx = "qwer";
        user.x.yyy = "tyui";
        user.x.zzz = "poiu";
        user.x.ttt = "asdf";
        user.x.h = new User.XXX.HHH();
        user.x.h.ccc = "234";
        user.x.h.qqq = "456";
        user.x.h.ooo = "890";

        Person person = new Person();
        FieldResolver fieldResolver = new FieldResolver();
        person = fieldResolver.execSetParam(user,person);
        Gson gson = new Gson();
        String log = gson.toJson(person);
        Log.v("MainActivity",log);
        fieldResolver.toString();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void init()
    {
        btnZxing = findViewById(R.id.btn_to_zxing);

        btnZxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZxingActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btnMvp = findViewById(R.id.mvp_btn);

        btnMvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MVPLoginActivity.class);

                ParcelData data = new ParcelData("fai","engineer","cool job",23,false,null,null);

                intent.putExtra("parcel",data);

                MainActivity.this.startActivity(intent);
            }
        });

        btnToolBar = findViewById(R.id.toolbar_btn);

        btnToolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToolBarActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        viewPager_fragmentBtn = findViewById(R.id.viewPagerFragmentBtn);

        viewPager_fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPagerFragmentActivity.class);
                startActivity(intent);
            }
        });


        viewPagerDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        oneActManyFragmetsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentsDemoNavActivity.class);
                startActivity(intent);
            }
        });


        MainHandler handler = new MainHandler(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext(),"测试Handler内存泄漏问题",Toast.LENGTH_SHORT).show();

            }
        },5*1000);

    }


}
