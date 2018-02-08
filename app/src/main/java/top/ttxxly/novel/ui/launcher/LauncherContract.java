package top.ttxxly.novel.ui.launcher;

import top.ttxxly.novel.base.BasePresenter;
import top.ttxxly.novel.base.BaseView;

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
    }

    interface Presenter extends BasePresenter {

    }
}
