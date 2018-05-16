package com.amyrobotics.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import static com.amyrobotics.demo.RobotController.LightControl.*;

public class Main2Activity extends BaseActivity implements View.OnClickListener {


    private Button btn_next;
    private Button btn_up;
    private Button btn_waring;
    private Button btn_normal;
    private Button btn_talking;
    private Button btn_thinking;
    private Button btn_listening;
    private Button btn_lowBattery;
    private Button btn_singing;
    private LinearLayout activity_main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_waring:
                RobotController.getInstance().controlLight(WARN);

//                controlHead.warning();
                break;
            case R.id.btn_normal:
                RobotController.getInstance().controlLight(NORMAL);
//                controlHead.normal();
                break;
            case R.id.btn_talking:
                RobotController.getInstance().controlLight(TALKING);
//                controlHead.talking();

                break;
            case R.id.btn_thinking:
                RobotController.getInstance().controlLight(THINKING);
//                controlHead.thinking();
                break;
            case R.id.btn_listening:
                RobotController.getInstance().controlLight(LISTENING);
//                controlHead.listening();

                break;
            case R.id.btn_lowBattery:
                RobotController.getInstance().controlLight(LOWBATTERY);
//                controlHead.lowBattery();
                break;
            case R.id.btn_singing:
                RobotController.getInstance().controlLight(SINGING);
//                controlHead.singing();
                break;
            case R.id.btn_next:
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                finish();
                break;
            case R.id.btn_up:
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }


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
        activity_main2 = (LinearLayout) findViewById(R.id.activity_main2);

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
}
