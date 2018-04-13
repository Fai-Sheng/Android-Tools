package com.fai.tools.ui.fragment_viewpager.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.fai.tools.R;
import com.fai.tools.ui.base.LazyBaseFragment;
import com.fai.tools.veryviewhelper.VerifiedViewShowHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends LazyBaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onFirstUserVisible() {
        //第一次的加载任务在这里
        VerifiedViewShowHelper.Builder builder = new VerifiedViewShowHelper.Builder();
        builder.setTargetView(getTargetView());

    }

    @Override
    protected void onUserVisible() {   //非第一次可见

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected void initViewAndEvent(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        setTargetView(view);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        TAG = "HomeFragment";
        super.setUserVisibleHint(isVisibleToUser);
    }
}
