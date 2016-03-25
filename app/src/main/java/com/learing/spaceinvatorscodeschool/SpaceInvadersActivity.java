package com.learing.spaceinvatorscodeschool;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class SpaceInvadersActivity extends Activity {

    SpaceInvadersView spaceInvadersView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        spaceInvadersView = new SpaceInvadersView(this, point.x, point.y);

        //Sets the SpaceHolder View to the main View
        setContentView(spaceInvadersView);
    }

    @Override
    protected void onPause(){
        super.onPause();
        spaceInvadersView.pause();
    }

    @Override
    protected  void onResume(){
        super.onResume();
        spaceInvadersView.resume();
    }
}
