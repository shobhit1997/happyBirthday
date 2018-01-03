package com.example.dell.happybirthday;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by DELL on 8/4/2017.
 */

public class SingleShotImageView extends android.support.v7.widget.AppCompatImageView {

    public SingleShotImageView(Context context) {
        super(context);
    }

    public SingleShotImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SingleShotImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDetachedFromWindow () {
        super.onDetachedFromWindow();
        setImageDrawable(null);
        setBackgroundDrawable(null);
        setImageBitmap(null);
        System.gc();
    }



}