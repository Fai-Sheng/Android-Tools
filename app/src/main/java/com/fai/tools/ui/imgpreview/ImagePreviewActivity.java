package com.fai.tools.ui.imgpreview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.fai.tools.R;
import com.fai.tools.utils.DensityUtils;

public class ImagePreviewActivity extends FragmentActivity {

    private int leftDelta;
    private int topDelta;
    private int widthDelta;
    private int heightDelta;
    private float scaleXDelta;
    private float scaleYDelta;
    private boolean isFinishing = false;
    private boolean isJumpInAlready = false;

    private int[] imgLocation = new int[2];
    private int left;
    private int top;
    private int width;
    private int height;

    private int smallLeft;
    private int smallTop;
    private int smallWidth;
    private int smallHeight;
    private String imgUrl;

    private ImageView img;
    private boolean animated = false;
    //https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530210620282&di=3419dbfa43c8a7cec09b248b8b54f008&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201307%2F19%2F084310or7vzvutztfvocuc.jpg


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        initViews();
        initData();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!animated && hasFocus) {
            animated = true;
            initViewData();
        }
    }

    private void initViews(){
        img = findViewById(R.id.img_preview);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData(){
        Intent intent = getIntent();
        smallLeft   = intent.getIntExtra("Left",0);
        smallTop   = intent.getIntExtra("Top",0);
        smallWidth = intent.getIntExtra("Width",0);
        smallHeight = intent.getIntExtra("Height",0);
        imgUrl   = intent.getStringExtra("ImgUrl");
        Glide.with(this).load(imgUrl).into(img);
    }

    private void initViewData(){
        img.getLocationOnScreen(imgLocation);
        left = imgLocation[0];
        top = imgLocation[1];
        width = img.getWidth();
        height = img.getHeight();

        leftDelta = left - smallLeft;
        topDelta = top - smallTop;
        scaleXDelta = smallWidth*(1.0f) / width;
        scaleYDelta = smallHeight * (1.0f) / height;

        enterAnim();
    }


    private void enterAnim() {

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(img, "scaleX", scaleXDelta, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(img, "scaleY", scaleYDelta, 1f);

        @SuppressLint("ObjectAnimatorBinding")
        ObjectAnimator translationX = ObjectAnimator.ofFloat(img, "translationX", -leftDelta, 0);
        @SuppressLint("ObjectAnimatorBinding")
        ObjectAnimator translationY = ObjectAnimator.ofFloat(img, "translationY", -topDelta, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000);
        animatorSet.playTogether(translationX, translationY, scaleX, scaleY);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isJumpInAlready = true;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void enterAnim2()
    {
        img.setPivotX(0);
        img.setPivotY(0);
        img.setScaleX(scaleXDelta);
        img.setScaleY(scaleYDelta);
        img.setTranslationX(-leftDelta);
        img.setTranslationY(-topDelta);
        img.animate().translationX(0).translationY(0).scaleX(1f).scaleY(1.0f).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                isJumpInAlready = true;
            }
        }).start();
    }

    private void exitAnim()
    {
        img.setPivotX(0);
        img.setPivotY(0);
        img.setScaleX(1);
        img.setScaleY(1);
        img.setTranslationX(0);
        img.setTranslationY(0);

        img.animate().translationY(-topDelta).translationX(-leftDelta).scaleX(scaleXDelta).scaleY(scaleYDelta).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                finish();
                overridePendingTransition(0,0);
            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        if(!isFinishing && isJumpInAlready){
            isFinishing = true;
            exitAnim();
        }
    }
}
