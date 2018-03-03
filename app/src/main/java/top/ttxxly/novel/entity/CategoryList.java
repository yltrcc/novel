package top.ttxxly.novel.entity;


import java.util.List;

import top.ttxxly.novel.base.Base;

/**
 * Created by lfh on 2016/8/15.
 */
public class CategoryList extends Base {


    /**
     * male : [{"name":"玄幻","bookCount":188244},{"name":"奇幻","bookCount":24183}]
     * ok : true
     */

    public List<MaleBean> male;
    /**
     * name : 古代言情
     * bookCount : 125103
     */

    public List<MaleBean> female;

    public static class MaleBean {
        public String name;
        public int bookCount;
    }
}
