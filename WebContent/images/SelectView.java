package com.woong.android.tapmuse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kk on 2016-04-20.
 */
public class SelectView extends View {
    private Button randomBtn;
    private Button startBtn;
    private Button exitBtn;
    private float scale;

    private boolean isSelected=false;
    private boolean isRandom=false;
    private String stage;

    private static MediaPlayer mp;
    private static Bitmap bg;

    public SelectView(Context context) {
        super(context);
        randomBtn=new RandomButton(context);
        startBtn = new StartButton(context);
        exitBtn = new ExitButton(context);

        scale=context.getResources().getDisplayMetrics().density;
        if(mp==null)
            mp=MediaPlayer.create(context, R.raw.click);
        if(bg==null)
            bg= BitmapFactory.decodeResource(context.getResources(),R.drawable.selectbg);
        stage="bach";

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bg, new Rect(0,0,bg.getWidth(),bg.getHeight()), new RectF(0,0,this.getWidth(),this.getHeight()),null);
        randomBtn.draw(canvas);
        startBtn.draw(canvas);
        exitBtn.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(randomBtn.contains(event.getX()/scale,event.getY()/scale)) {
                    mp.start();
                    randomBtn.buttonEvent();
                    invalidate();
                }else if(startBtn.contains(event.getX()/scale,event.getY()/scale)){
                    mp.start();
                    startBtn.buttonEvent();
                    invalidate();
                }else if(exitBtn.contains(event.getX()/scale,event.getY()/scale)){
                    mp.start();
                    exitBtn.buttonEvent();
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(startBtn.ispushed()&&!startBtn.contains(event.getX()/scale,event.getY()/scale))
                    startBtn.buttonEvent();
                if(exitBtn.ispushed()&&!exitBtn.contains(event.getX()/scale,event.getY()/scale))
                    exitBtn.buttonEvent();
                break;
            case MotionEvent.ACTION_UP:
                if(startBtn.contains(event.getX()/scale,event.getY()/scale)){
                    if(startBtn.ispushed()) {
                        startBtn.buttonEvent();
                        invalidate();
                        Intent intent = new Intent(getContext(), GameActivity.class);
                        intent.putExtra("Random", isRandom);
                        intent.putExtra("Stage", stage);

                        getContext().startActivity(intent);
                    }
                }else if(exitBtn.contains(event.getX()/scale,event.getY()/scale)){
                    if(exitBtn.ispushed()) {
                        exitBtn.buttonEvent();
                        invalidate();
                        System.exit(0);
                    }
                }
                break;
        }
        return true;
    }
}
