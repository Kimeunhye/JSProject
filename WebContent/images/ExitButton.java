package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * Created by kk on 2016-04-20.
 */
public class ExitButton extends Button {

    private float scale;

    public ExitButton(Context context) {
        super(context, BitmapFactory.decodeResource(context.getResources(),R.drawable.exitbtn_off), BitmapFactory.decodeResource(context.getResources(), R.drawable.exitbtn_on));
        scale=super.getScale();

        super.setX(440);
        super.setY(300);
    }
}
