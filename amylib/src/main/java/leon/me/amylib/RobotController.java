package leon.me.amylib;

import android.content.Context;

import com.amyrobotics.controlheadandlight.ControlHead;
import com.amyrobotics.controlrobotaction.ControlRobotAction;
import com.amyrobotics.navgation.AmyCreateMap;
import com.amyrobotics.navgation.AmyNavigation;

import leon.me.amylib.base.Action;
import leon.me.amylib.base.HeadControl;
import leon.me.amylib.base.LightControl;
import leon.me.amylib.base.Map;
import leon.me.amylib.base.Navigation;
import leon.me.amylib.base.SimpleAmyListener;

/**
 * @author Leon
 * @Desc 机器人控制类
 */
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
                //耗时 10-20s 成功 result="#NAV02"   失败result="#NAV07"
                AmyNavigation.startNavigationModel(listener);
                break;
            case STATE:
                //成功 result="#NAV02"   失败result="#NAV07"
                AmyNavigation.getNavigationState(listener);
                break;
            case GO:
                // 默认1
                //成功 result="#NAV01"   丢失目标result="#NAV03"   超时result="#NAV04"
                AmyNavigation.sendGoal(1, listener);
                break;
            case CANCEL:
                // 成功 result="#NAV06"  失败result="#NAV07"
                AmyNavigation.cancelGoal(listener);
                break;
            default:
        }
    }

    /**
     * 导航到
     * <pre>
     *          成功     result = "#NAV01"
     *          丢失目标 result = "#NAV03"
     *          超时     result = "#NAV04"
     *
     * </pre>
     *
     * @param position
     * @param listener
     */
    public void naviTo(int position, SimpleAmyListener listener) {
        AmyNavigation.sendGoal(position, listener);
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

    /**
     * 地图控制
     *
     * @param type
     */
    public void controlMap(Map type, SimpleAmyListener listener) {
        checkNotNull();
        switch (type) {
            case STOP:
                //  成功 result="FINDM"   失败result="NOM"
                AmyCreateMap.stopMapModel(listener);
                break;
            case START:
                //  成功 result="#MAPS"   失败result="#MAPF"
                AmyCreateMap.startCreateMapModel(listener);
                break;
            case LABEL:
                //#SET, x , y , z
                AmyCreateMap.locateLable(listener);
                break;
            case SAV:
                //  成功 result="FINDM"   失败result="NOM"
                AmyCreateMap.saveMap(listener);
                break;
            case EXIST:
                //  成功 result="FINDM"   失败result="NOM"
                AmyCreateMap.mapState(listener);
                break;
            default:
        }
    }
}
