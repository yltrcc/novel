package com.ttxxly.reader.ui.read;

import com.ttxxly.reader.base.BasePresenter;
import com.ttxxly.reader.base.BaseView;
import com.ttxxly.reader.entity.BookMixAToc;
import com.ttxxly.reader.entity.ChapterRead;

import java.util.List;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-04-03
 * mail ttxxly@gmail.com
 */
public class ReadContract {

    interface View extends BaseView {
        /**
         * 负责初始化操作
         */
        void init();

        /**
         * 展示目录
         * @param list
         */
        void showBookToc(List<BookMixAToc.mixToc.Chapters> list);

        /**
         * 展示阅读的章节
         * @param data
         * @param chapter
         */
        void showChapterRead(ChapterRead.Chapter data, int chapter);

        /**
         * 错误异常处理
         */
        void netError();
    }

    interface  Presenter extends BasePresenter {
        /**
         * 请求获取章节目录
         * @param bookId
         * @param viewChapters
         */
        void getBookMixAToc(String bookId, String viewChapters);

        /**
         * 请求获取章节内容
         * @param url
         * @param chapter
         */
        void getChapterRead(String url, int chapter);
    }
}
