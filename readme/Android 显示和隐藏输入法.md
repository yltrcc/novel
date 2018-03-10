关于Android显示和隐藏输入法有一些值得我们注意的地方。

```
1. 调用 showSoftInput() 方法 失效
	当前布局完成加载之后，showSoftInput()才会起作用。
	在Activity的onCreate()中执行showSoftInput()是不起作用的
```

#### 显示输入法

```
private void showInputMethod() {
    boolean isShow = false;
    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

    if ( imm != null ) {
    	//循环调用，直到检测出输入法已经弹出。
        while ( !isShow ) {
            imm.showSoftInput(mETSearchContent, 0);
            if (imm.isActive()) {
                isShow = true;
            }
        }
    }else {
        Toast.makeText(this, "无法弹出输入法！！", Toast.LENGTH_SHORT).show();
    }
}
```

*这是我能想出最好的办法了，如果有哪位大佬还有更好的办法请不吝赐教,谢谢了*

#### 隐藏输入法

```
private void hideInputMethod() {
    View view = getWindow().peekDecorView();
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

    if (view != null && imm != null) {
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }else {
        Toast.makeText(this, "无法隐藏输入法！！！", Toast.LENGTH_SHORT).show();
    }
}s
```