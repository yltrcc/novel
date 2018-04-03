package com.ttxxly.reader.ui.read;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.BookMixAToc;
import com.ttxxly.reader.entity.ChapterRead;

import java.util.List;

public class ReadActivity extends AppCompatActivity implements ReadContract.View{

    private FrameLayout mFLReadWidget;
    private BaseReadView mPageWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
    }

    @Override
    public void init() {
        /**
         * 阅读组件
         */
        mFLReadWidget = findViewById(R.id.flReadWidget);
        mPageWidget = new NoAimWidget(this, bookId, mChapterList, new ReadListener());
        mFLReadWidget.removeAllViews();
        mFLReadWidget.addView();
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
