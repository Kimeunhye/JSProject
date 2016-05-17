package com.woong.android.tapmuse;

/**
 * Created by QQ on 2016-04-11.
 */
public class Rythme {
    private long time;
    private int location;

    public Rythme(long time, int location) {
        this.time = time;
        this.location = location;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
