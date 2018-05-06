package com.ttxxly.reader.ui.finish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.FinishResults;
import com.ttxxly.reader.entity.HotResults;

public class FinishActivity extends AppCompatActivity implements FinishContract.View{

    private ImageView mFinish;
    private RecyclerView mRvFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        FinishContract.Presenter presenter = new FinishPresenter(this);
        presenter.start();
    }


    @Override
    public void init() {
        //返回阿牛
        mFinish = findViewById(R.id.ivFinishFinish);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //RecyclerView
        mRvFinish = findViewById(R.id.rvFinish);
        mRvFinish.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void showContent(FinishResults finishResults) {
        FinishAdapter finishAdapter = new FinishAdapter(this, finishResults);
        mRvFinish.setAdapter(finishAdapter);
    }
}
