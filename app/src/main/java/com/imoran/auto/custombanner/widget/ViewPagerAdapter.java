package com.imoran.auto.custombanner.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<Drawable> drawableList;
    private Context mContext;
    private List<ImageView> mCache;
    public ViewPagerAdapter(List<Drawable> list,Context context) {
        drawableList = list;
        mContext = context;
        mCache = new ArrayList<>();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (drawableList != null && drawableList.size() > 0) {
            View imageView = null;
            if (mCache.isEmpty()) {
                imageView = new ImageView(mContext);
            }else {
                imageView = mCache.remove(0);

            }
            ((ImageView) imageView).setImageDrawable(drawableList.get(position % drawableList.size()));
            container.addView(imageView);
            return imageView;
        }
        return null;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ImageView imageView = (ImageView) object;
        container.removeView(imageView);
        mCache.add(imageView);
    }
}
