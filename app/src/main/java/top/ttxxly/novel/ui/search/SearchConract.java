package top.ttxxly.novel.ui.search;

import java.util.List;

import top.ttxxly.novel.base.BasePresenter;
import top.ttxxly.novel.base.BaseView;
import top.ttxxly.novel.entity.SearchDetail;

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

        void showHotWordList(List<String> list);

        void showAutoCompleteList(List<String> list);

        /**
         * 展示搜索结果
         * @param list
         */
        void showSearchResultList(List<SearchDetail.SearchBooks> list);
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
