package com.ttxxly.reader.ui.selection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttxxly.reader.GlideApp;
import com.ttxxly.reader.R;
import com.ttxxly.reader.entity.Const;
import com.ttxxly.reader.entity.FinishResults;
import com.ttxxly.reader.entity.SelectionResults;


/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class SelectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private SelectionResults selectionResults;

    SelectionAdapter(Context mContext, SelectionResults selectionResults) {
        this.mContext = mContext;
        this.selectionResults = selectionResults;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_selection_list, parent,
                false);
        return new HotResultsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotResultsHolder hotResultsHolder = (HotResultsHolder) holder;
        //填充数据
        hotResultsHolder.mBookTitle.setText(selectionResults
                .getBooks().get(position)
                .getTitle());
        hotResultsHolder.mFollower.setText(selectionResults
                .getBooks().get(position)
                .getLatelyFollower()+"人在追 | ");
        hotResultsHolder.mAuthor.setText(selectionResults.getBooks().get(position).getAuthor()
                + "著");
        hotResultsHolder.mRetentionRatio.setText(selectionResults.getBooks().get(position).getRetentionRatio()
                +"%读者留存 | ");
        GlideApp.with(mContext)
                .load(Const.IMG_BASE_URL +
                        selectionResults.getBooks().get(position).getCover())
                .placeholder(R.drawable.cover_default)
                .error(R.drawable.cover_default)
                .into( hotResultsHolder.mCover);
    }

    class HotResultsHolder extends RecyclerView.ViewHolder  {

        private final ImageView mCover;
        private final TextView mBookTitle;
        private final TextView mFollower;
        private final TextView mRetentionRatio;
        private final TextView mAuthor;

        HotResultsHolder(View itemView) {
            super(itemView);
            mCover = itemView.findViewById(R.id.ivSelectionBookCover);
            mBookTitle = itemView.findViewById(R.id.tvSelectionTitle);
            mFollower = itemView.findViewById(R.id.tvSelectionLatelyFollower);
            mRetentionRatio = itemView.findViewById(R.id.tvSelectionRetentionRatio);
            mAuthor = itemView.findViewById(R.id.tvSelectionAuthor);
        }
    }

    @Override
    public int getItemCount() {
        return selectionResults.getBooks().size();
    }
}
