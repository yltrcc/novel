package com.ttxxly.reader.ui.rank;

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
import com.ttxxly.reader.entity.HotResults;
import com.ttxxly.reader.entity.RankingList;


/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class RankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private RankingList rankingList;

    RankAdapter(Context mContext, RankingList rankingList) {
        this.mContext = mContext;
        this.rankingList = rankingList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_top_rank_group, parent,
                false);
        return new HotResultsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotResultsHolder hotResultsHolder = (HotResultsHolder) holder;
        //填充数据
        hotResultsHolder.tvRankGroupName.setText(rankingList
        .getMale().get(position).getShortTitle());
        GlideApp.with(mContext)
                .load(Const.IMG_BASE_URL +
                        rankingList.getMale().get(position)
                                .getCover())
                .placeholder(R.drawable.cover_default)
                .error(R.drawable.cover_default)
                .into( hotResultsHolder.mCover);
    }

    class HotResultsHolder extends RecyclerView.ViewHolder  {

        private final ImageView mCover;

        private final TextView tvRankGroupName;

        HotResultsHolder(View itemView) {
            super(itemView);
            mCover = itemView.findViewById(R.id.ivRankCover);
            tvRankGroupName = itemView.findViewById(R.id.tvRankGroupName);
        }
    }

    @Override
    public int getItemCount() {
        return rankingList.getMale().size();
    }
}
