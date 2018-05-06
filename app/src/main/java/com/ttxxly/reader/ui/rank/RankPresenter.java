package com.ttxxly.reader.ui.rank;

import com.google.gson.Gson;
import com.ttxxly.reader.entity.Hot;
import com.ttxxly.reader.entity.HotResults;
import com.ttxxly.reader.entity.Rank;
import com.ttxxly.reader.entity.RankingList;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-06
 * mail ttxxly@gmail.com
 */
public class RankPresenter implements RankContrct.presenter {

    private RankContrct.view mView;

    RankPresenter(RankContrct.view mView) {
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
        RankingList rankingList = new Gson().fromJson(Rank.content, RankingList.class);
        mView.showContent(rankingList);
    }
}
