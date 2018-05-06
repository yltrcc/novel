package com.ttxxly.reader.ui.rank;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;
import com.ttxxly.reader.entity.RankingList;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-06
 * mail ttxxly@gmail.com
 */
public class RankContrct {

    interface view extends BaseView{

        void init();

        void showContent(RankingList rankingList);
    }

    interface presenter extends BasePresenter{

        void getContent();
    }
}
