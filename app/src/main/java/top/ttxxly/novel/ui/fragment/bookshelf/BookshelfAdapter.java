package top.ttxxly.novel.ui.fragment.bookshelf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import top.ttxxly.novel.R;
import top.ttxxly.novel.entity.MyBooks;

/**
 * Created by Administrator on 2/26/2018.
 */

public class BookshelfAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MyBooks myBooks;
    private ViewGroup mContainer = null;
    private OnItemClickListener mOnItemClickListener = null;

    public BookshelfAdapter(MyBooks myBooks, ViewGroup container) {
        this.myBooks = myBooks;
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

        booksHolder.title.setText(myBooks.getBooks().get(position).getBookTitle());
        booksHolder.author.setText(myBooks.getBooks().get(position).getAuthor());
        booksHolder.latestChapter.setText(myBooks.getBooks().get(position).getReadChapterTitle());
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
        return myBooks.getTotal();
    }
}
