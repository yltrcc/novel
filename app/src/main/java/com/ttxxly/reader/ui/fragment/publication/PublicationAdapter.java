package com.ttxxly.reader.ui.fragment.publication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ttxxly.reader.GlideApp;
import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.Const;
import com.ttxxly.reader.entity.Publication;
import com.ttxxly.reader.ui.category.CategoryActivity;
import com.ttxxly.reader.ui.finish.FinishActivity;
import com.ttxxly.reader.ui.hot.HotActivity;
import com.ttxxly.reader.ui.rank.RankActivity;
import com.ttxxly.reader.ui.selection.SelectionActivity;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-04
 * mail ttxxly@gmail.com
 */
public class PublicationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener mOnItemClickListener = null;
    private Publication publication;
    private ViewGroup mContainer;

    private static int TYPE_CONTENT = 0;
    private static int TYPE_HEADER = 1;

    /**
     * 点击事件相关
     * @param onItemClickListener
     */
    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    /**
     * 点击事件接口
     */
    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    PublicationAdapter(Publication publication, ViewGroup mContainer){
        this.publication = publication;
        this.mContainer = mContainer;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if (viewType == TYPE_CONTENT) {
            View view = LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_library_arrange1, parent,
                    false);
            return new WithContentHolder(view);
        }else if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_library_header, parent,
                    false);
            return new HeaderHolder(view);
        }else {
           View view = LayoutInflater.from(
                   mContainer.getContext()).inflate(R.layout.item_library_header, parent,
                   false);
           return new HeaderHolder(view);
       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Log.i("position" + position, "eetetete" );
        if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            headerHolder.mHot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Hot",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), HotActivity.class);
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mFinish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Finish",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), FinishActivity.class);
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mRank.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Rank",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), RankActivity.class);
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Category",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                    intent.putExtra("title", "Category");
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mSelection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Selection",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), SelectionActivity.class);
                    mContainer.getContext().startActivity(intent);
                }
            });
        }else if (holder instanceof WithContentHolder) {
            WithContentHolder withContentHolder = (WithContentHolder) holder;
            //标题
            withContentHolder.title.
                    setText("--  "+publication.
                            getPublicationBean()
                            .get(position-1)
                            .getmTitle()+"  --");
            withContentHolder.tvBookTitle1.setText(
                    publication.getPublicationBean().get(position-1).getBooksByCats()
                    .getBooks().get(0).getTitle()
            );
            withContentHolder.tvBookTitle2.setText(
                    publication.getPublicationBean().get(position-1).getBooksByCats()
                            .getBooks().get(1).getTitle()
            );
            withContentHolder.tvBookTitle3.setText(
                    publication.getPublicationBean().get(position-1).getBooksByCats()
                            .getBooks().get(2).getTitle()
            );
            withContentHolder.tvBookTitle4.setText(
                    publication.getPublicationBean().get(position-1).getBooksByCats()
                            .getBooks().get(3).getTitle()
            );
            withContentHolder.tvBookTitle5.setText(
                    publication.getPublicationBean().get(position-1).getBooksByCats()
                            .getBooks().get(4).getTitle()
            );
            //封面
            GlideApp
                    .with(mContainer)
                    .load(Const.IMG_BASE_URL + publication
                            .getPublicationBean()
                            .get(position-1)
                            .getBooksByCats()
                            .getBooks()
                            .get(0).getCover())
                    .placeholder(R.drawable.cover_default)
                    .error(R.drawable.cover_default)
                    .into( withContentHolder.ivBookCover1);
            GlideApp
                    .with(mContainer)
                    .load(Const.IMG_BASE_URL + publication
                            .getPublicationBean()
                            .get(position-1)
                            .getBooksByCats()
                            .getBooks()
                            .get(1).getCover())
                    .placeholder(R.drawable.cover_default)
                    .error(R.drawable.cover_default)
                    .into( withContentHolder.ivBookCover2);
            GlideApp
                    .with(mContainer)
                    .load(Const.IMG_BASE_URL + publication
                            .getPublicationBean()
                            .get(position-1)
                            .getBooksByCats()
                            .getBooks()
                            .get(2).getCover())
                    .placeholder(R.drawable.cover_default)
                    .error(R.drawable.cover_default)
                    .into( withContentHolder.ivBookCover3);
            GlideApp
                    .with(mContainer)
                    .load(Const.IMG_BASE_URL + publication
                            .getPublicationBean()
                            .get(position-1)
                            .getBooksByCats()
                            .getBooks()
                            .get(3).getCover())
                    .placeholder(R.drawable.cover_default)
                    .error(R.drawable.cover_default)
                    .into( withContentHolder.ivBookCover4);
            GlideApp
                    .with(mContainer)
                    .load(Const.IMG_BASE_URL + publication
                            .getPublicationBean()
                            .get(position-1)
                            .getBooksByCats()
                            .getBooks()
                            .get(4).getCover())
                    .placeholder(R.drawable.cover_default)
                    .error(R.drawable.cover_default)
                    .into( withContentHolder.ivBookCover5);
            //作者
            withContentHolder.tvBookAuthor1.setText(publication
                    .getPublicationBean()
                    .get(position-1)
                    .getBooksByCats()
                    .getBooks()
                    .get(0)
                    .getAuthor()+"著"
            );
            withContentHolder.tvBookAuthor2.setText(publication
                    .getPublicationBean()
                    .get(position-1)
                    .getBooksByCats()
                    .getBooks()
                    .get(1)
                    .getAuthor()
            );
            withContentHolder.tvBookAuthor3.setText(publication
                    .getPublicationBean()
                    .get(position-1)
                    .getBooksByCats()
                    .getBooks()
                    .get(2)
                    .getAuthor()
            );
            withContentHolder.tvBookAuthor4.setText(publication
                    .getPublicationBean()
                    .get(position-1)
                    .getBooksByCats()
                    .getBooks()
                    .get(3)
                    .getAuthor()
            );
            withContentHolder.tvBookAuthor5.setText(publication
                    .getPublicationBean()
                    .get(position-1)
                    .getBooksByCats()
                    .getBooks()
                    .get(4)
                    .getAuthor()
            );

            //点击事件
            withContentHolder.rlBook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "点击了rlBook1"+position+"位置", Toast.LENGTH_SHORT).show();
                }
            });
            withContentHolder.rlBook2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "点击了rlBook2"+position+"位置", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private class WithContentHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RelativeLayout rlBook1;
        private final LinearLayout rlBook2;
        private final LinearLayout rlBook3;
        private final LinearLayout rlBook4;
        private final LinearLayout rlBook5;
        private final TextView tvBookTitle1;
        private final TextView tvBookTitle2;
        private final TextView tvBookTitle3;
        private final TextView tvBookTitle4;
        private final TextView tvBookTitle5;
        private final TextView tvsLatelyFollower1;
        private final TextView tvRetentionRatio1;
        private final TextView tvBookAuthor1;
        private final TextView tvBookAuthor2;
        private final TextView tvBookAuthor3;
        private final TextView tvBookAuthor4;
        private final TextView tvBookAuthor5;
        private final ImageView ivBookCover1;
        private final ImageView ivBookCover2;
        private final ImageView ivBookCover3;
        private final ImageView ivBookCover4;
        private final ImageView ivBookCover5;


        private WithContentHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item_title);
            rlBook1 = itemView.findViewById(R.id.RLBook1);
            rlBook2 = itemView.findViewById(R.id.RLBook2);
            rlBook3 = itemView.findViewById(R.id.RLBook3);
            rlBook4 = itemView.findViewById(R.id.RLBook4);
            rlBook5 = itemView.findViewById(R.id.RLBook5);
            tvBookTitle1 = itemView.findViewById(R.id.tvBookTitle1);
            tvBookTitle2 = itemView.findViewById(R.id.tvBookTitle2);
            tvBookTitle3 = itemView.findViewById(R.id.tvBookTitle3);
            tvBookTitle4 = itemView.findViewById(R.id.tvBookTitle4);
            tvBookTitle5 = itemView.findViewById(R.id.tvBookTitle5);
            tvsLatelyFollower1 = itemView.findViewById(R.id.tvsLatelyFollower1);
            tvRetentionRatio1 = itemView.findViewById(R.id.tvRetentionRatio1);
            tvBookAuthor1 = itemView.findViewById(R.id.tvBookAuthor1);
            tvBookAuthor2 = itemView.findViewById(R.id.tvBookAuthor2);
            tvBookAuthor3 = itemView.findViewById(R.id.tvBookAuthor3);
            tvBookAuthor4 = itemView.findViewById(R.id.tvBookAuthor4);
            tvBookAuthor5 = itemView.findViewById(R.id.tvBookAuthor5);
            ivBookCover1 = itemView.findViewById(R.id.ivBookCover1);
            ivBookCover2 = itemView.findViewById(R.id.ivBookCover2);
            ivBookCover3 = itemView.findViewById(R.id.ivBookCover3);
            ivBookCover4 = itemView.findViewById(R.id.ivBookCover4);
            ivBookCover5 = itemView.findViewById(R.id.ivBookCover5);
        }
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {

        private final LinearLayout mHot;
        private final LinearLayout mFinish;
        private final LinearLayout mRank;
        private final LinearLayout mCategory;
        private final LinearLayout mSelection;

        private HeaderHolder(View itemView) {
            super(itemView);
            mHot = itemView.findViewById(R.id.ll_item_hot);
            mFinish = itemView.findViewById(R.id.ll_item_finish);
            mRank = itemView.findViewById(R.id.ll_item_rank);
            mCategory = itemView.findViewById(R.id.ll_item_category);
            mSelection = itemView.findViewById(R.id.ll_item_selection);
        }
    }

    @Override
    public int getItemCount() {
        return publication.publicationBean.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }else {
            return TYPE_CONTENT;
        }
    }
}
