package com.ttxxly.reader.entity;

import java.util.List;

/**
 * Created by Administrator on 2/26/2018.
 */

public class Bookshelf {


    /**
     * books : [{"author":"耳根","bookId":"531169b3173bfacb4904ca67","bookTitle":"仙逆","chaptersCount":1234,"cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F","latestChapter":"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）","readChapterLink":"werwrweregrewgrgewgergrewgggggggggg","readChapterTitle":"yhhhhhhh"},{"author":"耳根","bookId":"531169b3173bfacb4904ca67","bookTitle":"仙逆","chaptersCount":1234,"cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F","latestChapter":"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）","readChapterLink":"werwrweregrewgrgewgergrewgggggggggg","readChapterTitle":"yhhhhhhh"},{"author":"耳根","bookId":"531169b3173bfacb4904ca67","bookTitle":"仙逆","chaptersCount":1234,"cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F","latestChapter":"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）","readChapterLink":"werwrweregrewgrgewgergrewgggggggggg","readChapterTitle":"yhhhhhhh"},{"author":"耳根","bookId":"531169b3173bfacb4904ca67","bookTitle":"仙逆","chaptersCount":1234,"cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F","latestChapter":"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）","readChapterLink":"werwrweregrewgrgewgergrewgggggggggg","readChapterTitle":"yhhhhhhh"},{"author":"耳根","bookId":"531169b3173bfacb4904ca67","bookTitle":"仙逆","chaptersCount":1234,"cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F","latestChapter":"第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）","readChapterLink":"werwrweregrewgrgewgergrewgggggggggg","readChapterTitle":"yhhhhhhh"}]
     * total : 4
     */

    private int total;
    private List<BooksBean> books;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        total = books.size();
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        total = books.size();
        this.books = books;
    }

    public static class BooksBean {
        /**
         * author : 耳根
         * bookId : 531169b3173bfacb4904ca67
         * bookTitle : 仙逆
         * chaptersCount : 1234
         * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F
         * latestChapter : 第十卷 我看沧海化桑田 第1614章 孤帆一片日边来！（终）
         * readChapterLink : werwrweregrewgrgewgergrewgggggggggg
         * readChapterTitle : yhhhhhhh
         */

        private String author;
        private String bookId;
        private String bookTitle;
        private int chaptersCount;
        private String cover;
        private String latestChapter;
        private String readChapterLink;
        private String readChapterTitle;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public String getBookTitle() {
            return bookTitle;
        }

        public void setBookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
        }

        public int getChaptersCount() {
            return chaptersCount;
        }

        public void setChaptersCount(int chaptersCount) {
            this.chaptersCount = chaptersCount;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getLatestChapter() {
            return latestChapter;
        }

        public void setLatestChapter(String latestChapter) {
            this.latestChapter = latestChapter;
        }

        public String getReadChapterLink() {
            return readChapterLink;
        }

        public void setReadChapterLink(String readChapterLink) {
            this.readChapterLink = readChapterLink;
        }

        public String getReadChapterTitle() {
            return readChapterTitle;
        }

        public void setReadChapterTitle(String readChapterTitle) {
            this.readChapterTitle = readChapterTitle;
        }
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "total=" + total +
                ", books=" + books +
                '}';
    }
}
