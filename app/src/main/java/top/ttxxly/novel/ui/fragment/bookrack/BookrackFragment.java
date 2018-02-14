package top.ttxxly.novel.ui.fragment.bookrack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import top.ttxxly.novel.R;
import top.ttxxly.novel.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookrackFragment extends BaseFragment {


    public BookrackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bookrack, container, false);

        Toolbar mBookrackToolbar = view.findViewById(R.id.bookrack_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mBookrackToolbar);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.bookrackmenu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_bookrack_edit:
                //TODO search
                break;
            case R.id.menu_bookrack_research:
                //TODO search
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
