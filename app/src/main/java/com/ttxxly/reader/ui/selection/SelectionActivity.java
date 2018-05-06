package com.ttxxly.reader.ui.selection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.SelectionResults;

public class SelectionActivity extends AppCompatActivity implements SelectionContract.View{

    private ImageView mFinish;
    private RecyclerView mRvSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        SelectionPresenter presenter = new SelectionPresenter(this);
        presenter.start();
    }


    @Override
    public void init() {
        //返回按钮
        mFinish = findViewById(R.id.ivFinish);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //RecyclerView
        mRvSelection = findViewById(R.id.mRvSelection);
        mRvSelection.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showContent(SelectionResults selectionResults) {
        SelectionAdapter selectionAdapter = new SelectionAdapter(this, selectionResults);
        mRvSelection.setAdapter(selectionAdapter);

    }
}
