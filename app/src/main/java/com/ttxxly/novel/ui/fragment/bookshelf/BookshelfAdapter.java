package com.ttxxly.novel.ui.fragment.bookshelf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttxxly.novel.R;
import com.ttxxly.novel.entity.Bookshelf;

/**
 * Created by Administrator on 2/26/2018.
 */

public class BookshelfAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Bookshelf Bookshelf;
    private ViewGroup mContainer = null;
    private OnItemClickListener mOnItemClickListener = null;

    public BookshelfAdapter(Bookshelf Bookshelf, ViewGroup container) {
        this.Bookshelf = Bookshelf;
        mContainer = container;
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                mContainer.getContext()).inflate(R.layout.item_bookshelf, parent,
                false);
        return new BooksHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BooksHolder booksHolder = (BooksHolder) holder;
        //绑定数据

        booksHolder.title.setText(Bookshelf.getBooks().get(position).getBookTitle());
        booksHolder.author.setText(Bookshelf.getBooks().get(position).getAuthor());
        booksHolder.latestChapter.setText(Bookshelf.getBooks().get(position).getReadChapterTitle());
    }

    class BooksHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private final TextView title;
        private final TextView author;
        private final TextView latestChapter;
        private final ImageView cover;

        BooksHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvBookrackBookTitle);
            author = itemView.findViewById(R.id.tvBookrackBookAuthor);
            latestChapter = itemView.findViewById(R.id.tvBookrackBookShort);
            cover = itemView.findViewById(R.id.ivBookrackBookCover);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    /**
     * 获取书架上的书籍总数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return Bookshelf.getTotal();
    }
}
