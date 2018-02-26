package top.ttxxly.novel.ui.fragment.bookrack;

import top.ttxxly.novel.base.BasePresenter;
import top.ttxxly.novel.base.BaseView;
import top.ttxxly.novel.base.BaseViewPager;
import top.ttxxly.novel.entity.MyBooks;

/**
 * Description:
 * date: 2018/02/08 21:59
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class BookrackContract {

    interface view extends BaseView {
        void init(MyBooks myBooks);
        void addDataSource();
        void getDataSource();
        void setDataSource();
    }

    interface presenter extends BasePresenter{
        void getDataSource();
    }
}
