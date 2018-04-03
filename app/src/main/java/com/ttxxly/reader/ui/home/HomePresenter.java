package com.ttxxly.reader.ui.home;

/**
 * Description:
 * date: 2018/02/08 21:56
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View mView;

    HomePresenter(HomeContract.View view){
        mView = view;
    }

    @Override
    public void start() {
        mView.initViewPager();
    }

    @Override
    public void stop() {

    }
}
