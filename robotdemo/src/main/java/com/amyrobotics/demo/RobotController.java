package com.amyrobotics.demo;

import android.content.Context;
import android.util.Log;

import com.amyrobotics.controlheadandlight.ControlHead;
import com.amyrobotics.controlrobotaction.ControlRobotAction;
import com.amyrobotics.navgation.AmyCreateMap;
import com.amyrobotics.navgation.AmyListener;
import com.amyrobotics.navgation.AmyNavigation;

public class RobotController {

    private static RobotController robotController;
    private ControlHead controlHead;
    private ControlRobotAction controlRobotAction;
    private static Context ctx;

    public void init(Context app) {
        ctx = app;
        controlHead = new ControlHead(ctx);
        controlHead.bindService();
        controlRobotAction = new ControlRobotAction();
    }

    private RobotController() {
    }

    public static RobotController getInstance() {
        if (robotController == null) {
            synchronized (RobotController.class) {
                if (robotController == null) {
                    robotController = new RobotController();
                }
            }
        }

        return robotController;
    }

    public void unBind() {
        if (controlHead != null) {
            controlHead.unbindService();
            controlHead = null;
        }
    }

    public ControlHead getControlHead() {

        checkNotNull();
        return controlHead;
    }

    public ControlRobotAction getControlRobotAction() {
        return controlRobotAction;
    }

    private void checkNotNull() {
        if (ctx == null) {
            throw new NullPointerException("U should init first!!!");
        }

        if (controlHead == null) {
            throw new NullPointerException("U should init first!!!");
        }
        if (controlRobotAction == null) {
            throw new NullPointerException("U should init first!!!");
        }
    }

    public enum LightControl {
        WARN, NORMAL, TALKING, THINKING, LISTENING, LOWBATTERY, SINGING
    }

    /**
     * 控制灯光
     *
     * @param type
     */
    public void controlLight(LightControl type) {
        checkNotNull();
        switch (type) {
            case WARN:
                controlHead.warning();
                break;
            case NORMAL:
                controlHead.normal();
                break;
            case TALKING:
                controlHead.talking();
                break;
            case THINKING:
                controlHead.thinking();
                break;
            case LISTENING:
                controlHead.listening();
                break;
            case LOWBATTERY:
                controlHead.lowBattery();
                break;
            case SINGING:
                controlHead.singing();
                break;
            default:
                controlHead.normal();

        }

    }

    public enum HeadControl {
        STOP, LEFT, RIGHT, UP, DOWN
    }


    /**
     * 控制机器人头部运动
     *
     * @param type
     */
    public void controlHead(HeadControl type) {
        checkNotNull();
        switch (type) {
            case STOP:
                controlHead.stopTurnHead();
                break;
            case LEFT:
                controlHead.turnHeadLeft();
                break;
            case RIGHT:
                controlHead.turnHeadRight();
                break;
            case UP:
                controlHead.turnHeadUp();
                break;
            case DOWN:
                controlHead.turnHeadDown();
                break;
            default:
                controlHead.stopTurnHead();
        }

    }


    public enum Navigation {
        STATE, START, GO, CANCEL, STOP
    }

    /**
     * 地图控制
     *
     * @param type
     */
    public void controlNavi(Navigation type, SimpleAmyListener listener) {
        checkNotNull();
        switch (type) {
            case STOP:
                AmyNavigation.shutDownNavigation(listener);
                break;
            case START:
                AmyNavigation.startNavigationModel(listener);
                break;
            case STATE:
                AmyNavigation.getNavigationState(listener);
                break;
            case GO:
                // 默认1
                AmyNavigation.sendGoal(1, listener);
                break;
            case CANCEL:
                AmyNavigation.cancelGoal(listener);
                break;
            default:
        }

    }

    /**
     * 导航到
     *
     * @param position
     * @param listener
     */
    public void naviTo(int position, SimpleAmyListener listener) {
        AmyNavigation.sendGoal(position, listener);
    }

    public enum Action {
        STOP, LEFT, RIGHT, FORWARD, BACK, UP, DOWN, ARC2, DANCE, FOLLOW, STOP_FOLLOW, STRAIT2, AROUND360
    }

    /**
     * 控制机器人运动方向
     *
     * @param type
     */
    public void controlAction(Action type) {
        checkNotNull();
        switch (type) {
            case STOP:
                controlRobotAction.stopWalking();
                break;
            case LEFT:
                controlRobotAction.turnLeft();
                break;
            case RIGHT:
                controlRobotAction.turnRight();
                break;
            case FORWARD:
                controlRobotAction.goForward();
                break;
            case BACK:
                controlRobotAction.moveBack();
                break;
            case ARC2:
                controlRobotAction.moveArc2s();
                break;
            case DANCE:
                controlRobotAction.dance();
                break;
            case FOLLOW:
                controlRobotAction.follow();
                break;
            case STOP_FOLLOW:
                controlRobotAction.stopFollow();
                break;
            case STRAIT2:
                controlRobotAction.moveStraight2s();
                break;
            case AROUND360:
                controlRobotAction.turnRound(360);
                break;
            default:
                controlRobotAction.stopWalking();
        }

    }

    public enum Map {
        EXIST, START, LABEL, SAV, STOP
    }

    /**
     * 地图控制
     *
     * @param type
     */
    public void controlMap(Map type, SimpleAmyListener listener) {
        checkNotNull();
        switch (type) {
            case STOP:
                AmyCreateMap.stopMapModel(listener);
                break;
            case START:
                AmyCreateMap.startCreateMapModel(listener);
                break;
            case LABEL:
                AmyCreateMap.locateLable(listener);
                break;
            case SAV:
                AmyCreateMap.saveMap(listener);
                break;
            case EXIST:
                AmyCreateMap.mapState(listener);
                break;
            default:
        }

    }


    /**
     * 适配AmyListener 接口,按需实现
     */
    public static class SimpleAmyListener implements AmyListener {

        @Override
        public void onSendCmdSuccess(String cmd) {
            Log.d("SimpleAmyListener", cmd + "\t send success");
        }

        @Override
        public void onSendCmdFailed(String cmd) {
            Log.d("SimpleAmyListener", cmd + "\t send failed");
        }

        @Override
        public void onResult(String cmd, String result) {

        }
    }


}
