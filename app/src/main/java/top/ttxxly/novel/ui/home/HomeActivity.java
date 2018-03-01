package top.ttxxly.novel.ui.home;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import top.ttxxly.novel.R;
import top.ttxxly.novel.base.BaseFragment;
import top.ttxxly.novel.base.BaseViewPager;
import top.ttxxly.novel.ui.fragment.bookshelf.BookshelfFragment;
import top.ttxxly.novel.ui.fragment.fiction.FictionFragment;
import top.ttxxly.novel.ui.fragment.publication.PublicationFragment;
import top.ttxxly.novel.ui.fragment.user.UserFragment;

/**
 * @author ttxxly
 */
public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    HomeContract.Presenter presenter = new HomePresenter(this);
    private ImageView mIvBookshelf;
    private ImageView mIvPublication;
    private ImageView mIvFiction;
    private ImageView mIvUser;
    private TextView mTvBookshelf;
    private TextView mTvPublication;
    private TextView mTvFiction;
    private TextView mTvUser;
    private RelativeLayout mRvBookshelf;
    private RelativeLayout mRvPublication;
    private RelativeLayout mRvFiction;
    private RelativeLayout mRvUser;
    private BaseViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        mRvBookshelf = findViewById(R.id.rv_bookshelf);
        mRvPublication = findViewById(R.id.rv_publication);
        mRvFiction = findViewById(R.id.rv_fiction);
        mRvUser = findViewById(R.id.rv_user);

        mIvBookshelf = findViewById(R.id.iv_bookshelf);
        mIvPublication = findViewById(R.id.iv_Publication);
        mIvFiction = findViewById(R.id.iv_fiction);
        mIvUser = findViewById(R.id.iv_user);
        mTvBookshelf = findViewById(R.id.tv_bookshelf);
        mTvPublication = findViewById(R.id.tv_Publication);
        mTvFiction = findViewById(R.id.tv_fiction);
        mTvUser = findViewById(R.id.tv_user);


        init();

        presenter.start();
    }

    @Override
    public void initViewPager() {
        viewPager = findViewById(R.id.vp_home);
        ArrayList<BaseFragment> list = new ArrayList<>();
        list.add(new BookshelfFragment());
        list.add(new PublicationFragment());
        list.add(new FictionFragment());
        list.add(new UserFragment());
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), list));
    }

    private void init() {
        clearColor();
        mIvBookshelf.setImageResource(R.drawable.bookshelf_red);
        mTvBookshelf.setTextColor(getResources().getColor(R.color.selectedRed));

        mRvBookshelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                mIvBookshelf.setImageResource(R.drawable.bookshelf_red);
                mTvBookshelf.setTextColor(getResources().getColor(R.color.selectedRed));
                viewPager.setCurrentItem(0);
            }
        });
        mRvPublication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                mIvPublication.setImageResource(R.drawable.publication_red);
                mTvPublication.setTextColor(getResources().getColor(R.color.selectedRed));
                viewPager.setCurrentItem(1);
            }
        });
        mRvFiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                mIvFiction.setImageResource(R.drawable.fiction_red);
                mTvFiction.setTextColor(getResources().getColor(R.color.selectedRed));
                viewPager.setCurrentItem(2);
            }
        });
        mRvUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearColor();
                mIvUser.setImageResource(R.drawable.user_red);
                mTvUser.setTextColor(getResources().getColor(R.color.selectedRed));
                viewPager.setCurrentItem(3);
            }
        });

    }

    /**
     * 将底部导航栏的颜色设置为黑色
     */
    private void clearColor() {
        mIvBookshelf.setImageResource(R.drawable.bookshelf_black);
        mIvPublication.setImageResource(R.drawable.publication_black);
        mIvFiction.setImageResource(R.drawable.fiction_black);
        mIvUser.setImageResource(R.drawable.user_black);

        mTvBookshelf.setTextColor(getResources().getColor(R.color.selectedBlack));
        mTvPublication.setTextColor(getResources().getColor(R.color.selectedBlack));
        mTvFiction.setTextColor(getResources().getColor(R.color.selectedBlack));
        mTvUser.setTextColor(getResources().getColor(R.color.selectedBlack));
    }
}
