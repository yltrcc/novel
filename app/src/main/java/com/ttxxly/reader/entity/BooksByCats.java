
package com.ttxxly.reader.entity;


import com.google.gson.annotations.SerializedName;
import com.ttxxly.reader.base.Base;

import java.util.List;


/**
 * Created by Administrator on 2016/8/15.
 */
public class BooksByCats extends Base {


    /**
     * total : 6748
     * books : [{"_id":"50874f79f98e8f7446000017","author":"南派三叔","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41574%2F_41574_081848.jpg%2F","shortIntro":"50年前由长沙土夫子（盗墓贼）出土的战国帛书，记载了一个奇特战国古墓的位置，50年后，其中一个土夫子的孙子在他的笔记中发现这个秘密，纠集了一批经验丰富的盗墓贼前去寻宝，谁也没有想到，这个古墓竟然有着这么多诡异的事情：七星疑棺，青眼狐尸，九头蛇柏。这神秘的墓主人到底是谁，他们到底能不能找到真正的棺椁？故事悬念重重，情节跌荡，值得一看。","title":"盗墓笔记","site":"zhuishuvip","majorCate":"出版小说","minorCate":"","sizetype":-1,"superscript":"","contentType":"txt","allowMonthly":false,"banned":0,"latelyFollower":13508,"retentionRatio":40.45,"lastChapter":"《后记》下","tags":[]}]
     */
    @SerializedName("total")
    private int total;
    @SerializedName("books")
    private List<BooksBean> books;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean {
        /**
         * _id : 50874f79f98e8f7446000017
         * author : 南派三叔
         * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41574%2F_41574_081848.jpg%2F
         * shortIntro : 50年前由长沙土夫子（盗墓贼）出土的战国帛书，记载了一个奇特战国古墓的位置，50年后，其中一个土夫子的孙子在他的笔记中发现这个秘密，纠集了一批经验丰富的盗墓贼前去寻宝，谁也没有想到，这个古墓竟然有着这么多诡异的事情：七星疑棺，青眼狐尸，九头蛇柏。这神秘的墓主人到底是谁，他们到底能不能找到真正的棺椁？故事悬念重重，情节跌荡，值得一看。
         * title : 盗墓笔记
         * site : zhuishuvip
         * majorCate : 出版小说
         * minorCate :
         * sizetype : -1
         * superscript :
         * contentType : txt
         * allowMonthly : false
         * banned : 0
         * latelyFollower : 13508
         * retentionRatio : 40.45
         * lastChapter : 《后记》下
         * tags : []
         */
        @SerializedName("_id")
        private String id;

        @SerializedName("author")
        private String author;

        @SerializedName("cover")
        private String cover;

        @SerializedName("shortIntro")
        private String shortIntro;

        @SerializedName("title")
        private String title;

        @SerializedName("site")
        private String site;

        @SerializedName("majorCate")
        private String majorCate;

        @SerializedName("minorCate")
        private String minorCate;

        @SerializedName("sizetype")
        private int sizetype;

        @SerializedName("superscript")
        private String superscript;

        @SerializedName("contentType")
        private String contentType;

        @SerializedName("allowMonthly")
        private boolean allowMonthly;

        @SerializedName("banned")
        private int banned;

        @SerializedName("latelyFollower")
        private int latelyFollower;

        @SerializedName("retentionRatio")
        private double retentionRatio;

        @SerializedName("lastChapter")
        private String lastChapter;

        @SerializedName("tags")
        private List<String> tags;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getShortIntro() {
            return shortIntro;
        }

        public void setShortIntro(String shortIntro) {
            this.shortIntro = shortIntro;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getMajorCate() {
            return majorCate;
        }

        public void setMajorCate(String majorCate) {
            this.majorCate = majorCate;
        }

        public String getMinorCate() {
            return minorCate;
        }

        public void setMinorCate(String minorCate) {
            this.minorCate = minorCate;
        }

        public int getSizetype() {
            return sizetype;
        }

        public void setSizetype(int sizetype) {
            this.sizetype = sizetype;
        }

        public String getSuperscript() {
            return superscript;
        }

        public void setSuperscript(String superscript) {
            this.superscript = superscript;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public boolean isAllowMonthly() {
            return allowMonthly;
        }

        public void setAllowMonthly(boolean allowMonthly) {
            this.allowMonthly = allowMonthly;
        }

        public int getBanned() {
            return banned;
        }

        public void setBanned(int banned) {
            this.banned = banned;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
        }

        public double getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(double retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
