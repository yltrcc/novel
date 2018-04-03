package com.ttxxly.reader.ui.fragment.publication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttxxly.reader.R;
import com.ttxxly.reader.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicationFragment extends BaseFragment {


    public PublicationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publication, container, false);
    }

}
