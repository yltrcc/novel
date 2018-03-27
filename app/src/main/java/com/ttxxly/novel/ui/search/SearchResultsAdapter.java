package com.ttxxly.novel.ui.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttxxly.novel.GlideApp;
import com.ttxxly.novel.R;
import com.ttxxly.novel.entity.Const;
import com.ttxxly.novel.entity.SearchResults;

/**
 * description: 搜索结果数据适配器
 *
 * @author  ttxxly
 * @date 2018-3-14 17:44:02
 * mail ttxxly@gmail.com
 */
public class SearchResultsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SearchResults searchResults;
    private Context context;
    private OnItemClickListener mOnItemClickListener = null;

    SearchResultsAdapter(Context context, SearchResults searchResults) {
        this.searchResults = searchResults;
        this.context = context;
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_result_list, parent,
                false);
        return new SearchResultsHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SearchResultsAdapter.SearchResultsHolder searchResultsHolder = (SearchResultsHolder) holder;
        //绑定数据
        searchResultsHolder.mBookTitle.setText(searchResults.getBooks().get(position).getTitle());
        searchResultsHolder.mAuthor.setText(searchResults.getBooks().get(position).getAuthor()
            + "著");
        searchResultsHolder.mRetentionRatio.setText(searchResults.getBooks().get(position).getRetentionRatio()
            +"%读者留存 | ");
        searchResultsHolder.mFollower.setText(searchResults.getBooks().get(position).getLatelyFollower()
        + "人在追 | ");
        //封面
        GlideApp
                .with(context)
                .load(Const.IMG_BASE_URL + searchResults.getBooks().get(position).getCover())
                .placeholder(R.drawable.cover_default)
                .error(R.drawable.cover_default)
                .into( searchResultsHolder.mCover);

    }

    @Override
    public int getItemCount() {
        return searchResults.getBooks().size();
    }


    class SearchResultsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mCover;
        private final TextView mBookTitle;
        private final TextView mFollower;
        private final TextView mRetentionRatio;
        private final TextView mAuthor;

        SearchResultsHolder(View itemView) {
            super(itemView);
            mCover = itemView.findViewById(R.id.ivSearchResultsBookCover);
            mBookTitle = itemView.findViewById(R.id.tvSearchResultsBookListTitle);
            mFollower = itemView.findViewById(R.id.tvSearchResultsLatelyFollower);
            mRetentionRatio = itemView.findViewById(R.id.tvSearchResultsRetentionRatio);
            mAuthor = itemView.findViewById(R.id.tvSearchResultsBookListAuthor);
            //这里设置哪些控件是需要点击的，然后根据 view.getId() 来判断你点击了Item中的哪个控件
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    public void clear(){
        searchResults.setTotal(0);
    }
}
