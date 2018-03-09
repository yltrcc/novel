package com.ttxxly.novel.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Description: Viewpager 的 基类， 便于控制是否需要滑动功能
 * date: 2018/02/08 15:41
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class BaseViewPager extends ViewPager {

    public BaseViewPager(Context context) {
        super(context);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
