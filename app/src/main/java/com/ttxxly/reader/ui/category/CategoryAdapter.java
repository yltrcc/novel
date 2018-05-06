package com.ttxxly.reader.ui.category;

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
import com.ttxxly.reader.entity.CategoryList;
import com.ttxxly.reader.entity.Const;
import com.ttxxly.reader.entity.HotResults;


/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-05
 * mail ttxxly@gmail.com
 */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private CategoryList categoryList;

    CategoryAdapter(Context mContext, CategoryList categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_top_category_list, parent,
                false);
        return new HotResultsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotResultsHolder hotResultsHolder = (HotResultsHolder) holder;
        //填充数据
        hotResultsHolder.mName.setText(categoryList.getMale().get(position).getName());
        hotResultsHolder.mBookCount.setText(categoryList.getMale().get(position).getBookCount()+"本");
    }

    class HotResultsHolder extends RecyclerView.ViewHolder  {

        private final TextView mName;
        private final TextView mBookCount;


        HotResultsHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tvName);
            mBookCount = itemView.findViewById(R.id.tvBookCount);
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.getFemale().size();
    }
}
