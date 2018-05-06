package com.ttxxly.reader.ui.category;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;
import com.ttxxly.reader.entity.CategoryList;
import com.ttxxly.reader.entity.HotResults;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class CategoryContract {

    interface View extends BaseView {

        /**
         * 初始化组件
         */
        void init();

        /**
         * 展示内容
         */
        void showContent(CategoryList categoryList);
    }

    interface  Presenter extends BasePresenter {

        /**
         * 获取内容
         */
        void getContent();
    }
}
