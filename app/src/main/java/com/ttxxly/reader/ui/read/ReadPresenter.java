package com.ttxxly.reader.ui.read;

import android.content.Context;

import com.ttxxly.reader.api.BookApi;
import com.ttxxly.reader.entity.BookMixAToc;
import com.ttxxly.reader.entity.ChapterRead;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-04-03
 * mail ttxxly@gmail.com
 */
public class ReadPresenter implements ReadContract.Presenter{

    private Context mContext;
    private ReadContract.View mView;
    private BookApi bookApi;

    ReadPresenter(Context mContext, ReadContract.View mView){
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void start() {
        bookApi = new BookApi();
    }

    @Override
    public void stop() {

    }

    @Override
    public void getBookMixAToc(String bookId, String viewChapters) {
        if (bookApi == null){
            bookApi = BookApi.getInstance();
        }
        bookApi.getBookMixAToc(bookId, viewChapters)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookMixAToc>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.netError();
                    }

                    @Override
                    public void onNext(BookMixAToc bookMixAToc) {
                        List<BookMixAToc.mixToc.Chapters> list = bookMixAToc.mixToc.chapters;
                        if (list != null && !list.isEmpty() && mView != null) {
                            mView.showBookToc(list);
                        }
                    }
                });
    }

    @Override
    public void getChapterRead(String url, int chapter) {
        final int number = chapter;
        if (bookApi == null){
            bookApi = BookApi.getInstance();
        }
        bookApi.getChapterRead(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChapterRead>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.netError();
                    }

                    @Override
                    public void onNext(ChapterRead chapterRead) {
                        if (chapterRead.chapter != null && mView != null) {
                            mView.showChapterRead(chapterRead.chapter, number);
                        } else {
                            mView.netError();
                        }
                    }
                });
    }
}
