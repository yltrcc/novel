package com.ttxxly.novel.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ttxxly.novel.R;
import com.ttxxly.novel.entity.SearchDetail;

import java.util.List;

import me.gujun.android.taggroup.TagGroup;

/**
 * description: 搜索页面
 *
 * @author ttxxly
 * @date 2018-3-3 15:12:28
 * @mail ttxxly@gmail.com
 */
public class SearchActivity extends AppCompatActivity implements SearchConract.View {

    private TagGroup mTagGroup;
    /**
     * 保存获取到的搜索热词
     */
    private List<String> mHotWords;
    private int hotIndex = 0;
    private ImageView mIVSearchBack;
    private EditText mETSearchContent;
    private ImageView mIVSearchClear;
    private RelativeLayout mRLSearchHotWords;
    private RelativeLayout mRLSearchHistory;
    private RecyclerView mRVSearchHistory;
    private RecyclerView mRVSearchResultList;
    private SearchConract.Presenter presenter;
    private TextView mTVSearchChangHotWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        presenter = new SearchPresenter(this);
        presenter.start();
    }

    @Override
    public void initView() {
        mIVSearchBack = findViewById(R.id.IVSearchBack);
        mETSearchContent = findViewById(R.id.ETSearchContent);
        mIVSearchClear = findViewById(R.id.IVSearchClear);
        mRLSearchHotWords = findViewById(R.id.RLSearchHotWords);
        mRLSearchHistory = findViewById(R.id.RLSearchHistory);
        mRVSearchHistory = findViewById(R.id.RVSearchHistory);
        mRVSearchResultList = findViewById(R.id.RVSearchResultList);
        mTVSearchChangHotWords = findViewById(R.id.TVSearchChangHotWords);

        //返回
        mIVSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //用户输入的内容
        mETSearchContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("搜索编辑框内容：" + s + start + before + count);
                if (s.length() != 0) {
                    mIVSearchClear.setVisibility(View.VISIBLE);
                } else {
                    mIVSearchClear.setVisibility(View.INVISIBLE);
                    hideSearchResults();
                    showHotWordAndSearchHistory();
                }
            }

            /**
             * 编辑框的内容改变以后,用户没有继续输入时 的回调方法
             */
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        /**
         * 软键盘 搜索 点击事件
         */
        mETSearchContent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND ||
                        (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    hideHotWordAndSearchHistory();
                    showSearchResults();
                    //获取输入的内容
                    System.out.println("输入的内容是："+mETSearchContent.getText().toString());
                    //关闭输入法
                    hideInputMethod();
                    //网络请求去获取搜索的结果
                    presenter.getSearchResult(mETSearchContent.getText().toString());
                    return true;
                }
                return false;
            }
        });
        /**
         * 清空用户输入的内容
         */
        mIVSearchClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mETSearchContent.setText("");
                //弹出输入法
                showInputMethod();
                showHotWordAndSearchHistory();
                hideSearchResults();
            }
        });
        /**
         * 换一批搜索热词
         */
        mTVSearchChangHotWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHotWord();
            }
        });
        mTagGroup = findViewById(R.id.TGSearch);
        mTagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                //热词标签点击操作
                mETSearchContent.setText(tag);
                hideHotWordAndSearchHistory();
                showSearchResults();

                //网络请求去获取搜索的结果
                presenter.getSearchResult(mETSearchContent.getText().toString());
            }
        });

    }

    @Override
    public void showHotWordList(List<String> list) {
        mHotWords = list;
        showHotWord();
    }

    @Override
    public void showAutoCompleteList(List<String> list) {

    }


    @Override
    public void showSearchResultList(List<SearchDetail.SearchBooks> list) {

    }

    /**
     * 每次随机显示8个热搜词
     */
    private synchronized void showHotWord() {
        int tagSize = 8;
        String[] tags = new String[tagSize];
        for (int j = 0; j < tagSize && j < mHotWords.size(); hotIndex++, j++) {
            tags[j] = mHotWords.get(hotIndex % mHotWords.size());
        }
        mTagGroup.setTags(tags);
    }

    private void hideHotWordAndSearchHistory() {
        mRLSearchHotWords.setVisibility(View.INVISIBLE);
        mTagGroup.setVisibility(View.INVISIBLE);
        mRLSearchHistory.setVisibility(View.INVISIBLE);
        mRVSearchHistory.setVisibility(View.INVISIBLE);
    }

    private void showHotWordAndSearchHistory() {
        mRLSearchHotWords.setVisibility(View.VISIBLE);
        mRLSearchHistory.setVisibility(View.VISIBLE);
        mTagGroup.setVisibility(View.VISIBLE);
        mTagGroup.setVisibility(View.VISIBLE);
    }

    private void hideSearchResults() {
        mRVSearchResultList.setVisibility(View.INVISIBLE);
    }

    private void showSearchResults() {
        mRVSearchResultList.setVisibility(View.VISIBLE);
    }

    private void showInputMethod() {
        boolean isShow = false;
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        if ( imm != null ) {
            while ( !isShow ) {
                imm.showSoftInput(mETSearchContent, 0);
                if (imm.isActive()) {
                    isShow = true;
                }
            }
        }else {
            Toast.makeText(this, "无法弹出输入法！！", Toast.LENGTH_SHORT).show();
        }
    }

    private void hideInputMethod() {
        View view = getWindow().peekDecorView();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (view != null && imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }else {
            Toast.makeText(this, "无法隐藏输入法！！！", Toast.LENGTH_SHORT).show();
        }
    }

}
