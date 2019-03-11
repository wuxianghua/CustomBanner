package com.imoran.auto.custombanner;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.imoran.auto.custombanner.widget.AutoScrollHandler;
import com.imoran.auto.custombanner.widget.AutoScrollViewPager;
import com.imoran.auto.custombanner.widget.BannerIndicator;
import com.imoran.auto.custombanner.widget.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AutoScrollViewPager autoScrollViewPager;
    private List<Drawable> drawableList = new ArrayList<>();
    private BannerIndicator bannerIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intData();
        autoScrollViewPager = findViewById(R.id.auto_scroll_viewpager);
        bannerIndicator = findViewById(R.id.indicator);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(drawableList,this);
        autoScrollViewPager.setAdapter(pagerAdapter);
        bannerIndicator.setUpWidthViewPager(autoScrollViewPager);
        autoScrollViewPager.startAutoPlay();
    }


    private void intData() {
        drawableList.add(getResources().getDrawable(R.drawable.banner_one));
        drawableList.add(getResources().getDrawable(R.drawable.banner_two));
        drawableList.add(getResources().getDrawable(R.drawable.banner_three));
    }
}
