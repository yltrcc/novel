package com.ttxxly.reader.ui.search;

import com.ttxxly.reader.api.BookApi;
import com.ttxxly.reader.entity.HotWord;
import com.ttxxly.reader.entity.SearchResults;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Description:
 * date: 2018/02/08 22:01
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class SearchPresenter implements SearchConract.Presenter {
    private BookApi bookApi;
    private SearchConract.View mView;

    SearchPresenter(SearchConract.View view) {
        mView = view;
    }

    @Override
    public void start() {

        mView.initView();

        bookApi = new BookApi();
        getSearchHotWord();
        mView.showSearchHistory(mView.getSearchHistory());
    }

    @Override
    public void stop() {

    }

    @Override
    public void getSearchHotWord() {
        if (bookApi == null){
            bookApi = BookApi.getInstance();
        }
        bookApi.getHotWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotWord>() {
            @Override
            public void onCompleted() {
                System.out.println("完成1111");
            }

            @Override
            public void onError(Throwable e) {
                //获取失败
                System.out.println("失败11111");
            }

            @Override
            public void onNext(HotWord hotWord) {
                //获取成功
                System.out.println("List:11111111" + hotWord.getHotWords());
                List<String> list = hotWord.getHotWords();
                if (mView != null && list != null) {
                    mView.showHotWordList(list);
                }
            }
        });

    }

    @Override
    public void getAutoComplete(String search) {

    }

    @Override
    public void getSearchResult(final String search) {
        bookApi.getSearchResult(search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchResults>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("搜索结果失败了！！！！ 天啊撸");
                    }

                    @Override
                    public void onNext(SearchResults searchResults) {
                        if (searchResults.getTotal()!=0 && mView != null) {
                            mView.showSearchResultList(searchResults);
                        }
                    }
                });
    }

}
