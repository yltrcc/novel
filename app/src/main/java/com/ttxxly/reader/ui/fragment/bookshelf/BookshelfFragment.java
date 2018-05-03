package com.ttxxly.reader.ui.fragment.bookshelf;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ttxxly.reader.R;
import com.ttxxly.reader.base.BaseFragment;
import com.ttxxly.reader.entity.Bookshelf;
import com.ttxxly.reader.entity.Const;
import com.ttxxly.reader.ui.search.SearchActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookshelfFragment extends BaseFragment implements BookshelfContract.view {


    private ViewGroup mContainer;
    private RecyclerView rv_bookrack;
    private BookshelfAdapter bookrackAdapter;
    private RelativeLayout bookshelfEmpty;

    public BookshelfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContainer = container;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookshelf, container, false);

        Toolbar mBookrackToolbar = view.findViewById(R.id.bookrack_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mBookrackToolbar);
        setHasOptionsMenu(true);

        rv_bookrack = view.findViewById(R.id.rv_bookrack);
        rv_bookrack.setLayoutManager(new LinearLayoutManager(container.getContext()));

        bookshelfEmpty = view.findViewById(R.id.bookshelf_empty);
        container.getContext().getFilesDir();


        BookshelfContract.presenter presenter = new BookshelfPresenter(this, mContainer.getContext());
        presenter.start();
        return view;
    }

    /**
     * 创建  Toolbar 菜单
     *
     * @param menu
     * @param inflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.bookshelfmenu, menu);
    }

    /**
     * 选择 Toolbar 菜单，并做出相应的操作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_bookrack_edit:
                //TODO search
                break;
            case R.id.menu_bookrack_research:
                startActivity(new Intent(mContainer.getContext(), SearchActivity.class));

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 装配数据
     *
     * @param bookshelf
     */
    @Override
    public void init(Bookshelf bookshelf) {
        System.out.println("书架数据放松放松："+bookshelf.toString());
        bookrackAdapter = new BookshelfAdapter(bookshelf, mContainer);
        rv_bookrack.setAdapter(bookrackAdapter);
        bookshelfEmpty.setVisibility(View.GONE);
        rv_bookrack.setVisibility(View.VISIBLE);
    }


    @Override
    public void setEmptyView() {
        bookshelfEmpty.setVisibility(View.VISIBLE);
        rv_bookrack.setVisibility(View.GONE);
    }

    @Override
    public Boolean getLoginStatus() {
        SharedPreferences sp = mContainer.getContext().getSharedPreferences(Const.USER_INFO, 0);
        return sp.getBoolean(Const.LOGIN_STATUS, false);
    }

    @Override
    public int getUserId() {
        SharedPreferences sp = mContainer.getContext().getSharedPreferences(Const.USER_INFO, 0);
        return sp.getInt(Const.USER_ID, -1);
    }
}
