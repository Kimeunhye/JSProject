package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * Created by kk on 2016-04-20.
 */
public class StartButton extends Button {

    private float scale;

    public StartButton(Context context) {
        super(context, BitmapFactory.decodeResource(context.getResources(),R.drawable.startbtn_off), BitmapFactory.decodeResource(context.getResources(), R.drawable.startbtn_on));
        scale=super.getScale();

        super.setX(200);
        super.setY(300);
    }
}
