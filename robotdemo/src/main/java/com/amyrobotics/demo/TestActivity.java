package com.amyrobotics.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TestActivity extends BaseActivity implements View.OnClickListener {

    public static void start(Context context) {
        Intent starter = new Intent(context, TestActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }


    private Button btn_next;
    private Button btn_up;
    private Button btn_waring;
    private Button btn_normal;
    private Button btn_talking;
    private Button btn_thinking;
    private Button btn_listening;
    private Button btn_lowBattery;
    private Button btn_singing;
    private void initView() {
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_up = (Button) findViewById(R.id.btn_up);
        btn_waring = (Button) findViewById(R.id.btn_waring);
        btn_normal = (Button) findViewById(R.id.btn_normal);
        btn_talking = (Button) findViewById(R.id.btn_talking);
        btn_thinking = (Button) findViewById(R.id.btn_thinking);
        btn_listening = (Button) findViewById(R.id.btn_listening);
        btn_lowBattery = (Button) findViewById(R.id.btn_lowBattery);
        btn_singing = (Button) findViewById(R.id.btn_singing);

        btn_next.setOnClickListener(this);
        btn_up.setOnClickListener(this);
        btn_waring.setOnClickListener(this);
        btn_normal.setOnClickListener(this);
        btn_talking.setOnClickListener(this);
        btn_thinking.setOnClickListener(this);
        btn_listening.setOnClickListener(this);
        btn_lowBattery.setOnClickListener(this);
        btn_singing.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_waring:
                Toast.makeText(this, "RobotController.getInstance().getControlHead().controlHeadChannel:" + RobotController.getInstance().getControlHead().controlHeadChannel, Toast.LENGTH_SHORT).show();
//                controlHead.warning();
                break;
            case R.id.btn_normal:
                RobotController.getInstance().controlLight(RobotController.LightControl.NORMAL);
//                controlHead.normal();
                break;
            case R.id.btn_talking:
//                controlHead.talking();

                break;
            case R.id.btn_thinking:
                controlHead.thinking();
                break;
            case R.id.btn_listening:
                controlHead.listening();

                break;
            case R.id.btn_lowBattery:
                controlHead.lowBattery();
                break;
            case R.id.btn_singing:
                controlHead.singing();
                break;

            default:
                break;
        }
    }

}
