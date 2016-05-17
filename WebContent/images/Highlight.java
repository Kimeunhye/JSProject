package com.woong.android.tapmuse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by QQ on 2016-04-11.
 */
public class Highlight {
    private static Bitmap bar; //126*h
    private static Bitmap circle;
    private float scale;
    private float x=0;
    private float y=335;
    private int location=0;

    public Highlight(Context context) {
        if(bar==null)
            bar= BitmapFactory.decodeResource(context.getResources(), R.drawable.highlight);
        if(circle==null)
            circle= BitmapFactory.decodeResource(context.getResources(), R.drawable.circle);
        scale=context.getResources().getDisplayMetrics().density;

    }

    public void draw(Canvas canvas){
//        canvas.drawBitmap(bar,new Rect(0,0,bar.getWidth(), bar.getHeight()), new RectF((128*location+1)*scale,0,(128*location+1+126)*scale,bar.getHeight()), null);
        if((location&1)==1) {
            canvas.drawBitmap(bar,new Rect(0,0,bar.getWidth(), bar.getHeight()), new RectF((128*0+1)*scale,0,(128*0+1+126)*scale,bar.getHeight()), null);
        }
        if((location&2)==2) {
            canvas.drawBitmap(bar,new Rect(0,0,bar.getWidth(), bar.getHeight()), new RectF((128*1+1)*scale,0,(128*1+1+126)*scale,bar.getHeight()), null);
        }
        if((location&4)==4) {
            canvas.drawBitmap(bar,new Rect(0,0,bar.getWidth(), bar.getHeight()), new RectF((128*2+1)*scale,0,(128*2+1+126)*scale,bar.getHeight()), null);
        }
        if((location&8)==8) {
            canvas.drawBitmap(bar,new Rect(0,0,bar.getWidth(), bar.getHeight()), new RectF((128*3+1)*scale,0,(128*3+1+126)*scale,bar.getHeight()), null);
        }
        if((location&16)==16) {
            canvas.drawBitmap(bar,new Rect(0,0,bar.getWidth(), bar.getHeight()), new RectF((128*4+1)*scale,0,(128*4+1+126)*scale,bar.getHeight()), null);
        }
        if(x!=0 && y!=0)
            canvas.drawBitmap(circle,new Rect(0,0,circle.getWidth(), circle.getHeight()), new RectF((x-40)*scale,(y-40)*scale,(x+40)*scale,(y+40)*scale), null);
    }

    public void touchDown(float x, float y, int location){
        this.x=x;
        this.y=y;
        this.location=this.location|location;
    }

    public void touchUp(float x, float y, int location){
        this.x=x;
        this.y=y;
        this.location=this.location^location;
    }

}
