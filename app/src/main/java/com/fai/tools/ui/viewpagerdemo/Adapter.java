package com.fai.tools.ui.viewpagerdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/**
 * Created by PVer on 2018/4/22.
 */

public class Adapter extends PagerAdapter{

    private List<Integer> resources;
    private Context context;

    public Adapter(List<Integer> resources,Context context)
    {
        this.context = context;
        this.resources = resources;
    }

    @Override
    public int getCount() {
        return resources.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView img = new ImageView(context);
        img.setImageResource(resources.get(position));
//        img.setScaleType(ImageView.ScaleType);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(200, 200);
        img.setLayoutParams(params);
        container.addView(img);


//        Glide.with(context).load(resources.get(position)).into(img);

        return img;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
