package com.woong.android.tapmuse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kk on 2016-04-18.
 */
public class IntroView extends View implements Runnable{
    private Bitmap title;
    private int count=-1;
    private float scale;

    private Thread introThread;
    private MediaPlayer mp;

    public IntroView(Context context) {
        super(context);
        title= BitmapFactory.decodeResource(getResources(), R.drawable.title);
        scale=getResources().getDisplayMetrics().density;
        mp= MediaPlayer.create(context, R.raw.ahchoo);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(title, new Rect(0,(int)(139*count*scale),title.getWidth(),(int)(139*(count+1)*scale)), new RectF(80*scale,110*scale,560*scale,250*scale),null);

    }

    @Override
    public void run() {
        mp.start();
        while(count<6){

            postInvalidate();
            count++;
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void introStart(){
        if(introThread == null){
            introThread = new Thread(this);
            introThread.start();
        }
    }
}
