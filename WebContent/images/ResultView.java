package com.woong.android.tapmuse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kk on 2016-04-20.
 */
public class ResultView extends View {
    private float scale;
    private int perfectCount;
    private int greatCount;
    private int goodCount;
    private int badCount;
    private int missCount;
    private int score;
    private int combo;

    private static Bitmap bg;
    private static MediaPlayer mp;

    private Button retryBtn;
    private Button menuBtn;

    public ResultView(Context context,int perfectCount, int greatCount, int goodCount, int badCount,int missCount, int score, int combo) {
        super(context);

        this.perfectCount = perfectCount;
        this.greatCount = greatCount;
        this.goodCount = goodCount;
        this.badCount = badCount;
        this.missCount = missCount;
        this.score=score;
        this.combo=combo;

        scale=context.getResources().getDisplayMetrics().density;
        retryBtn= new RetryButton(context);
        menuBtn=new MenuButton(context);

        if(mp==null)
            mp=MediaPlayer.create(context, R.raw.click);
        if(bg==null)
            bg= BitmapFactory.decodeResource(context.getResources(),R.drawable.resultbg);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(30 * scale);

        canvas.drawBitmap(bg,new Rect(0,0,bg.getWidth(),bg.getHeight()), new Rect(0,0,this.getWidth(),this.getHeight()),null);

        retryBtn.draw(canvas);
        menuBtn.draw(canvas);

        canvas.drawText("Perfect: "+perfectCount, 300*scale,50*scale,paint);
        canvas.drawText("Great: "+greatCount, 300*scale,80*scale,paint);
        canvas.drawText("Good: "+goodCount, 300*scale,110*scale,paint);
        canvas.drawText("Bad: "+badCount, 300*scale,140*scale,paint);
        canvas.drawText("Miss: "+missCount, 300*scale,170*scale,paint);
        canvas.drawText("Combo: "+combo, 300*scale,200*scale,paint);
        canvas.drawText("Score: "+score, 300*scale,230*scale,paint);


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(retryBtn.contains(event.getX()/scale,event.getY()/scale)) {
                    mp.start();
                    retryBtn.buttonEvent();
                    invalidate();
                }else if(menuBtn.contains(event.getX()/scale,event.getY()/scale)){
                    mp.start();
                    menuBtn.buttonEvent();
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(retryBtn.ispushed()&&!retryBtn.contains(event.getX()/scale,event.getY()/scale))
                    retryBtn.buttonEvent();
                if(menuBtn.ispushed()&&!menuBtn.contains(event.getX()/scale,event.getY()/scale))
                    menuBtn.buttonEvent();
                break;
            case MotionEvent.ACTION_UP:
                if(retryBtn.contains(event.getX()/scale,event.getY()/scale)){
                    if(retryBtn.ispushed()) {
                        retryBtn.buttonEvent();
                        invalidate();
                        Intent intent = new Intent(getContext(), GameActivity.class);
                        getContext().startActivity(intent);
                    }
                }else if(menuBtn.contains(event.getX()/scale,event.getY()/scale)){
                    if(menuBtn.ispushed()) {
                        menuBtn.buttonEvent();
                        invalidate();
                        Intent intent = new Intent(getContext(), SelectActivity.class);
                        getContext().startActivity(intent);
                    }
                }
                break;
        }
        return true;
    }
}
