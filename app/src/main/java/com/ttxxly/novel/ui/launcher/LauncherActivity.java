package com.ttxxly.novel.ui.launcher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.ttxxly.novel.R;
import com.ttxxly.novel.entity.Const;
import com.ttxxly.novel.ui.home.HomeActivity;

/**
 * @author ttxxly
 */
public class LauncherActivity extends AppCompatActivity implements LauncherContract.View{

    private LauncherContract.Presenter mPresenter = new LauncherPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        LinearLayout mLLLauncher = findViewById(R.id.LLLauncher);
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

    @Override
    public void initLoginStatus() {
        //1、打开Preferences，名称为setting，如果存在则打开它，否则创建新的Preferences
        SharedPreferences userInfo = getSharedPreferences(Const.USER_INFO, 0);
        //2、让setting处于编辑状态
        SharedPreferences.Editor editor = userInfo.edit();
        //3、存放数据
        editor.putInt(Const.USER_ID, -1);
        editor.putBoolean(Const.LOGIN_STATUS, false);
        //4、完成提交
        editor.apply();
    }
}
