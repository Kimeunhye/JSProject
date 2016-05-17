package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * Created by kk on 2016-04-20.
 */
public class RandomButton extends Button {

    private float scale;

    public RandomButton(Context context) {
        super(context, BitmapFactory.decodeResource(context.getResources(),R.drawable.randombtn_off), BitmapFactory.decodeResource(context.getResources(), R.drawable.randombtn_on));
        scale=super.getScale();

        super.setX(120);
        super.setY(160);
    }
}
