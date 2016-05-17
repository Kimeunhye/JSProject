package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by kk on 2016-04-20.
 */
public class Button {
    private float x=0;
    private float y=0;

    private float scale;

    private Bitmap btn_on;
    private Bitmap btn_off;

    public static final int STATUS_DEFAULT=1;
    public static final int STATUS_PUSHED=2;
    private boolean ispushed=false;

    private int status=STATUS_DEFAULT;

    public Button(Context context, Bitmap btn_off, Bitmap btn_on) {
        scale=context.getResources().getDisplayMetrics().density;
        this.btn_off=btn_off;
        this.btn_on=btn_on;
    }

    public void draw(Canvas canvas){
        if(!ispushed)
            canvas.drawBitmap(btn_off,new Rect(0,0,btn_off.getWidth(),btn_off.getHeight()),new RectF(x*scale-btn_off.getWidth()/2,y*scale-btn_off.getHeight()/2,x*scale+btn_off.getWidth()/2,y*scale+btn_off.getHeight()/2),null);
        else
            canvas.drawBitmap(btn_on,new Rect(0,0,btn_on.getWidth(),btn_on.getHeight()),new RectF(x*scale-btn_on.getWidth()/2,y*scale-btn_on.getHeight()/2,x*scale+btn_on.getWidth()/2,y*scale+btn_on.getHeight()/2),null);
    }

    public void buttonEvent(){
        ispushed=!ispushed;
    }

    public boolean ispushed() {
        return ispushed;
    }

    public float getScale() {
        return scale;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean contains(float v, float v1) {
        float halfW=(btn_off.getWidth()/scale)/2;
        float halfH=(btn_off.getHeight()/scale)/2;
        if(x-halfW<=v&&v<=x+halfW && y-halfH <=v1 && v1<=y+halfH)
            return true;
        else
            return false;
    }
}
