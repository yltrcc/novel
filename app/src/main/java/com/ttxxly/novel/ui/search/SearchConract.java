package com.ttxxly.novel.ui.search;

import com.ttxxly.novel.base.BasePresenter;
import com.ttxxly.novel.base.BaseView;
import com.ttxxly.novel.entity.SearchResults;
import com.ttxxly.novel.entity.SearchHistory;

import java.util.List;

/**
 * Description:
 * date: 2018/02/08 22:01
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */
public class SearchConract {

    interface View extends BaseView{
        /**
         * 初始化组件
         */
        void initView();

        /**
         * 展示搜索热词
         * @param list
         */
        void showHotWordList(List<String> list);

        void showAutoCompleteList(List<String> list);

        /**
         * 展示搜索历史
         */
        void showSearchHistory(SearchHistory history);
        /**
         * 展示搜索结果
         * @param
         */
        void showSearchResultList(SearchResults searchResults);
        /**
         * 获取搜索历史记录
         */
        SearchHistory getSearchHistory();
    }

    interface  Presenter extends BasePresenter {

        /**
         * 获取搜索热词
         */
        void getSearchHotWord();

        /**
         * 获取自动补充数据
         * @param search
         */
        void getAutoComplete(String search);

        /**
         * 获取搜索结果数据
         * @param search
         */
        void getSearchResult(String search);


    }
}
