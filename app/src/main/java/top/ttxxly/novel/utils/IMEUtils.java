package top.ttxxly.novel.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * description: 输入法工具
 *
 * @author Administrator
 * @date 2018-03-03
 * @mail ttxxly@gmail.com
 */

public class IMEUtils {


    /**
     * 检测输入法的显示状态
     * @param context
     * @return 1 表示打开状态 -1 表示关闭状态  0 表示 此方法不能检测输入法的状态
     */
    public static int isOpen(Context context) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            if (imm.isActive()) {
                return 1;
            }else{
                return -1;
            }
        }else {
            Toast.makeText(context, "抱歉，我检测不到输入法的状态", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    /**
     * 切换输入法状态 显示 或者 隐藏
     * @param context context 对象
     */
    public static void toggleInputMethodStatus(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }else {
            Toast.makeText(context, "抱歉，输入法设置显示、隐藏失败！！！", Toast.LENGTH_SHORT).show();
        }
    }

    public static void setForceShow(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
        }else {
            Toast.makeText(context, "抱歉，输入法强制显示失败！！！", Toast.LENGTH_SHORT).show();
        }
    }

    public static void setForceHide(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }else {
            Toast.makeText(context, "抱歉，输入法强制隐藏失败！！！", Toast.LENGTH_SHORT).show();
        }
    }
}
