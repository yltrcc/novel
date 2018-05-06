package com.ttxxly.reader.ui.fragment.user;

/**
 * Description:
 * date: 2018/02/08 21:57
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class UserPresenter implements UserContract.Presenter{

    private UserContract.View mView;

    UserPresenter(UserContract.View mView) {
        this.mView = mView;
    }
    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void stop() {

    }
}
