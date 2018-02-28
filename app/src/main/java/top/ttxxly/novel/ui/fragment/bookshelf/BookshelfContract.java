package top.ttxxly.novel.ui.fragment.bookshelf;

import top.ttxxly.novel.base.BasePresenter;
import top.ttxxly.novel.base.BaseView;
import top.ttxxly.novel.entity.MyBooks;

/**
 * Description:
 * date: 2018/02/08 21:59
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class BookshelfContract {

    interface view extends BaseView {
        void init(MyBooks myBooks);
        void addDataSource();
        void getDataSource();
        void setDataSource();
        void setEmptyView();
    }

    interface presenter extends BasePresenter{
        void getDataSource();
    }
}
