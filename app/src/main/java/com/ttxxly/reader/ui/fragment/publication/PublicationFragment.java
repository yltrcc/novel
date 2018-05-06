package com.ttxxly.reader.ui.fragment.publication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.base.BaseFragment;
import com.ttxxly.reader.entity.Publication;
import com.ttxxly.reader.ui.search.SearchActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicationFragment extends BaseFragment implements PublicationContract.View{

    private ViewGroup mContainer;
    private View view;
    private RecyclerView mRv;

    public PublicationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_publication, container, false);
        mContainer = container;

        PublicationContract.Presenter presenter = new PublicationPresenter(this);
        presenter.start();

        return view;
    }

    @Override
    public void init() {
        //设置Android RecycleView
        mRv = view.findViewById(R.id.rv_fragment_publication);
        mRv.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));

        //设置搜索
        ImageView mSearch = view.findViewById(R.id.iv_publication_search);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });
    }

    @Override
    public void showContent(Publication publication) {

        PublicationAdapter publicationAdapter = new PublicationAdapter(publication, mContainer);
        mRv.setAdapter(publicationAdapter);

    }
}
