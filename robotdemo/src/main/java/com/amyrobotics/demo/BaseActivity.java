package com.amyrobotics.demo;

import android.app.Activity;
import android.os.Bundle;

import com.amyrobotics.controlheadandlight.ControlHead;
import com.amyrobotics.controlrobotaction.ControlRobotAction;


/**
 * Created by VVW on 2016/11/23.
 */

public class BaseActivity extends Activity {


    ControlHead controlHead;
    ControlRobotAction controlRobotAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controlHead = new ControlHead(this);
        controlHead.bindService();
        controlRobotAction = new ControlRobotAction();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controlHead.unbindService();
        controlHead = null;
    }

    protected String getFormatStr(String cmd, String result) {

        return String.format("cmd:  %s --- result:  %s", cmd, result);

    }


}
