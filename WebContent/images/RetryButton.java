package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * Created by kk on 2016-04-20.
 */
public class RetryButton extends Button {

    private float scale;

    public RetryButton(Context context) {
        super(context, BitmapFactory.decodeResource(context.getResources(),R.drawable.retrybtn_off), BitmapFactory.decodeResource(context.getResources(), R.drawable.retrybtn_on));
        scale=super.getScale();

        super.setX(200);
        super.setY(300);
    }
}
