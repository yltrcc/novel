package com.ttxxly.reader.ui.bookdetail;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ttxxly.reader.GlideApp;
import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.BookDetail;
import com.ttxxly.reader.entity.Bookshelf;
import com.ttxxly.reader.entity.Const;
import com.ttxxly.reader.entity.SearchResults;
import com.ttxxly.reader.ui.read.ReadActivity;
import com.ttxxly.reader.utils.FileUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    private Button mStartRead;
    private Button mJoinBookshelf;

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

        //开始阅读
        mStartRead = findViewById(R.id.btnBookDetailStartRead);
        mStartRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookDetailActivity.this, ReadActivity.class);
                intent.putExtra(Const.BOOKID, booksBean.get_id());
                intent.putExtra(Const.CURRENT_CHAPTER, 1);
                startActivity(intent);
            }
        });

        //加入书架
        mJoinBookshelf = findViewById(R.id.btnBookDetailJoinBookshelf);
        mJoinBookshelf.setOnClickListener(new View.OnClickListener() {

            private Bookshelf mDefaultBookshelf;

            @Override
            public void onClick(View v) {
                //判断 用户登录状态
                //1.1、获取Preferences
                SharedPreferences settings = getSharedPreferences(Const.USER_INFO, 0);
                //1.2、取出数据
                Boolean mLoginStatus = settings.getBoolean(Const.LOGIN_STATUS, false);
                if ( !mLoginStatus ) {
                    //加载默认书架
                    mDefaultBookshelf = getBookShelf(Const.DEFAULT_BOOKSHELF);
                    //判断是否为空
                    if ( mDefaultBookshelf == null ) {
                        Bookshelf.BooksBean book = new Bookshelf.BooksBean();
                        book.setAuthor(booksBean.getAuthor());
                        book.setBookId(booksBean.get_id());
                        book.setBookTitle(booksBean.getTitle());
                        book.setChaptersCount(booksBean.getWordCount());
                        book.setCover(booksBean.getCover());
                        book.setLatestChapter(booksBean.getLastChapter());
                        List<Bookshelf.BooksBean> books = new ArrayList<>();
                        books.add(book);
                        mDefaultBookshelf = new Bookshelf();
                        mDefaultBookshelf.setBooks(books);
                        FileUtils.setFileContent(Const.DEFAULT_BOOKSHELF, new Gson().toJson(mDefaultBookshelf), BookDetailActivity.this);
                        mJoinBookshelf.setText("已加入");
                        Toast.makeText(BookDetailActivity.this, "书籍已加入书架中", Toast.LENGTH_SHORT).show();
                    }else {
                        List<Bookshelf.BooksBean> books = mDefaultBookshelf.getBooks();
                        if (!isInBookShelf(booksBean.get_id(), books)) {
                            Bookshelf.BooksBean book = new Bookshelf.BooksBean();
                            book.setAuthor(booksBean.getAuthor());
                            book.setBookId(booksBean.get_id());
                            book.setBookTitle(booksBean.getTitle());
                            book.setChaptersCount(booksBean.getWordCount());
                            book.setCover(booksBean.getCover());
                            book.setLatestChapter(booksBean.getLastChapter());
                            books.add(book);
                            mDefaultBookshelf.setBooks(books);
                            FileUtils.setFileContent(Const.DEFAULT_BOOKSHELF, new Gson().toJson(mDefaultBookshelf), BookDetailActivity.this);
                        }
                        mJoinBookshelf.setText("已加入");
                        Toast.makeText(BookDetailActivity.this, "书籍已加入书架中", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(BookDetailActivity.this, "书籍已加入书架中", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /**
     * 根据 文件名 读取数据
     * @param fileName 文件名
     */
    private Bookshelf getBookShelf(String fileName){
        String jsonString = FileUtils.getFileContent(fileName, this);
        System.out.println("书架数据：" + jsonString);
        
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Bookshelf.class);
    }

    private boolean isInBookShelf(String bookId, List<Bookshelf.BooksBean> list) {
        int total = list.size();
        for(int i=0; i<total; i++) {
            if (bookId.equals(list.get(i).getBookId())) {
                return true;
            }
        }
        return false;
    }
}
