package com.ttxxly.reader.ui.fragment.user;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ttxxly.reader.R;
import com.ttxxly.reader.base.BaseFragment;
import com.ttxxly.reader.ui.account.AccountActivity;
import com.ttxxly.reader.ui.fragment.publication.PublicationContract;
import com.ttxxly.reader.ui.fragment.publication.PublicationPresenter;
import com.ttxxly.reader.ui.information.UserInformationActivity;
import com.ttxxly.reader.ui.set.SetActivity;

public class UserFragment extends BaseFragment implements UserContract.View{

    private View view;
    private RelativeLayout mRLUserSettings;
    private ViewGroup container;
    private LinearLayout mLLUserInfo;
    private RelativeLayout mRlAccount;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user, container, false);
        this.container = container;
        UserContract.Presenter presenter = new UserPresenter(this);
        presenter.start();
        return view;
    }


    @Override
    public void init() {

        //设置
        mRLUserSettings = view.findViewById(R.id.rl_user_settings);
        mRLUserSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(container.getContext(), SetActivity.class));
            }
        });

        //显示个人信息
        mLLUserInfo = view.findViewById(R.id.LLUserInfo);
        mLLUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(container.getContext(), UserInformationActivity.class));
            }
        });

        //账户信息
        mRlAccount = view.findViewById(R.id.RlAccount);
        mRlAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(container.getContext(), AccountActivity.class));
            }
        });

        //浏览记录

    }
}
