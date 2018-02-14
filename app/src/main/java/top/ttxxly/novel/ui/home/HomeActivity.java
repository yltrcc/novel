package top.ttxxly.novel.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import top.ttxxly.novel.R;
import top.ttxxly.novel.base.BaseFragment;
import top.ttxxly.novel.base.BaseViewPager;
import top.ttxxly.novel.ui.fragment.bookrack.BookrackFragment;
import top.ttxxly.novel.ui.fragment.fiction.FictionFragment;
import top.ttxxly.novel.ui.fragment.publication.PublicationFragment;
import top.ttxxly.novel.ui.fragment.user.UserFragment;

/**
 * @author ttxxly
 */
public class HomeActivity extends AppCompatActivity implements HomeContract.View{

    HomeContract.Presenter presenter = new HomePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter.start();
    }

    @Override
    public void initViewPager() {
        BaseViewPager viewPager = findViewById(R.id.vp_home);
        ArrayList<BaseFragment> list = new ArrayList<>();
        list.add(new BookrackFragment());
        list.add(new FictionFragment());
        list.add(new PublicationFragment());
        list.add(new UserFragment());
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), list));
    }
}
