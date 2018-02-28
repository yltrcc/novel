package top.ttxxly.novel.ui.fragment.bookshelf;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import top.ttxxly.novel.entity.MyBooks;
import top.ttxxly.novel.utils.FileUtils;

import static android.content.Context.MODE_PRIVATE;
import static javax.xml.transform.OutputKeys.ENCODING;

/**
 * Description:
 * date: 2018/02/08 21:59
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class BookshelfPresenter implements BookshelfContract.presenter {
    private BookshelfContract.view view; //只在当前类有效
    private Context context;

    public BookshelfPresenter(BookshelfContract.view view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void start() {
        getDataSource();
    }

    @Override
    public void stop() {

    }

    @Override
    public void getDataSource() {
        //获取应用书架信息
        String jsonString = FileUtils.getFileContent("MyBooks", context);
        System.out.println(jsonString);
        if (jsonString != null) {
            Gson gson = new Gson();
            MyBooks myBooks = gson.fromJson(jsonString, MyBooks.class);
            view.init(myBooks);
        } else {
            Toast.makeText(context, "书架为空哦", Toast.LENGTH_LONG).show();
            view.setEmptyView();
        }
    }
}
