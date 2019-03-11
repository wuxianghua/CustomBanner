package com.imoran.auto.custombanner.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BannerItemView extends View {
    private static final String TAG = "BannerItemView";
    private Paint mPaint;
    private float rectWidth;
    private RectF rectF;
    public static final int CENTER = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    private int loaction = CENTER;

    public BannerItemView(Context context) {
        this(context,null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectF = new RectF();
        mPaint.setColor(Color.RED);
    }

    public BannerItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectF = new RectF();
        mPaint.setColor(Color.RED);
    }

    public BannerItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectF = new RectF();
        mPaint.setColor(Color.RED);
    }

    public BannerItemView(Context context,int loaction) {
        this(context);
        this.loaction = loaction;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (loaction) {
            case CENTER:
                rectF.left = getWidth() / 2 - getHeight() /2 - rectWidth;
                rectF.right = getHeight() / 2 + getWidth() / 2 + rectWidth;
                rectF.top = 0;
                rectF.bottom = getHeight();
                break;
            case LEFT:
                rectF.left = getWidth() - getHeight() - rectWidth;
                rectF.right = getWidth();
                rectF.top = 0;
                rectF.bottom = getHeight();
                break;
            case RIGHT:
                rectF.left = 0;
                rectF.right = getHeight() - rectWidth;
                rectF.top = 0;
                rectF.bottom = getHeight();
                break;
        }
        canvas.drawRoundRect(rectF,getHeight()/2,getHeight()/2,mPaint);
    }

    public float getRectWidth() {
        return rectWidth;
    }

    public void setRectWidth(float rectWidth) {
        this.rectWidth = rectWidth;
        invalidate();
    }

    public int getLoaction() {
        return loaction;
    }

    public void setLoaction(int loaction) {
        this.loaction = loaction;
    }
}
