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

        TagGroup mTagGroup = findViewById(R.id.TGSearch);
        mTagGroup.setTags(new String[]{"影帝的老婆", "花豹突击队", "一言不合就卖萌", "最强武神", "大数据修仙", "天才高手"});
    }
}
