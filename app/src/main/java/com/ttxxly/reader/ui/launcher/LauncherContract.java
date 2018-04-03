package com.ttxxly.reader.ui.launcher;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;

/**
 * Description:
 * date: 2017-11-03 14:03
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */
public class LauncherContract {

    interface View extends BaseView {

        /**
         * 跳转主页面
         */
        void goHomeActivity();
        /**
         * 初始化登录状态
         */
        void initLoginStatus();
    }

    interface Presenter extends BasePresenter {

    }
}
