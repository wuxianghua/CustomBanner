package com.imoran.auto.custombanner.widget;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.IllegalFormatCodePointException;

public class AutoScrollHandler extends Handler {
    private static final String TAG = "AutoScrollHandler";
    private WeakReference<AutoScrollViewPager> mBannerRef;
    private static final int MSG_CHANGE_SELECTION = 1;
    private static final int AUTO_SCROLL_TIME = 2000;

    public AutoScrollHandler(AutoScrollViewPager autoScrollViewPager) {
        mBannerRef = new WeakReference<>(autoScrollViewPager);
    }

    public void start() {
        removeMessages(MSG_CHANGE_SELECTION);
        sendEmptyMessageDelayed(MSG_CHANGE_SELECTION,AUTO_SCROLL_TIME);
    }

    public void stop() {
        removeMessages(MSG_CHANGE_SELECTION);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what == MSG_CHANGE_SELECTION) {
            if (mBannerRef == null || mBannerRef.get() == null) {
                return;
            }
            AutoScrollViewPager banner = mBannerRef.get();
            int current = banner.getCurrentItem();
            banner.setCurrentItem(current + 1);
            sendEmptyMessageDelayed(MSG_CHANGE_SELECTION,AUTO_SCROLL_TIME);
        }
    }
}
