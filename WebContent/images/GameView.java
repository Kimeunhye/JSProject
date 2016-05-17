package com.woong.android.tapmuse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Woong on 2016-04-06.
 */
public class GameView extends View implements Runnable{
    public final float SCALE;
    private int score=0;
    private int combo = 0;
    private int maxCombo=0;
    private int energy=50;
    private int perfectCount=0;
    private int greatCount=0;
    private int goodCount=0;
    private int badCount=0;
    private int missCount=0;


    private Background background;
    private List<Tablet> tabletList;
    private Highlight highlight;
    private Music music;

    private ReadWriteLock readWriteLock;

    private long startTime;
    private long currentTime;
    private long preTime;

    private long lastTiming;
    private int endDelayCount=150;

    private boolean isRunning;

    int pointerIndex;
    int pointerCount;
    int pointerId;

    private float pre_X=0;

    private Thread gameThread;

    private MediaPlayer mp;

    private boolean isRandom;
    private String stage;



    public GameView(Context context, String stage, boolean isRandom) {
        super(context);
        SCALE = getResources().getDisplayMetrics().density;
        background=new Background(this.getContext());
        tabletList=new LinkedList<Tablet>();
        highlight=new Highlight(this.getContext());
        this.stage=stage;
        this.isRandom=isRandom;
        try {
            music = new Music(this.getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        readWriteLock= new ReentrantReadWriteLock();
        mp= MediaPlayer.create(context, R.raw.bach);
        lastTiming=music.getLastTiming();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        background.draw(canvas);
        readWriteLock.readLock().lock();
        for(int i=0;i<tabletList.size();i++)
            tabletList.get(i).draw(canvas);
        readWriteLock.readLock().unlock();
        highlight.draw(canvas);


        paint.setColor(0xFFC89F23);
        paint.setTextSize(30 * SCALE);
        canvas.drawText("" + score, 300 * SCALE, 30 * SCALE, paint);
        canvas.drawText(""+combo, 145*SCALE, 30*SCALE, paint);
        paint.setColor(Color.RED);
        canvas.drawRect(new RectF(480 * SCALE, 10 * SCALE, (480 + energy) * SCALE, 30 * SCALE), paint);
    }

    public void gameStart(){
        if(gameThread == null){
            gameThread = new Thread(this);
            gameThread.start();
        }
        isRunning = true;
    }
    public void gameStop(){
        isRunning=false;
        mp.stop();
        Intent intent = new Intent(getContext(), ResultActivity.class);
        intent.putExtra("Perfect", perfectCount);
        intent.putExtra("Great", greatCount);
        intent.putExtra("Good", goodCount);
        intent.putExtra("Bad", badCount);
        intent.putExtra("Miss", missCount);
        intent.putExtra("Score", score);
        intent.putExtra("Combo", maxCombo);
        getContext().startActivity(intent);
    }

    @Override
    public void run() {
        startTime=System.currentTimeMillis();
        preTime=startTime;
        int count=0;

        while(isRunning) {
            if (preTime - startTime > 1500)
                mp.start();
            currentTime = System.currentTimeMillis();

            if (count < music.size() && music.getTiming(count) <= currentTime - startTime) {
                readWriteLock.writeLock().lock();
                if ((music.getLocation(count) & 1) == 1)
                    tabletList.add(music.item(count, 1));
                if ((music.getLocation(count) & 2) == 2)
                    tabletList.add(music.item(count, 2));
                if ((music.getLocation(count) & 4) == 4)
                    tabletList.add(music.item(count, 3));
                if ((music.getLocation(count) & 8) == 8)
                    tabletList.add(music.item(count, 4));
                if ((music.getLocation(count) & 16) == 16)
                    tabletList.add(music.item(count, 5));
                readWriteLock.writeLock().unlock();
                count++;
            }

            readWriteLock.writeLock().lock();
            for (int i = 0; i < tabletList.size(); i++) {
                int status = tabletList.get(i).statusOutOfView();
                if (status == 1) {
                    tabletList.remove(i);
                } else if (status == 2) {
                    if(combo>maxCombo)
                        maxCombo=combo;
                    combo = 0;
                    missCount++;
                    energy-=6;
                }
            }
            readWriteLock.writeLock().unlock();

            readWriteLock.readLock().lock();
            for (int i = 0; i < tabletList.size(); i++)
                tabletList.get(i).update();
            readWriteLock.readLock().unlock();

            if(currentTime-startTime>lastTiming && tabletList.isEmpty())
                endDelayCount--;
            if(energy<=0||endDelayCount==0)
                gameStop();



//            String msg = String.format("(S, C) : %d, %d", startTime, currentTime);
//            String msg2 = String.format("(P, D) : %d, %d", currentTime-startTime, deltaTime);
//            Log.v("시간출력", msg);
//            Log.v("시간2출력", msg2);
            postInvalidate();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            preTime = currentTime;

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        pointerIndex = event.getActionIndex();
        pointerId = event.getPointerId(pointerIndex);
        pointerCount=event.getPointerCount();

        switch(event.getActionMasked()){

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                pre_X=event.getX(pointerIndex);

                readWriteLock.readLock().lock();
                OUTER:
                for(int i=0;i<tabletList.size();i++){
                    int chker=tabletList.get(i).chkCorrectTouch(event.getX(pointerId)/SCALE, event.getY(pointerId)/SCALE);
                   switch(chker){
                       case 5:
                           combo++;
                           score+=(200+20*(combo/20));
                           perfectCount++;
                           energy+=3;
                           if(energy>100)
                               energy=100;
                           break OUTER;
                       case 4:
                           combo++;
                           score+=(150+15*(combo/20));
                           energy+=2;
                           greatCount++;
                           if(energy>100)
                               energy=100;
                           break OUTER;
                       case 3:
                           combo++;
                           score+=(100+10*(combo/20));
                           energy+=1;
                           goodCount++;
                           if(energy>100)
                               energy=100;
                           break OUTER;
                       case 2:
                           if(combo>maxCombo)
                               maxCombo=combo;
                           combo=0;
                           energy-=3;
                           badCount++;
                           break OUTER;
                       case 1:
                           if(combo>maxCombo)
                               maxCombo=combo;
                           combo=0;
                           missCount++;
                           energy-=6;
                           break OUTER;
                   }
                }
                readWriteLock.readLock().unlock();
                break;

            case MotionEvent.ACTION_MOVE:
                highlight.touchDown(event.getX(pointerId) / SCALE, event.getY(pointerId) / SCALE, 1 << (int) ((event.getX(pointerId) / SCALE) / 128));
                if((int)((event.getX(pointerId) / SCALE) / 128) !=(int)((pre_X / SCALE) / 128))
                    highlight.touchUp(event.getX(pointerId) / SCALE, event.getY(pointerId) / SCALE, 1 << (int) ((pre_X / SCALE) / 128));
                pre_X=event.getX(pointerId);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                highlight.touchUp(0, 0, 1 <<(int)((event.getX(pointerId)/SCALE)/128));
                break;
        }

        return true;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(getContext(), SelectActivity.class);
            getContext().startActivity(intent);
            return true;
        }else
            return super.onKeyDown(keyCode, event);
    }
}
