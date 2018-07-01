package com.fai.tools.ui.imgpreview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fai.tools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridImageActivity extends FragmentActivity {

    @BindView(R.id.img)
    ImageView imgView;

    private static final String IMG_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530210620282&di=3419dbfa43c8a7cec09b248b8b54f008&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201307%2F19%2F084310or7vzvutztfvocuc.jpg";
    private ValueAnimator valueAnimator;
    private int[] location = new int[2];
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image);
        ButterKnife.bind(this);
        init();
    }

    private void init()
    {
        Glide.with(this).load(IMG_URL).into(imgView);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.getLocationOnScreen(location);
                width = imgView.getWidth();
                height = imgView.getHeight();

                Intent intent = new Intent(GridImageActivity.this,ImagePreviewActivity.class);
                intent.putExtra("Left",location[0]);
                intent.putExtra("Top",location[1]);
                intent.putExtra("Width",width);
                intent.putExtra("Height",height);
                intent.putExtra("ImgUrl",IMG_URL);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });
    }

}
