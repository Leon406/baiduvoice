package leon.me.control.utils;

import android.content.Context;
import android.widget.Toast;

import com.amyrobotics.controlheadandlight.ControlHead;
import com.amyrobotics.controlrobotaction.ControlRobotAction;

public class RobotController {

    private static RobotController robotController;
    private ControlHead controlHead;
    private ControlRobotAction controlRobotAction;
    private static   Context ctx;

    public void init(Context app) {
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


    private void checkNotNull() {
        if (ctx == null) {
            throw new NullPointerException("U should init first!!!");
        }

        if (controlHead == null) {
            throw new NullPointerException("U should init first!!!");
        }
    }

    public interface LightControl {
        int WARN = 0;
        int NORMAL = 1;
        int TALKING = 2;
        int THINKING = 3;
        int LISTENING = 4;
        int LOWBATTERY = 5;
        int SINGING = 6;
    }

    public void controlLight(int type) {
        checkNotNull();
        switch (type) {
            case LightControl.WARN:
                controlHead.warning();
                break;
            case LightControl.NORMAL:
                controlHead.normal();
                break;
            case LightControl.TALKING:
                controlHead.talking();
                break;
            case LightControl.THINKING:
                controlHead.thinking();
                break;
            case LightControl.LISTENING:
                controlHead.listening();
                break;
            case LightControl.LOWBATTERY:
                controlHead.lowBattery();
                break;
            case LightControl.SINGING:
                controlHead.singing();
                break;
            default:
                controlHead.normal();

        }

    }
}
