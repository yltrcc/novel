package com.ttxxly.reader.ui.selection;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;
import com.ttxxly.reader.entity.FinishResults;
import com.ttxxly.reader.entity.SelectionResults;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class SelectionContract {

    interface View extends BaseView {

        /**
         * 初始化组件
         */
        void init();

        /**
         * 展示内容
         */
        void showContent(SelectionResults selectionResults);
    }

    interface  Presenter extends BasePresenter {

        /**
         * 获取内容
         */
        void getContent();
    }
}
