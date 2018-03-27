package com.ttxxly.novel.ui.bookdetail;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-03-27
 * mail ttxxly@gmail.com
 */

public class BookDetailPresenter implements BookDetailContract.Presenter{
    private BookDetailContract.View mView;

    BookDetailPresenter(BookDetailContract.View mView){
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.initView();
    }

    @Override
    public void stop() {

    }
}
