package top.ttxxly.novel.ui.fragment.fiction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.ttxxly.novel.R;
import top.ttxxly.novel.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FictionFragment extends BaseFragment {


    public FictionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fiction, container, false);
    }

}
