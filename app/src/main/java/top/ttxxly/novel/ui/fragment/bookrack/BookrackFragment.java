package top.ttxxly.novel.ui.fragment.bookrack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Method;

import top.ttxxly.novel.R;
import top.ttxxly.novel.base.BaseFragment;
import top.ttxxly.novel.entity.MyBooks;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookrackFragment extends BaseFragment implements BookrackContract.view{


    private ViewGroup mContainer;
    private RecyclerView rv_bookrack;
    private BookrackAdapter bookrackAdapter;

    public BookrackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContainer = container;
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bookrack, container, false);

        Toolbar mBookrackToolbar = view.findViewById(R.id.bookrack_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mBookrackToolbar);
        setHasOptionsMenu(true);

        rv_bookrack = view.findViewById(R.id.rv_bookrack);
        rv_bookrack.setLayoutManager(new LinearLayoutManager(container.getContext()));

        BookrackContract.presenter presenter = new BookrackPresenter(this);
        presenter.start();
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

    @Override
    public void init(MyBooks myBooks) {
        bookrackAdapter = new BookrackAdapter(myBooks, mContainer);
        rv_bookrack.setAdapter(bookrackAdapter);
    }

    @Override
    public void addDataSource() {

    }

    @Override
    public void getDataSource() {

    }

    @Override
    public void setDataSource() {

    }
}
