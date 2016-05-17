package com.woong.android.tapmuse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by kk on 2016-04-20.
 */
public class ResultActivity extends Activity {
    private int perfectCount;
    private int greatCount;
    private int goodCount;
    private int badCount;
    private int missCount;
    private int score;
    private int combo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent= getIntent();
        perfectCount=intent.getIntExtra("Perfect",1);
        greatCount=intent.getIntExtra("Great",1);
        goodCount=intent.getIntExtra("Good",1);
        badCount=intent.getIntExtra("bad",1);
        missCount=intent.getIntExtra("Miss",1);
        score=intent.getIntExtra("Score", 1);
        combo=intent.getIntExtra("Combo", 1);

        ResultView view = new ResultView(this, perfectCount, greatCount, goodCount, badCount, missCount, score, combo);

        setContentView(view);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
            return false;
        return super.onKeyDown(keyCode, event);
    }
}
