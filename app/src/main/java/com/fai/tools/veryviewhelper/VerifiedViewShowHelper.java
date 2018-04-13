package com.fai.tools.veryviewhelper;

import android.view.View;

/**
 * Created by FAI on 2016/8/28.
 *
 */
@SuppressWarnings("ALL")
public class VerifiedViewShowHelper {

    public VerifiedViewShowHelper(View targetView){
        this(new ReplaceViewHelper(targetView));
        this.targetView = targetView;
    }
    public VerifiedViewShowHelper(ReplaceViewHelper replaceViewHelper){
        this.replaceViewHelper = replaceViewHelper;
    }

    private View targetView;

    private ReplaceViewHelper replaceViewHelper;

    private View errorNetView;

    private View noDataView;

    private View loadingView;

    public void setNoDataView(View noDataView) {
        this.noDataView = noDataView;
    }

    public void setLoadingView(View loadingView) {
        this.loadingView = loadingView;
    }

    public void setErrorNetViewAndListener(View errorNetView ,View.OnClickListener onClickListener){
        this.errorNetView = errorNetView;
        errorNetView.setOnClickListener(onClickListener);
    }

    /**
     * 正在加载的画面
     */
    public void showLoading(){
        replaceViewHelper.showCaseLayout(loadingView);
    }

    /**
     * 网络错误画面
     */
    public void showNetError(){
        replaceViewHelper.showCaseLayout(errorNetView);
    }

    /**
     * 数据为空的界面
     */
    public void showNoData(){
        replaceViewHelper.showCaseLayout(noDataView);
    }

    /**
     * 显示原来的数据页面
     */
    public void showDataView()
    {
        replaceViewHelper.restoreLayout();
    }

    /**
     * 释放VaryView
     */
    public void releaseVaryView() {
        errorNetView = null;
        loadingView = null;
        noDataView = null;
    }
    /**
     * 静态内部类Builder
     */
    public static class Builder{
        private View targetView;
        private View loadingView;
        private View noDataView;
        private View netErrorView;
        private View.OnClickListener onClickListener;

        public Builder setTargetView(View targetView){
            this.targetView = targetView;
            return this;
        }

        public Builder setLoadingView(View loadingView){
            this.loadingView = loadingView;
            return this;
        }

        public Builder setErrorView(View netErrorView){
            this.netErrorView = netErrorView;
            return this;
        }

        public Builder setNoDataView(View noDataView){
            this.noDataView = noDataView;
            return this;
        }

        /**
         * netError界面上的点击 重试事件
         * @param onClickListener
         * @return
         */
        public Builder setOnRetryListener(View.OnClickListener onClickListener){
            this.onClickListener = onClickListener;
            return this;
        }

        public VerifiedViewShowHelper build(){
            VerifiedViewShowHelper helper = new VerifiedViewShowHelper(targetView);
            if(loadingView != null)
                helper.setLoadingView(loadingView);
            if(noDataView != null)
                helper.setNoDataView(noDataView);
            if(netErrorView != null && onClickListener != null)
                helper.setErrorNetViewAndListener(netErrorView,onClickListener);
            return helper;
        }
    }
}
