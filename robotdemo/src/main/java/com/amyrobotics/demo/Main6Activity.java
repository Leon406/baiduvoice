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

    public static final String TAG ="MapNavi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }



    public void isMapExisted(View view) {

        RobotController.getInstance().controlMap(RobotController.Map.EXIST,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }


    public void startMapModle(View view) {

        RobotController.getInstance().controlMap(RobotController.Map.START,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }

    public void pose(View view) {

        RobotController.getInstance().controlMap(RobotController.Map.LABEL,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void saveMap(View view) {

        RobotController.getInstance().controlMap(RobotController.Map.SAV,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void stopMapModel(View view) {

        RobotController.getInstance().controlMap(RobotController.Map.STOP,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }

    public void getNavState(View view) {
                RobotController.getInstance().controlNavi(RobotController.Navigation.STATE,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }


    public void startNav(View view) {
        RobotController.getInstance().controlNavi(RobotController.Navigation.START,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());

                Log.d(TAG, getFormatStr(cmd,result));
            }
        });
    }

    public void gotoWhere(View view) {
        RobotController.getInstance().controlNavi(RobotController.Navigation.GO,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void cancle(View view) {
        RobotController.getInstance().controlNavi(RobotController.Navigation.CANCEL,new RobotController.SimpleAmyListener(){
            @Override
            public void onResult(String cmd, String result) {
                runOnUiThread(() -> Toast.makeText(Main6Activity.this, result, Toast.LENGTH_SHORT).show());
                Log.d(TAG, getFormatStr(cmd,result));
            }
        });

    }

    public void stopNav(View view) {
        RobotController.getInstance().controlNavi(RobotController.Navigation.STOP,new RobotController.SimpleAmyListener(){
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
