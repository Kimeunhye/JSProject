package com.woong.android.tapmuse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by Woong on 2016-04-06.
 */
public class GameActivity extends Activity{
    private boolean isRandom;
    private String stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        stage=intent.getStringExtra("Stage");
        isRandom=intent.getBooleanExtra("Random", false);

        GameView view = new GameView(this, stage, isRandom);

        setContentView(view);
        view.gameStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
