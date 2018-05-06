package com.ttxxly.reader.ui.finish;

import com.google.gson.Gson;
import com.ttxxly.reader.entity.FinishResults;
import com.ttxxly.reader.entity.Hot;
import com.ttxxly.reader.entity.HotResults;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class FinishPresenter implements FinishContract.Presenter {

    private FinishContract.View mView;

    FinishPresenter(FinishContract.View mView){
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
        FinishResults finishResults = new Gson().fromJson(Hot.content, FinishResults.class);

        mView.showContent(finishResults);
    }
}
