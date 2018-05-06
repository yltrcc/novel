package com.ttxxly.reader.ui.category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.CategoryList;
import com.ttxxly.reader.utils.SupportGridItemDecoration;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View{

    private ImageView mFinish;
    private RecyclerView mRvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        CategoryContract.Presenter presenter = new CategoryPresenter(this);
        presenter.start();
    }


    @Override
    public void init() {
        //返回按钮
        mFinish = findViewById(R.id.ivCategoryFinish);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //RecycleView
        mRvCategory = findViewById(R.id.rvCategory);
        mRvCategory.setLayoutManager(new GridLayoutManager(this, 3));
        mRvCategory.addItemDecoration(new SupportGridItemDecoration(this));
    }

    @Override
    public void showContent(CategoryList categoryList) {
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categoryList);
        mRvCategory.setAdapter(categoryAdapter);
    }
}
