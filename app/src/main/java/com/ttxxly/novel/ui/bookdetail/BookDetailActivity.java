package com.ttxxly.novel.ui.bookdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ttxxly.novel.GlideApp;
import com.ttxxly.novel.R;
import com.ttxxly.novel.entity.Const;
import com.ttxxly.novel.entity.SearchResults;

import java.util.List;

import me.gujun.android.taggroup.TagGroup;

public class BookDetailActivity extends AppCompatActivity implements BookDetailContract.View{

    private BookDetailContract.Presenter presenter;
    private ImageView mCover;
    private TextView mTitle;
    private TextView mAuthor;
    private TextView mCategory;
    private TextView mWordcount;
    private TextView mLatestUpdate;
    private TextView mFan;
    private TextView mRetentionRatio;
    private TextView mSerializeWordCount;
    private TagGroup mTag;
    private TextView mShortIntro;
    private SearchResults.BooksBean booksBean;
    private ImageView mBack;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        //接收对象
        Intent intent = this.getIntent();
        String data =  intent.getStringExtra(Const.BOOKSBEAN);
        System.out.println("123" + data);
        booksBean = new Gson().fromJson(data, SearchResults.BooksBean.class);
        presenter = new BookDetailPresenter(this);
        presenter.start();
    }

    @Override
    public void initView() {
        //返回图标
        mBack = findViewById(R.id.tvBookDetailBack);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //封面
        mCover = findViewById(R.id.ivBookDetailBookCover);
        GlideApp
                .with(this)
                .load(Const.IMG_BASE_URL+booksBean.getCover())
                .placeholder(R.drawable.cover_default)
                .error(R.drawable.cover_default)
                .into(mCover);
        //书籍标题
        mTitle = findViewById(R.id.tvBookDetailBookTitle);
        mTitle.setText(booksBean.getTitle());

        //作者
        mAuthor = findViewById(R.id.tvBookDetailAuthor);
        String tmp = booksBean.getAuthor() + " | ";
        mAuthor.setText(tmp);

        //分类
        mCategory = findViewById(R.id.tvBookDetailCategory);
        tmp = booksBean.getCat()+" | ";
        mCategory.setText(tmp);

        //总字数
        mWordcount = findViewById(R.id.tvBookDetailWordCount);
        tmp = ""+booksBean.getWordCount();
        mWordcount.setText(tmp);

        //最近更新章节
        mLatestUpdate = findViewById(R.id.tvBookDetailLatelyUpdate);
        mLatestUpdate.setText(booksBean.getLastChapter());

        //追书人数
        mFan = findViewById(R.id.tvBookDetailLatelyFollower);
        tmp = "" + booksBean.getLatelyFollower();
        mFan.setText(tmp);

        //留存率
        mRetentionRatio = findViewById(R.id.tvBookDetailRetentionRatio);
        tmp = booksBean.getRetentionRatio()+" %";
        mRetentionRatio.setText(tmp);

        //日更新总数
        mSerializeWordCount = findViewById(R.id.tvBookDetailSerializeWordCount);

        //标签
        mTag = findViewById(R.id.tgBookDetail);
        mView = findViewById(R.id.BookDetailView);
        List<String> list = booksBean.getHighlight().getTitle();
        if (list != null && list.size()!=0) {
            mTag.setTags(list);
            mView.setVisibility(View.VISIBLE);
        }else {
            mView.setVisibility(View.GONE);
        }

        //简介
        mShortIntro = findViewById(R.id.tvBookDetailShortIntro);
        mShortIntro.setText(booksBean.getShortIntro());
    }
}
