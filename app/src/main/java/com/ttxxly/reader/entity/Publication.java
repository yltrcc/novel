package com.ttxxly.reader.entity;

import java.util.List;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-05-04
 * mail ttxxly@gmail.com
 */
public class Publication {


    public List<PublicationBean> publicationBean;

    public List<PublicationBean> getPublicationBean() {
        return publicationBean;
    }

    public void setPublicationBean(List<PublicationBean> publicationBean) {
        this.publicationBean = publicationBean;
    }

    public static class PublicationBean {
        private String mTitle;
        private BooksByCats booksByCats;


        public String getmTitle() {
            return mTitle;
        }

        public void setmTitle(String mTitle) {
            this.mTitle = mTitle;
        }

        public BooksByCats getBooksByCats() {
            return booksByCats;
        }

        public void setBooksByCats(BooksByCats booksByCats) {
            this.booksByCats = booksByCats;
        }
    }

}
