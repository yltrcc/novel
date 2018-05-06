package com.ttxxly.reader.ui.read;

import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListPopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.BookMixAToc;
import com.ttxxly.reader.entity.Chapter;
import com.ttxxly.reader.entity.ChapterRead;
import com.ttxxly.reader.entity.Const;
import com.ttxxly.reader.entity.Rank;
import com.ttxxly.reader.entity.RankingList;
import com.ttxxly.reader.entity.Recommend;
import com.ttxxly.reader.utils.ScreenUtils;

import java.util.List;
import java.util.Scanner;

import static com.ttxxly.reader.entity.Const.INTENT_BEAN;

/**
 * description: 阅读模块
 *
 * @author ttxxly
 * @date 2018年4月21日21:22:47
 * mail ttxxly@gmail.com
 */

public class ReadActivity extends AppCompatActivity implements ReadContract.View {

    private String mCurrentChapter;
    private String bookId;
    private List<BookMixAToc.mixToc.Chapters> mToc;
    private ReadContract.Presenter mPresenter;
    private ListPopupWindow mListPopupWindow;
    private FrameLayout mflReadWidget;
    private View page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //如果有虚拟按键，隐藏
        ScreenUtils.hideVirtualButtons(this);

        bookId = getIntent().getStringExtra(Const.BOOKID);
        mCurrentChapter = getIntent().getStringExtra(Const.CURRENT_CHAPTER);

        mPresenter = new ReadPresenter(this);
        mPresenter.start();
        //获取目录
        mPresenter.getBookMixAToc(bookId, "chapters");
    }

    @Override
    public void init() {
        ChapterRead chapterRead = new Gson().fromJson(Chapter.content, ChapterRead.class);
        mflReadWidget = findViewById(R.id.flReadWidget);
        mflReadWidget.removeAllViews();
        page = new BaseView(this, chapterRead);
        mflReadWidget.addView(page);
    }

    @Override
    public void SetBookToc(List<BookMixAToc.mixToc.Chapters> list) {
        mToc = list;
    }

    @Override
    public void showChapterRead(ChapterRead.Chapter data, int chapter) {

    }

    @Override
    public void netError() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
