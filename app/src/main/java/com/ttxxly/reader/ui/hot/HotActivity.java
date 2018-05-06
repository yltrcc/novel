package com.ttxxly.reader.ui.hot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.HotResults;

public class HotActivity extends AppCompatActivity implements HotContract.View{

    private ImageView mFinish;
    private RecyclerView mRvHot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);

        HotContract.Presenter presenter = new HotPresenter(this);
        presenter.start();
    }

    @Override
    public void init() {

        //返回按钮
        mFinish = findViewById(R.id.ivHotFinish);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //RecycleView
        mRvHot = findViewById(R.id.rvHot);
        mRvHot.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showContent(HotResults hotResults) {
        HotAdapter hotAdapter = new HotAdapter(this, hotResults);
        mRvHot.setAdapter(hotAdapter);
    }
}
