package com.amyrobotics.demo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends BaseActivity implements View.OnClickListener {


    private Button bt_next;
    private Button btn_head_stop;
    private Button btn_head_left;
    private Button btn_head_right;
    private Button btn_head_down;
    private Button btn_head_up;
    private Button btn_body_stop;
    private Button btn_body_left;
    private Button btn_body_right;
    private Button btn_body_advance;
    private Button btn_body_back;
    private LinearLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_head_stop:

                controlHead.stopTurnHead();
                break;
            case R.id.btn_head_left:
                RobotController.getInstance().getControlHead().stopTurnHead();
//                controlHead.turnHeadLeft();
                break;
            case R.id.btn_head_right:
                controlHead.turnHeadRight();
                break;
            case R.id.btn_head_down:
                controlHead.turnHeadDown();
                break;
            case R.id.btn_head_up:
                controlHead.turnHeadUp();
                break;
            case R.id.btn_body_stop:
                controlRobotAction.stopWalking();
                break;
            case R.id.btn_body_left:
                controlRobotAction.turnLeft();
                break;
            case R.id.btn_body_right:
                controlRobotAction.turnRight();
                break;

            case R.id.btn_body_advance:
                controlRobotAction.goForward();
                break;
            case R.id.btn_body_back:
                controlRobotAction.moveBack();
                break;
            case R.id.bt_next:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                finish();
                break;
            default:
                break;
        }
    }


    private void initView() {
        bt_next = (Button) findViewById(R.id.bt_next);
        btn_head_stop = (Button) findViewById(R.id.btn_head_stop);
        btn_head_left = (Button) findViewById(R.id.btn_head_left);
        btn_head_right = (Button) findViewById(R.id.btn_head_right);
        btn_head_down = (Button) findViewById(R.id.btn_head_down);
        btn_head_up = (Button) findViewById(R.id.btn_head_up);
        btn_body_stop = (Button) findViewById(R.id.btn_body_stop);
        btn_body_left = (Button) findViewById(R.id.btn_body_left);
        btn_body_right = (Button) findViewById(R.id.btn_body_right);
        btn_body_advance = (Button) findViewById(R.id.btn_body_advance);
        btn_body_back = (Button) findViewById(R.id.btn_body_back);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);

        bt_next.setOnClickListener(this);
        btn_head_stop.setOnClickListener(this);
        btn_head_left.setOnClickListener(this);
        btn_head_right.setOnClickListener(this);
        btn_head_down.setOnClickListener(this);
        btn_head_up.setOnClickListener(this);
        btn_body_stop.setOnClickListener(this);
        btn_body_left.setOnClickListener(this);
        btn_body_right.setOnClickListener(this);
        btn_body_advance.setOnClickListener(this);
        btn_body_back.setOnClickListener(this);
    }
}
