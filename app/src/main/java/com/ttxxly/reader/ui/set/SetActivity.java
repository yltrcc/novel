package com.ttxxly.reader.ui.set;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ttxxly.reader.R;

public class SetActivity extends AppCompatActivity implements SetContract.view{

    private ImageView mFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
    }

    @Override
    public void init() {
        //返回按钮
        mFinish = findViewById(R.id.ivSettingsFinish);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
