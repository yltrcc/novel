package com.ttxxly.reader.ui.read;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.ttxxly.reader.utils.ToastUtils;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-02
 * mail ttxxly@gmail.com
 */
public class BaseView extends View {

    public BaseView(Context context) {

        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            //手指 初次接触到屏幕 时触发。
            case MotionEvent.ACTION_DOWN:
                System.out.println("手指 初次接触到屏幕 时触发。");
                break;
            //事件 被上层拦截 时触发。
            case MotionEvent.ACTION_CANCEL:
                System.out.println("事件 被上层拦截 时触发。");
                break;
            //手指 离开屏幕 时触发。
            case MotionEvent.ACTION_UP:
                performClick();
                System.out.println("手指 离开屏幕 时触发。");
                break;
            default:
                break;
        }
        return true;
    }

}
