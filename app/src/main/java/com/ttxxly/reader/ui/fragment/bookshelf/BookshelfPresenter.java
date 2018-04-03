package com.ttxxly.reader.ui.fragment.bookshelf;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import com.ttxxly.reader.entity.Bookshelf;
import com.ttxxly.reader.entity.Const;
import com.ttxxly.reader.utils.FileUtils;

/**
 * Description:
 * date: 2018/02/08 21:59
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class BookshelfPresenter implements BookshelfContract.presenter {
    private BookshelfContract.view view;
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
        // 1. 获取用户登录状态
        Boolean mLoginStatus = view.getLoginStatus();
        // 2. 没有登录，加载默认书架
        // 3. 已登录，加载对应用户书架数据

        if (!mLoginStatus) {
            //加载默认书架
            initBookShelf(Const.DEFAULT_BOOKSHELF);
        }else {
            //加载用户对应书架信息
            // 获取用户ID -1表示用户不存在
            int mUserId = view.getUserId();
            if (mUserId == -1) {
                initBookShelf(Const.DEFAULT_BOOKSHELF);
            }else {
                initBookShelf(mUserId+"_Bookshelf");
            }
        }
    }

    /**
     * 根据 文件名 读取数据
     * @param fileName 文件名
     */
    private void initBookShelf(String fileName){
        String jsonString = FileUtils.getFileContent(fileName, context);
        System.out.println(jsonString);
        if (jsonString != null) {
            Gson gson = new Gson();
            Bookshelf bookshelf = gson.fromJson(jsonString, Bookshelf.class);
            view.init(bookshelf);
        } else {
            Toast.makeText(context, "书架为空哦", Toast.LENGTH_LONG).show();
            view.setEmptyView();
        }
    }
}
