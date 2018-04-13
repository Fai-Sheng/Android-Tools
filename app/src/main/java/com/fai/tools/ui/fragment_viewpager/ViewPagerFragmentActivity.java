package com.fai.tools.ui.fragment_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.fai.tools.R;
import com.fai.tools.ui.base.BaseActivity;
import com.fai.tools.ui.fragment_viewpager.adapter.ViewPagerAdapter;
import com.fai.tools.ui.fragment_viewpager.fragment.ExchangeFragment;
import com.fai.tools.ui.fragment_viewpager.fragment.HomeFragment;
import com.fai.tools.ui.fragment_viewpager.fragment.MineFragment;
import com.fai.tools.ui.fragment_viewpager.fragment.TreatFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerFragmentActivity extends BaseActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.home_radio)
    RadioButton radioHome;

    @BindView(R.id.exchange_radio)
    RadioButton radioExchange;

    @BindView(R.id.treat_radio)
    RadioButton radioTreat;

    @BindView(R.id.mine_radio)
    RadioButton radioMine;

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.toolbar)
    Toolbar toolBar;

    private ViewPagerAdapter adapter;
    private static final String TAG = "VPFActivity";
    private HomeFragment homeFragment;
    private ExchangeFragment exchangeFragment;
    private TreatFragment treatFragment;
    private MineFragment mineFragment;

    private List<Fragment> fragmentList;
    private List<RadioButton> radioButtonList;

    @Override
    protected void init(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        initToolBar();
        initFragmentAdapter();

    }


    private void initFragmentAdapter()
    {
        fragmentList = new ArrayList<>();
        radioButtonList = new ArrayList<>();

        homeFragment = new HomeFragment();
        exchangeFragment = new ExchangeFragment();
        treatFragment = new TreatFragment();
        mineFragment = new MineFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(exchangeFragment);
        fragmentList.add(treatFragment);
        fragmentList.add(mineFragment);

        radioButtonList.add(radioHome);
        radioButtonList.add(radioExchange);
        radioButtonList.add(radioTreat);
        radioButtonList.add(radioMine);

        setRadioGroupClickListener();
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList,this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(3);
    }

    private void setRadioGroupClickListener()
    {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Log.v(TAG,"onCheckedChanged");

//                View view = group.findViewById(checkedId);
//
//                if(!view.isPressed())
//                {
//                    return;
//                }

                switch (checkedId)
                {
                    case R.id.home_radio:
                        viewPager.setCurrentItem(0,true);
                        break;

                    case R.id.exchange_radio:
                        viewPager.setCurrentItem(1,true);
                        break;


                    case R.id.treat_radio:
                        viewPager.setCurrentItem(2,true);
                        break;

                    case R.id.mine_radio:
                        viewPager.setCurrentItem(3,true);
                        break;
                }
            }
        });
    }


    private void initToolBar()
    {
        Window window = getWindow();
        // Translucent status bar
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        setSupportActionBar(toolBar);
//        toolBar.setNavigationIcon(R.drawable.back_icon_white_24dp);
//        toolBar.setTitle("沉浸式效果");          //调用了setSupportActionBar之后，toolBar的setTitle的方法就失效了
//        toolBar.setSubtitle("miss");
//        setTitle("沉浸式效果");

    }


    private void tabSelected(int index)
    {
        if(index >= radioButtonList.size())
        {
            Log.v(TAG,"index超出范围了");
            return;
        }

        radioButtonList.get(index).setChecked(true);

        for(int i = 0;i < radioButtonList.size();i++)
        {
            if(i != index)
            {
                radioButtonList.get(i).setChecked(false);
            }
        }
    }




    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager_fragment;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
