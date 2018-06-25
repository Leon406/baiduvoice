package leon.me.amylib.base;

import android.util.Log;

import com.amyrobotics.navgation.AmyListener;

/**
 * 适配AmyListener 接口,按需实现
 */
public class SimpleAmyListener implements AmyListener {

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