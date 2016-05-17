package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Woong on 2016-04-07.
 */
public class Background {
    private Bitmap img;
    private float scale;

    public Background(Context context) {
        img= BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
        scale=context.getResources().getDisplayMetrics().density;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(img, new Rect(0,0,img.getWidth(), img.getHeight()),new Rect(0,0, canvas.getWidth(), canvas.getHeight()), null);
//        canvas.drawBitmap(highlight,new Rect(0,0,highlight.getWidth(), highlight.getHeight()), new RectF((320-63)*scale,0,(320+63)*scale,highlight.getHeight()), null);
    }
}
