package leon.me.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import leon.me.control.utils.RobotController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    private int type;

    public void warn(View view) {
        RobotController.getInstance().controlLight(type++ %7);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        RobotController.getInstance().unBind();
    }
}
