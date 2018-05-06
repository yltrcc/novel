package com.ttxxly.reader.ui.hot;

import android.support.v7.view.menu.MenuView;

import com.google.gson.Gson;
import com.ttxxly.reader.entity.Hot;
import com.ttxxly.reader.entity.HotResults;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class HotPresenter implements HotContract.Presenter {

    private HotContract.View mView;

    HotPresenter(HotContract.View mView){
        this.mView = mView;
    }

    @Override
    public void start() {

        mView.init();
        getContent();
    }

    @Override
    public void stop() {

    }

    @Override
    public void getContent() {
        HotResults hotResults = new Gson().fromJson(Hot.content, HotResults.class);

        mView.showContent(hotResults);
    }
}
