package com.woong.android.tapmuse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by Woong on 2016-04-06.
 */
public class IntroActivity extends Activity {
    private long startTime= System.currentTimeMillis();
    private long currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntroView view = new IntroView(this);
        setContentView(view);
        view.introStart();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentTime= System.currentTimeMillis();
                if(currentTime-startTime>2000) {
                    Intent intent = new Intent(this, SelectActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
        }
        return true;
    }

}
