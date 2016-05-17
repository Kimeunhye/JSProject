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
public class Tablet {
    private float x=64;
    private float y=-30;
    private final float WIDTH=100;
    private final float HEIGHT=34;
    private float scale;
    private int location;
    private float pY=335;

    private float speed=2.5f;
    private float offset_Y=0;

    private boolean isTouched=false;
    private int grade=0;
    private int delayCount=5;

    private Bitmap img;
    private static Bitmap gradeTxt; //250*450

    public Tablet(Context context, int location) {
        img= BitmapFactory.decodeResource(context.getResources(), R.drawable.item);
        if(gradeTxt==null)
            gradeTxt=BitmapFactory.decodeResource(context.getResources(), R.drawable.grade);
        scale=context.getResources().getDisplayMetrics().density;
        this.location=location;
        x+=128*(location-1);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(img, new Rect(0, 0, img.getWidth(), img.getHeight()), new RectF((x - WIDTH / 2) * scale, (y - HEIGHT / 2) * scale, (x + WIDTH / 2) * scale, (y + HEIGHT / 2) * scale), null);
        if(isTouched || grade ==1)
            canvas.drawBitmap(gradeTxt,
                    new Rect(0,(int)((90*(grade-1))*scale), gradeTxt.getWidth(), (int)((90*grade)*scale)),
                    new RectF(320*scale-gradeTxt.getWidth()/2,(150-45)*scale,320*scale+gradeTxt.getWidth()/2,(150+45)*scale), null);
    }

    public void update()
    {
        offset_Y=speed*2;
        y+=offset_Y;
        if(isTouched)
            delayCount--;
    }

    public int statusOutOfView(){
        if(delayCount==0)
            return 1;
       else if(!isTouched&&y-pY>50) {
            isTouched = true;
            grade = 1;
            return 2;
        }
        else
            return 0;
    }

    public int chkCorrectTouch(float tx, float ty) {
        float distY=Math.abs(pY-y);
        if(!isTouched&&distY<100&&(int)(tx/128) == location-1) {
            isTouched=true;
            if(distY>60)
                grade=1; //Miss
            else if(45<distY)
                grade= 2; //Bad
            else if(30<distY)
                grade= 3; //Good
            else if(15<distY)
                grade= 4; //Great
            else
                grade=5; //Perpect
        }
        else
            grade= 0;
        return grade;
    }
}
