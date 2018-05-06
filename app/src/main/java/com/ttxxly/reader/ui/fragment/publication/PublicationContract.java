package com.ttxxly.reader.ui.fragment.publication;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;
import com.ttxxly.reader.entity.Publication;

/**
 * Description:
 * date: 2018/02/08 21:58
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class PublicationContract {
    interface View extends BaseView {
        /**
         * 初始化组件
         */
        void init();

        void showContent(Publication publication);
    }

    interface Presenter extends BasePresenter {

        /**
         * 获取内容
         */
        void getContent();
    }
}
