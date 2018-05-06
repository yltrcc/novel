package com.ttxxly.reader.ui.hot;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;
import com.ttxxly.reader.entity.HotResults;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class HotContract {

    interface View extends BaseView {

        /**
         * 初始化组件
         */
        void init();

        /**
         * 展示内容
         */
        void showContent(HotResults hotResults);
    }

    interface  Presenter extends BasePresenter {

        /**
         * 获取内容
         */
        void getContent();
    }
}
