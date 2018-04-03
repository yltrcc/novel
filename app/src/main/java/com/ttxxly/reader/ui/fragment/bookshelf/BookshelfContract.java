package com.ttxxly.reader.ui.fragment.bookshelf;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;
import com.ttxxly.reader.entity.Bookshelf;

/**
 * Description:
 * date: 2018/02/08 21:59
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class BookshelfContract {

    interface view extends BaseView {
        void init(Bookshelf Bookshelf);
        void addDataSource();
        void getDataSource();
        void setDataSource();

        /**
         * 书架信息为空时，设置为空视图
         */
        void setEmptyView();

        /**
         * 获取登录状态
         * @return true 表示已登录， false 表示没有登录
         */
        Boolean getLoginStatus();

        /**
         * 获取用户ID
         * @return 用户ID -1 表示无用户
         */
        int getUserId();
    }

    interface presenter extends BasePresenter{
        /**
         * 获取书架信息
         */
        void getDataSource();
    }
}
