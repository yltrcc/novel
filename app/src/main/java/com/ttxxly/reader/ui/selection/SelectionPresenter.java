package com.ttxxly.reader.ui.selection;

import com.google.gson.Gson;
import com.ttxxly.reader.entity.FinishResults;
import com.ttxxly.reader.entity.Hot;
import com.ttxxly.reader.entity.Selection;
import com.ttxxly.reader.entity.SelectionResults;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class SelectionPresenter implements SelectionContract.Presenter {

    private SelectionContract.View mView;

    SelectionPresenter(SelectionContract.View mView){
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
        SelectionResults selectionResults = new Gson().fromJson(Selection.content, SelectionResults.class);

        mView.showContent(selectionResults);
    }
}
