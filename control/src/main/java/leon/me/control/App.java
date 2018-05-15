package leon.me.control;

import android.app.Application;

import leon.me.control.utils.RobotController;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        RobotController.getInstance().init(this);
    }
}
