package com.woong.android.tapmuse;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by kk on 2016-04-20.
 */
public class SelectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SelectView view=new SelectView(this);
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
