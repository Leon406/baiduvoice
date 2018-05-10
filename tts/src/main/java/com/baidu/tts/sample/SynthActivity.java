/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.tts.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 合成demo。含在线和离线，没有纯离线功能。
 * 根据网络状况优先走在线，在线时访问服务器失败后转为离线。
 */
public class SynthActivity extends BaseActivity implements View.OnClickListener {

    protected static String DESC = "请先看完说明。之后点击“合成并播放”按钮即可正常测试。\n"
            + "测试离线合成功能需要首次联网。\n"
            + "纯在线请修改代码里ttsMode为TtsMode.ONLINE， 没有纯离线。\n"
            + "本Demo的默认参数设置为wifi情况下在线合成, 其它网络（包括4G）使用离线合成。 在线普通女声发音，离线男声发音.\n"
            + "合成可以多次调用，SDK内部有缓存队列，会依次完成。\n\n";

    private static final String TAG = "SynthActivity";
    private SynthHelper synthHelper;
    private Handler mainHandler = new Handler() {
        /*
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case INIT_SUCCESS:
                    for (Button b : buttons) {
                        b.setEnabled(true);
                    }
                    msg.what = PRINT;
                    SpannableString colorfulText = new SpannableString(mInput.getText().toString());
                    if (msg.arg1 <= colorfulText.toString().length()) {
                        colorfulText.setSpan(new ForegroundColorSpan(Color.GRAY), 0, msg.arg1, Spannable
                                .SPAN_EXCLUSIVE_EXCLUSIVE);
                        mInput.setText(colorfulText);
                    }
                    break;
                case PRINT:
                    print(msg);
                    break;
                case UI_CHANGE_INPUT_TEXT_SELECTION:
                    if (msg.arg1 <= mInput.getText().length()) {
                        mInput.setSelection(0, msg.arg1);
                    }
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShowText.setText(DESC);

        initialButtons(); // 配置onclick
// 初始化TTS引擎
        synthHelper = SynthHelper.getInstance(this.getApplicationContext(), mainHandler);

    }

    /**
     * 界面上的按钮对应方法
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.speak:
                speak(); // 合成并播放
                break;
            case R.id.loadModel:
                // 切换离线资源
                break;
            case R.id.pause:
                synthHelper.pause();

                break;
            case R.id.resume:
                synthHelper.resume();

                break;
            case R.id.stop:
                synthHelper.stop();
                break;
            case R.id.help:
                mShowText.setText(DESC);
                break;
            default:
                break;
        }
    }

    /**
     * speak 实际上是调用 synthesize后，获取音频流，然后播放。
     * 获取音频流的方式见SaveFileActivity及FileSaveListener
     * 需要合成的文本text的长度不能超过1024个GBK字节。
     */
    private void speak() {
        mShowText.setText("");
        String text = mInput.getText().toString();
        // 需要合成的文本text的长度不能超过1024个GBK字节。
        if (TextUtils.isEmpty(mInput.getText())) {
            text = "百度语音，面向广大开发者永久免费开放语音合成技术。";
            mInput.setText(text);
        }
        // 合成前可以修改参数：
        // Map<String, String> params = getParams();
        // synthesizer.setParams(params);
        synthHelper.speak(text);
    }


    @Override
    protected void onDestroy() {
        synthHelper.release();
        Log.i(TAG, "释放资源成功");
        super.onDestroy();
    }


    private void initialButtons() {
        for (Button b : buttons) {
            b.setOnClickListener(this);
            b.setEnabled(false); // 先禁用按钮，等待引擎初始化后打开。
        }
        mHelp.setOnClickListener(this);
    }

}
