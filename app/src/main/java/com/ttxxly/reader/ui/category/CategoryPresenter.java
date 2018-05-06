package com.ttxxly.reader.ui.category;

import com.google.gson.Gson;
import com.ttxxly.reader.entity.Category;
import com.ttxxly.reader.entity.CategoryList;
import com.ttxxly.reader.entity.Hot;
import com.ttxxly.reader.entity.HotResults;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View mView;

    CategoryPresenter(CategoryContract.View mView){
        this.mView = mView;
    }

    @Override
    public void start() {

        mView.init();
        getContent();
    }

    @Override
    public void stop() {

    }

    @Override
    public void getContent() {
        CategoryList categoryList = new Gson().fromJson(Category.content, CategoryList.class);

        mView.showContent(categoryList);
    }
}
