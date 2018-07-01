package com.fai.tools.ui.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fai.tools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;

    @BindView(R.id.img_1)
    ImageView img1;

    @BindView(R.id.img_2)
    ImageView img2;

    @BindView(R.id.btn_anim)
    Button btnAnim;

    @BindView(R.id.btn_anim_1)
    Button btnAnim1;

    @BindView(R.id.btn_anim_2)
    Button btnAnim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.bind(this);
        init();
    }


    private void init()
    {
        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator transX =  ObjectAnimator.ofFloat(img,"translationX",0,200);
                transX.setDuration(1000);
                transX.start();
            }
        });

        btnAnim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,200);
                valueAnimator.setDuration(1000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        img1.setTranslationX(value);
                        img1.requestLayout();
                    }
                });
            }
        });

        btnAnim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setTranslationX(0);
                img2.animate().translationX(200).setDuration(1000).start();
            }
        });
    }


}
