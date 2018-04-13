package com.fai.tools.veryviewhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fai.tools.veryviewhelper.base.ICaseViewHelper;


/**
 * Created by FAI on 2016/8/28.
 */
public class ReplaceViewHelper implements ICaseViewHelper {

    public View targetView;   // 用来保存显示数据的页面
    public View mCurrentView;   //当前的页面
    public ViewGroup mParentView;  //数据页面的父页面
    public ViewGroup.LayoutParams mLayoutParams;
    public int mViewIndex;
    public ReplaceViewHelper(View dataView){

        /*记录显示数据的View*/
        this.targetView =dataView;
        mLayoutParams =dataView.getLayoutParams();
        /*记录父View*/
        if (dataView.getParent()!=null){
            mParentView =(ViewGroup)dataView.getParent();
        }else {
            mParentView =(ViewGroup)dataView.getRootView();
        }

        /*记录要显示的View在父View中的位置*/
        int childCount= mParentView.getChildCount();
        for (int index=0;index<childCount;index++){
            if (dataView== mParentView.getChildAt(index)){
                mViewIndex =index;
                break;
            }
        }
        this.mCurrentView =dataView;
    }

    @Override
    public Context getContext() {
        return targetView.getContext();
    }

    @Override
    public View getDataView() {
        return targetView;
    }

    @Override
    public View getCurrentView() {
        return mCurrentView;
    }

    @Override
    public void restoreLayout() {
        showCaseLayout(targetView);
    }

    @Override
    public void showCaseLayout(View view) {
        if(view==null){
            return;
        }
        this.mCurrentView =view; //mCurrentView 始终保存当前的页面

        /*如果要显示的View跟已显示View一样，就不用切换了*/
        if (mParentView.getChildAt(mViewIndex)!=view){
            ViewGroup parent=(ViewGroup)view.getParent();
            if (parent!=null){
                parent.removeView(view);
            }
            /*切换的时候，先移除原先显示的View,再显示需要的View*/
            mParentView.removeViewAt(mViewIndex);
            mParentView.addView(view, mViewIndex, mLayoutParams);
        }
    }

    @Override
    public void showCaseLayout(int layoutId) {
        showCaseLayout(inflate(layoutId));
    }

    @Override
    public View inflate(int layoutId) {
        return LayoutInflater.from(targetView.getContext()).inflate(layoutId, null);
    }
}
