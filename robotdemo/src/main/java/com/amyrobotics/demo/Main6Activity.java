package com.amyrobotics.demo;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import leon.me.amylib.RobotController;
import leon.me.amylib.base.Map;
import leon.me.amylib.base.Navigation;
import leon.me.amylib.base.SimpleAmyListener;

import static leon.me.amylib.base.Map.*;


public class Main6Activity extends BaseActivity {

    public static final String TAG ="MapNavi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }



    public void isMapExisted(View view) {

        RobotController.getInstance().controlMap(Map.EXIST,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }


    public void startMapModle(View view) {

        RobotController.getInstance().controlMap(START,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }

    public void pose(View view) {

        RobotController.getInstance().controlMap(LABEL,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void saveMap(View view) {

        RobotController.getInstance().controlMap(SAV,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void stopMapModel(View view) {

        RobotController.getInstance().controlMap(STOP,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }

    public void getNavState(View view) {
                RobotController.getInstance().controlNavi(Navigation.STATE,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }


    public void startNav(View view) {
        RobotController.getInstance().controlNavi(Navigation.START,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());

                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }

    public void gotoWhere(View view) {
//        RobotController.getInstance().controlNavi(RobotController.Navigation.GO,new SimpleAmyListener(){
//            @Override
//            public void onResult(String cmd, String result) {
//                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
//                Log.d(TAG, getFormatStr(cmd,result));
//            }
//        });

        RobotController.getInstance().naviTo(0,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void cancle(View view) {
        RobotController.getInstance().controlNavi(Navigation.CANCEL,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void stopNav(View view) {
        RobotController.getInstance().controlNavi(Navigation.STOP,new SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d("stopNav", result);
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void up(View view) {
        startActivity(new Intent(Main6Activity.this, Main3Activity.class));
        finish();
    }
}
