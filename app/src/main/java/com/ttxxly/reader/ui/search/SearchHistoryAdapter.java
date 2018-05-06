package com.ttxxly.reader.ui.search;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.SearchHistory;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-03-09
 * @mail ttxxly@gmail.com
 */

public class SearchHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context = null;
    private SearchHistory searchHistory;
    private OnItemClickListener mOnItemClickListener = null;

    SearchHistoryAdapter(Context context, SearchHistory searchHistory) {
        this.context = context;
        searchHistory.setSearchHistory(removeStringListDupli(searchHistory.getSearchHistory()));
        searchHistory.setTotal(searchHistory.getSearchHistory().size());
        this.searchHistory = searchHistory;
    }


    void setOnItemClickListener(SearchHistoryAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_history, parent,
                false);
        return new SearchHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SearchHistoryAdapter.SearchHistoryHolder searchHistoryHolder = (SearchHistoryHolder) holder;
        //绑定数据
        searchHistoryHolder.mTitle.setText(searchHistory.getSearchHistory().get(position));
    }

    @Override
    public int getItemCount() {
        return searchHistory.getSearchHistory().size();
    }


    class SearchHistoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private final TextView mTitle;
        private final ImageView mClearHistory;

        SearchHistoryHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.TVSearchHistoryItemContent);
            mClearHistory = itemView.findViewById(R.id.IVSearchHistoryItemClearContent);
            //这里设置哪些控件是需要点击的，然后根据 view.getId() 来判断你点击了Item中的哪个控件
            itemView.setOnClickListener(this);
            mClearHistory.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    /**
     * 去除重复数据
     */
    public List<String> removeStringListDupli(List<String> stringList) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(stringList);

        stringList.clear();

        stringList.addAll(set);
        return stringList;
    }
}
