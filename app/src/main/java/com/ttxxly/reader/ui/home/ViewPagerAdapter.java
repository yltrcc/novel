package com.ttxxly.reader.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import com.ttxxly.reader.base.BaseFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> data;

    public ViewPagerAdapter(FragmentManager fm, List<BaseFragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {//返回子View对象
        return data.get(position);
    }
    @Override
    public int getCount() {//返回子View的个数
        return data.size();
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {//初始子View方法
        return super.instantiateItem(container, position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//销毁子View
        super.destroyItem(container, position, object);
    }
}
