package com.amyrobotics.demo;

import android.app.Application;

import leon.me.amylib.RobotController;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RobotController.getInstance().init(this);
    }
}
