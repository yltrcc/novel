package top.ttxxly.novel.modules.home;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;

import top.ttxxly.novel.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        StatusBarUtil.setColor(HomeActivity.this,
                Color.parseColor("#FFFFFF"), 120);
    }
}
