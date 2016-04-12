package com.learing.spaceinvatorscodeschool;

import android.graphics.RectF;

/**
 * This is a class for the Bullet Game Object
 * Created by scottbaron on 3/22/16.
 */
public class Bullet {
    private float x;
    private float y;

    private RectF rectF;

    public final int UP = 0;
    public final int DOWN = -1;

    int heading = -1;
    float speed = 350;

    private int  width = 1;
    private int height;

    private boolean isActive;

    public Bullet(int screenY){
        height = screenY/20;
        isActive = false;
        rectF = new RectF();
    }

    public RectF getRectF(){
        return rectF;
    }

    public boolean getStatus(){
        return isActive;
    }

    public void setInactive(){
        isActive = false;
    }

    public float getImpactPointY(){
        if(heading == DOWN)
            return y + height;
        else
            return y;
    }

    public boolean shoot(float startX, float startY, int direction){
        if(!isActive){
            x = startX;
            y = startY;
            heading = direction;
            isActive = true;
            return true;
        }
        return false;
    }

    public void update(long fps){
        if(heading == UP){
            y = y - speed / fps;
        }
        else{
            y = y + speed / fps;
        }

        //Updates the Rect
        rectF.left = x;
        rectF.right = x + height;
        rectF.top = y;
        rectF.bottom = y + height;
    }


}
