package com.ttxxly.novel.ui.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
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

import com.google.gson.Gson;
import com.ttxxly.novel.R;
import com.ttxxly.novel.entity.Const;
import com.ttxxly.novel.entity.SearchHistory;
import com.ttxxly.novel.entity.SearchResults;

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
    private SearchHistoryAdapter searchHistoryAdapter;
    /**
     * 保存搜索历史记录
     */
    private SearchHistory searchHistory;
    private SharedPreferences sp;
    private SearchResultsAdapter searchResultsAdapter;
    private TextView mClearSearchHistory;

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
        mClearSearchHistory = findViewById(R.id.TVSearchDeleteHistory);
        sp = getSharedPreferences(Const.SEARCH_HISTORY, 0);

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
                    //保存搜索历史记录
                    searchHistory.getSearchHistory().add(mETSearchContent.getText().toString());
                    //2、让setting处于编辑状态
                    SharedPreferences.Editor editor = sp.edit();
                    //3、存放数据
                    String tmp = new Gson().toJson(searchHistory);
                    System.out.println("dfsds"+tmp);
                    editor.putString(Const.HISTORY, tmp);
                    //4、完成提交
                    editor.apply();
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
        /**
         * 点击热词
         */
        mTagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                //热词标签点击操作
                mETSearchContent.setText(tag);
                hideHotWordAndSearchHistory();
                showSearchResults();
                //保存搜索历史记录
                searchHistory.getSearchHistory().add(tag);
                //2、让setting处于编辑状态
                SharedPreferences.Editor editor = sp.edit();
                //3、存放数据
                String tmp = new Gson().toJson(searchHistory);
                System.out.println("dfsds"+tmp);
                editor.putString(Const.HISTORY, tmp);
                //4、完成提交
                editor.apply();
                //关闭输入法
                hideInputMethod();
                //网络请求去获取搜索的结果
                presenter.getSearchResult(mETSearchContent.getText().toString());
            }
        });
        mClearSearchHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //删除真实数据
                searchHistory.getSearchHistory().clear();
                //更新 sp
                //2、让setting处于编辑状态
                SharedPreferences.Editor editor = sp.edit();
                //3、存放数据
                String tmp = new Gson().toJson(searchHistory);
                System.out.println("dfsds"+tmp);
                editor.putString(Const.HISTORY, tmp);
                //4、完成提交
                editor.apply();
                searchHistoryAdapter.notifyDataSetChanged();
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
    public void showSearchHistory(SearchHistory history) {
        this.searchHistory = history;
        Toast.makeText(this, "已经获取了搜索历史记录！！", Toast.LENGTH_SHORT).show();
        mRVSearchHistory.setLayoutManager(new LinearLayoutManager(this));
        searchHistoryAdapter = new SearchHistoryAdapter(this, searchHistory);
        mRVSearchHistory.setAdapter(searchHistoryAdapter);
        mRVSearchHistory.setItemAnimator(new DefaultItemAnimator());
        searchHistoryAdapter.setOnItemClickListener(new SearchHistoryAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.IVSearchHistoryItemClearContent:
                        Toast.makeText(SearchActivity.this, "您点击了第"+position+"个位置的删除图标", Toast.LENGTH_SHORT).show();
                        //删除真实数据
                        searchHistory.getSearchHistory().remove(position);
                        //更新 sp
                        //2、让setting处于编辑状态
                        SharedPreferences.Editor editor = sp.edit();
                        //3、存放数据
                        String tmp = new Gson().toJson(searchHistory);
                        System.out.println("dfsds"+tmp);
                        editor.putString(Const.HISTORY, tmp);
                        //4、完成提交
                        editor.apply();
                        searchHistoryAdapter.notifyItemRemoved(position);
                        searchHistoryAdapter.notifyDataSetChanged();
                        break;
                    default:
                        Toast.makeText(SearchActivity.this, "您点击了第"+position+"个位置！！", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public void showSearchResultList(SearchResults searchResults) {
        mRVSearchResultList.setLayoutManager(new LinearLayoutManager(this));
        searchResultsAdapter = new SearchResultsAdapter(this,searchResults);
        //清空以前的搜索记录
        mRVSearchResultList.setAdapter(searchResultsAdapter);
        searchResultsAdapter.setOnItemClickListener(new SearchResultsAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(SearchActivity.this, "您点击了第"+position+"个位置！！", Toast.LENGTH_SHORT).show();
            }
        });
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
        mRLSearchHotWords.setVisibility(View.GONE);
        mTagGroup.setVisibility(View.GONE);
        mRLSearchHistory.setVisibility(View.GONE);
        mRVSearchHistory.setVisibility(View.GONE);
    }

    private void showHotWordAndSearchHistory() {
        mRLSearchHotWords.setVisibility(View.VISIBLE);
        mRLSearchHistory.setVisibility(View.VISIBLE);
        mTagGroup.setVisibility(View.VISIBLE);
        mRVSearchHistory.setVisibility(View.VISIBLE);
    }

    private void hideSearchResults() {
        mRVSearchResultList.setVisibility(View.GONE);
    }

    private void showSearchResults() {
        mRVSearchResultList.setVisibility(View.VISIBLE);
    }

    /**
     * 显示输入法
     */
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

    /**
     * 隐藏输入法
     */
    private void hideInputMethod() {
        View view = getWindow().peekDecorView();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (view != null && imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }else {
            Toast.makeText(this, "无法隐藏输入法！！！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public SearchHistory getSearchHistory() {
        String history = sp.getString(Const.HISTORY, null);
        return new Gson().fromJson(history, SearchHistory.class);
    }

}
