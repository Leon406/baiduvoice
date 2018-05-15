package com.amyrobotics.demo;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amyrobotics.navgation.AmyCreateMap;
import com.amyrobotics.navgation.AmyListener;
import com.amyrobotics.navgation.AmyNavigation;


public class Main6Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    public void isMapExisted(View view) {
        AmyCreateMap.mapState(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {



            }

            @Override
            public void onSendCmdFailed(String cmd) {
                Toast.makeText(Main6Activity.this, "onSendCmdFailed :"
                        +cmd, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("isMapExisted", result);
                Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void startMapModle(View view) {
        AmyCreateMap.startCreateMapModel(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("startMapModle", result);
            }
        });
    }

    public void pose(View view) {
        AmyCreateMap.locateLable(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("pose", result);
            }
        });
    }

    public void saveMap(View view) {
        AmyCreateMap.saveMap(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("saveMap", result);
            }
        });
    }

    public void stopMapModel(View view) {
        AmyCreateMap.stopMapModel(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("stopMapModel", "result:" + result);
            }
        });
    }

    public void getNavState(View view) {
        AmyNavigation.getNavigationState(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("getNavState", result);
            }
        });
    }

    /**
     * 这个方法耗时需要10-20s
     * @param view
     */
    public void startNav(View view) {
        AmyNavigation.startNavigationModel(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("startNav", result);
            }
        });
    }

    public void gotoWhere(View view) {
        AmyNavigation.sendGoal(1, new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("gotoWhere", result);
            }
        });
    }

    public void cancle(View view) {
        AmyNavigation.cancelGoal(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("cancle", result);
            }
        });
    }

    public void stopNav(View view) {
        AmyNavigation.shutDownNavigation(new AmyListener() {
            @Override
            public void onSendCmdSuccess(String cmd) {

            }

            @Override
            public void onSendCmdFailed(String cmd) {

            }

            @Override
            public void onResult(String cmd, String result) {
                Log.d("stopNav", result);
            }
        });
    }

    public void up(View view) {
        startActivity(new Intent(Main6Activity.this, Main3Activity.class));
        finish();
    }
}
