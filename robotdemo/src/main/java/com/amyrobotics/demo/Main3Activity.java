package com.amyrobotics.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static com.amyrobotics.demo.RobotController.Action.*;

public class Main3Activity extends BaseActivity implements View.OnClickListener {

    private Button btn_next;
    private Button btn_up;
    private Button btn_move_2s;
    private Button btn_arc_move;
    private Button btn_dance;
    private Button btn_turnround;
    private Button btn_follow;
    private Button btn_stop;
    private LinearLayout activity_main3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }


    @Override
    public void onClick(View view) {

        runOnUiThread(() -> {
        });
        switch (view.getId()) {
            case R.id.btn_next:
                startActivity(new Intent(Main3Activity.this, Main6Activity.class));
                finish();
                break;
            case R.id.btn_up:
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
                finish();
                break;
            case R.id.btn_move_2s:
//                controlRobotAction.moveStraight2s();

                RobotController.getInstance().controlAction(STRAIT2);
                break;
            case R.id.btn_arc_move:
                RobotController.getInstance().controlAction(ARC2);
//                controlRobotAction.moveArc2s();
                break;
            case R.id.btn_dance:
                RobotController.getInstance().controlAction(DANCE);
//                controlRobotAction.dance();
                break;
            case R.id.btn_turnround:
                RobotController.getInstance().controlAction(AROUND360);
//                controlRobotAction.turnRound(360);
                break;
            case R.id.btn_follow:
                RobotController.getInstance().controlAction(FOLLOW);
//                controlRobotAction.follow();
                break;
            case R.id.btn_stop:
                RobotController.getInstance().controlAction(STOP_FOLLOW);
//                controlRobotAction.stopFollow();//this method can stop dance and follow and turn;
                break;
        }
    }

    private void initView() {
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_up = (Button) findViewById(R.id.btn_up);
        btn_move_2s = (Button) findViewById(R.id.btn_move_2s);
        btn_arc_move = (Button) findViewById(R.id.btn_arc_move);
        btn_dance = (Button) findViewById(R.id.btn_dance);
        btn_turnround = (Button) findViewById(R.id.btn_turnround);
        btn_follow = (Button) findViewById(R.id.btn_follow);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        activity_main3 = (LinearLayout) findViewById(R.id.activity_main3);

        btn_next.setOnClickListener(this);
        btn_up.setOnClickListener(this);
        btn_move_2s.setOnClickListener(this);
        btn_arc_move.setOnClickListener(this);
        btn_dance.setOnClickListener(this);
        btn_turnround.setOnClickListener(this);
        btn_follow.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }
}
