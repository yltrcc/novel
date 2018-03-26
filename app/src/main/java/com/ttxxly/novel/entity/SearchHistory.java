package com.ttxxly.novel.entity;

import java.util.List;

/**
 * description:
 *
 * @author Administrator
 * @date 2018-03-14
 * mail ttxxly@gmail.com
 */

public class SearchHistory {


    /**
     * SearchHistory : ["fsfsfs","gdgrgd"]
     * total : 2
     */

    private int total;
    private List<String> SearchHistory;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> getSearchHistory() {
        return SearchHistory;
    }

    public void setSearchHistory(List<String> SearchHistory) {
        this.SearchHistory = SearchHistory;
    }
}
