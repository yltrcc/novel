package top.ttxxly.novel.ui.fragment.bookrack;

import com.google.gson.Gson;

import top.ttxxly.novel.entity.MyBooks;

/**
 * Description:
 * date: 2018/02/08 21:59
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class BookrackPresenter implements BookrackContract.presenter{
    private BookrackContract.view view; //只在当前类有效

    public BookrackPresenter(BookrackContract.view view) {
        this.view = view;
    }

    @Override
    public void start() {
        getDataSource();
    }

    @Override
    public void stop() {

    }

    @Override
    public void getDataSource() {
        //获取应用书架信息
        /**
         * 模拟一个数据
         *
         */
        Gson gson = new Gson();
        String jsonString = "{\n" +
                "    \"books\": [\n" +
                "        {\n" +
                "            \"author\": \"耳根\",\n" +
                "            \"bookId\": \"531169b3173bfacb4904ca67\",\n" +
                "            \"bookTitle\": \"仙逆\",\n" +
                "            \"chaptersCount\": 1234,\n" +
                "            \"cover\": \"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F\",\n" +
                "            \"latestChapter\": \"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）\",\n" +
                "            \"readChapterLink\": \"werwrweregrewgrgewgergrewgggggggggg\",\n" +
                "            \"readChapterTitle\": \"yhhhhhhh\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"author\": \"耳根\",\n" +
                "            \"bookId\": \"531169b3173bfacb4904ca67\",\n" +
                "            \"bookTitle\": \"仙逆\",\n" +
                "            \"chaptersCount\": 1234,\n" +
                "            \"cover\": \"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F\",\n" +
                "            \"latestChapter\": \"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）\",\n" +
                "            \"readChapterLink\": \"werwrweregrewgrgewgergrewgggggggggg\",\n" +
                "            \"readChapterTitle\": \"yhhhhhhh\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"author\": \"耳根\",\n" +
                "            \"bookId\": \"531169b3173bfacb4904ca67\",\n" +
                "            \"bookTitle\": \"仙逆\",\n" +
                "            \"chaptersCount\": 1234,\n" +
                "            \"cover\": \"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F\",\n" +
                "            \"latestChapter\": \"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）\",\n" +
                "            \"readChapterLink\": \"werwrweregrewgrgewgergrewgggggggggg\",\n" +
                "            \"readChapterTitle\": \"yhhhhhhh\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"author\": \"耳根\",\n" +
                "            \"bookId\": \"531169b3173bfacb4904ca67\",\n" +
                "            \"bookTitle\": \"仙逆\",\n" +
                "            \"chaptersCount\": 1234,\n" +
                "            \"cover\": \"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F\",\n" +
                "            \"latestChapter\": \"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）\",\n" +
                "            \"readChapterLink\": \"werwrweregrewgrgewgergrewgggggggggg\",\n" +
                "            \"readChapterTitle\": \"yhhhhhhh\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"author\": \"耳根\",\n" +
                "            \"bookId\": \"531169b3173bfacb4904ca67\",\n" +
                "            \"bookTitle\": \"仙逆\",\n" +
                "            \"chaptersCount\": 1234,\n" +
                "            \"cover\": \"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F\",\n" +
                "            \"latestChapter\": \"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）\",\n" +
                "            \"readChapterLink\": \"werwrweregrewgrgewgergrewgggggggggg\",\n" +
                "            \"readChapterTitle\": \"yhhhhhhh\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"total\": 5\n" +
                "}";
        MyBooks myBooks = gson.fromJson(jsonString, MyBooks.class);
        view.init(myBooks);
    }
}
