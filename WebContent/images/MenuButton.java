package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * Created by kk on 2016-04-20.
 */
public class MenuButton extends Button {

    private float scale;

    public MenuButton(Context context) {
        super(context, BitmapFactory.decodeResource(context.getResources(),R.drawable.menubtn_off), BitmapFactory.decodeResource(context.getResources(), R.drawable.menubtn_on));
        scale=super.getScale();

        super.setX(440);
        super.setY(300);
    }
}
