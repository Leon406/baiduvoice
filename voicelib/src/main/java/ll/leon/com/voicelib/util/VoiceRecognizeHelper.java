package ll.leon.com.voicelib.util;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;

import com.baidu.speech.asr.SpeechConstant;

import java.util.LinkedHashMap;
import java.util.Map;

import ll.leon.com.voicelib.control.MyRecognizer;
import ll.leon.com.voicelib.recognization.CommonRecogParams;
import ll.leon.com.voicelib.recognization.IStatus;
import ll.leon.com.voicelib.recognization.MessageStatusRecogListener;
import ll.leon.com.voicelib.recognization.StatusRecogListener;
import ll.leon.com.voicelib.recognization.online.OnlineRecogParams;

public class VoiceRecognizeHelper implements IStatus {

    public static final String TAG = "VoiceRecognizeHelper";
    private static VoiceRecognizeHelper voiceRecognizeHelper;
    private static Activity ctx;
    private static Handler mainHandler;
    // mode 1537 中文待标点   1737 英文代表点
    private static int mode = 1537;
    protected int status;
    private MyRecognizer myRecognizer;
    private CommonRecogParams apiParams;

    private VoiceRecognizeHelper() {
        initRecog();
    }

    public static void init(Activity ct, Handler handler) {
        ctx = ct;
        mainHandler = handler;
    }

    public static VoiceRecognizeHelper getInstance() {

        if (voiceRecognizeHelper == null) {
            synchronized (VoiceRecognizeHelper.class) {
                if (voiceRecognizeHelper == null) {
                    voiceRecognizeHelper = new VoiceRecognizeHelper();
                }
            }
        }
        return voiceRecognizeHelper;
    }

    /**
     * mode 1537 中文+标点
     * 1737 英文+标点
     *
     * @param mode
     */
    public void setMode(int mode) {
        VoiceRecognizeHelper.mode = mode;
    }

    public void onPause() {
        if (myRecognizer != null) {
            myRecognizer.stop();
        }
    }

    public void onDestroy() {
        if (null != myRecognizer) {
            myRecognizer.release();
            myRecognizer = null;
        }
    }

    public CommonRecogParams getApiParams() {
        return new OnlineRecogParams(ctx);
    }

    public void voice(boolean isRecord) {

        if (isRecord) {

            Log.d(TAG, "开始录音");
            if (null == myRecognizer) {
                initRecog();
                Log.d(TAG, "重新初始化服务");
            }
            startRecord();
        } else {
            Log.d(TAG, "结束录音");
            stopRecord();
        }
    }

    private void initRecog() {
        StatusRecogListener listener = new MessageStatusRecogListener(mainHandler);
        if (myRecognizer != null) {
            myRecognizer.release();
        }
        myRecognizer = new MyRecognizer(ctx, listener);
        apiParams = getApiParams();
        status = STATUS_NONE;

    }

    protected void startRecord() {
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        String event = SpeechConstant.ASR_START; // 替换成测试的event
        params.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, false);//是否需要语音音量数据回调，开启后有CALLBACK_EVENT_ASR_VOLUME事件回调
        params.put(SpeechConstant.NLU, "enable");
        params.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 0); // 长语音
        params.put(SpeechConstant.VAD, SpeechConstant.VAD_DNN);
        params.put(SpeechConstant.PROP, 20000);
        params.put(SpeechConstant.PID, mode); // 中文输入法模型，有逗号
        myRecognizer.start(params);
    }


    public void stopRecord() {
        if (myRecognizer != null) {
            myRecognizer.stop();
        }
    }

    public void cancel() {
        if (myRecognizer != null) {
            myRecognizer.cancel();
        }
    }

}
