package com.ttxxly.reader.ui.read;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.BookMixAToc;
import com.ttxxly.reader.entity.ChapterRead;
import com.ttxxly.reader.entity.Recommend;

import java.util.List;

import static com.ttxxly.reader.entity.Const.INTENT_BEAN;

/**
 * description: 阅读模块
 *
 * @author  ttxxly
 * @date 2018年4月21日21:22:47
 * mail ttxxly@gmail.com
 */

public class ReadActivity extends AppCompatActivity implements ReadContract.View {

    private FrameLayout mFLReadWidget;
    private BaseReadView mPageWidget;
    private Recommend.RecommendBooks recommendBooks;
    private String bookId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recommendBooks = (Recommend.RecommendBooks) getIntent().getSerializableExtra(INTENT_BEAN);
        bookId = recommendBooks._id;
    }

    @Override
    public void init() {
        /**
         * 阅读组件
         */
        mFLReadWidget = findViewById(R.id.flReadWidget);
        mPageWidget = new NoAimWidget(this, bookId, mChapterList, new ReadListener());
        mFLReadWidget.removeAllViews();
        mFLReadWidget.addView(mPageWidget);
    }

    @Override
    public void showBookToc(List<BookMixAToc.mixToc.Chapters> list) {

    }

    @Override
    public void showChapterRead(ChapterRead.Chapter data, int chapter) {

    }

    @Override
    public void netError() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
