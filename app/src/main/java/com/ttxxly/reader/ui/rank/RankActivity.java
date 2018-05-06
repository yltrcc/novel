package com.ttxxly.reader.ui.rank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.RankingList;

public class RankActivity extends AppCompatActivity implements RankContrct.view{

    private ImageView mFinish;
    private RecyclerView mRvRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        RankContrct.presenter presenter = new RankPresenter(this);
        presenter.start();
    }

    @Override
    public void init() {
        //返回按钮
        mFinish = findViewById(R.id.ivRankFinish);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //recyclerView elvMale
        mRvRank = findViewById(R.id.elvMale);
        mRvRank.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showContent(RankingList rankingList) {
        RankAdapter rankAdapter = new RankAdapter(this, rankingList);
        mRvRank.setAdapter(rankAdapter);
    }
}
