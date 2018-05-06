package com.ttxxly.reader.ui.fragment.fiction;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ttxxly.reader.R;
import com.ttxxly.reader.base.BaseFragment;
import com.ttxxly.reader.entity.Publication;
import com.ttxxly.reader.ui.fragment.publication.PublicationAdapter;
import com.ttxxly.reader.ui.fragment.publication.PublicationContract;
import com.ttxxly.reader.ui.fragment.publication.PublicationPresenter;
import com.ttxxly.reader.ui.search.SearchActivity;

import java.lang.invoke.MutableCallSite;

/**
 * A simple {@link Fragment} subclass.
 */
public class FictionFragment extends BaseFragment implements FictionContract.View{


    private View view;
    ViewGroup  mContainer;
    private RecyclerView mRv;

    public FictionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fiction, container, false);
        mContainer = container;

        FictionContract.Presenter presenter = new FictionPresenter(this);
        presenter.start();

        return view;
    }

    @Override
    public void init() {
        //设置Android RecycleView
        mRv = view.findViewById(R.id.rv_fragment_fiction);
        mRv.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));

        //设置搜索
        ImageView mSearch = view.findViewById(R.id.iv_fiction_search);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });
    }

    @Override
    public void showContent(Publication publication) {
        FictionAdapter fictionAdapter = new FictionAdapter(publication, mContainer);
        mRv.setAdapter(fictionAdapter);
    }
}
