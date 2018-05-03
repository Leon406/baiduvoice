package ll.leon.com.voicelib.recognization.online;

import android.app.Activity;

import com.baidu.speech.asr.SpeechConstant;

import java.util.Arrays;

import ll.leon.com.voicelib.recognization.CommonRecogParams;

/**
 * Created by fujiayi on 2017/6/13.
 */

public class OnlineRecogParams extends CommonRecogParams {


    private static final String TAG = "OnlineRecogParams";

    public OnlineRecogParams(Activity context) {
        super(context);

        stringParams.addAll(Arrays.asList(
                "_language", // 用于生成PID参数
                "_model" // 用于生成PID参数
        ));

        intParams.addAll(Arrays.asList(SpeechConstant.PROP));

        boolParams.addAll(Arrays.asList(SpeechConstant.DISABLE_PUNCTUATION));

    }


}
