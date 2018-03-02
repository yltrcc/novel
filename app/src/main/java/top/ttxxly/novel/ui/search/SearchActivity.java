package top.ttxxly.novel.ui.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.gujun.android.taggroup.TagGroup;
import top.ttxxly.novel.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //使用的是开源的方案， 不算太好 看见一个好的， 有时间研究研究
        TagGroup mTagGroup = findViewById(R.id.TGSearch);
        mTagGroup.setTags(new String[]{ "一言不合就卖萌", "最强武神", "大数据修仙", "天才高手"});
    }
}
