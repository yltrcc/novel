package top.ttxxly.novel.ui.launcher;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.ttxxly.novel.R;
import top.ttxxly.novel.ui.home.HomeActivity;

/**
 * @author ttxxly
 */
public class LauncherActivity extends AppCompatActivity implements LauncherContract.View{

    private LauncherContract.Presenter mPresenter = new LauncherPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        mPresenter.start();
    }

    @Override
    public void goHomeActivity() {
        Handler handler = new Handler();
        //3 秒后跳转到主页面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LauncherActivity.this, HomeActivity.class);
                startActivity(intent);
                // Activity 切换淡入淡出动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 3000);
    }
}
