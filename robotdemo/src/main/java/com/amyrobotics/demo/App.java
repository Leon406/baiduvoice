package com.amyrobotics.demo;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RobotController.getInstance().init(this);
    }
}
