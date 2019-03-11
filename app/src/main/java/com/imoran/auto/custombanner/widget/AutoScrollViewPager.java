package com.imoran.auto.custombanner.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.lang.reflect.Field;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_OUTSIDE;
import static android.view.MotionEvent.ACTION_UP;

public class AutoScrollViewPager extends ViewPager {
    private static final String TAG = "AutoScrollViewPager";
    private AutoScrollHandler autoScrollHandler;
    private Context mContext;

    public AutoScrollViewPager(@NonNull Context context) {
        this(context,null);
        mContext = context;
        autoScrollHandler = new AutoScrollHandler(this);
    }

    public AutoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        autoScrollHandler = new AutoScrollHandler(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == ACTION_UP || action == ACTION_CANCEL || action == ACTION_OUTSIDE) {
            startAutoPlay();
        }else if (action == ACTION_DOWN) {
            stopAutoPlay();
        }
        return super.dispatchTouchEvent(ev);
    }

    public void startAutoPlay() {
        if (autoScrollHandler != null) {
            autoScrollHandler.start();
        }
    }

    public void stopAutoPlay() {
        if (autoScrollHandler != null) {
            autoScrollHandler.stop();
        }
    }
}
