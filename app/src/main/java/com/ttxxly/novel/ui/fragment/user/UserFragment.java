package com.ttxxly.novel.ui.fragment.user;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttxxly.novel.R;
import com.ttxxly.novel.base.BaseFragment;

public class UserFragment extends BaseFragment {

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);



        return view;
    }


}
