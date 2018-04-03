package com.ttxxly.reader.entity;

import com.ttxxly.reader.utils.AppUtils;
import com.ttxxly.reader.utils.FileUtils;

/**
 * Created by Administrator on 3/1/2018.
 * @author ttxxly
 * 保存常量信息
 */

public class Const {

    /**
     * SP 文件名
     */
    public static final String USER_INFO = "userInfo";

    /**
     * sp userInfo.xml 下 用户ID
     */
    public static final String USER_ID = "user_id";

    /**
     * sp userInfo.xml 下 登录状态
     */
    public static final String LOGIN_STATUS = "loginStatus";

    /**
     * 本地默认书架文件名
     */
    public static final String DEFAULT_BOOKSHELF = "defaultBookshelf";

    /**
     * API 接口 Base Url
     */
    public static final String API_BASE_URL = "http://api.zhuishushenqi.com";

    /**
     * sp SearchHistory.xml 文件名
     */
    public static final String SEARCH_HISTORY = "SearchHistory";

    /**
     * sp SearchHistory.xml 下 key：SearchHistory
     */
    public static final String HISTORY = "SearchHistory";

    /**
     * 图片基地址
     */
    public static final String IMG_BASE_URL = "http://statics.zhuishushenqi.com";

    /**
     * Intent传递的 key
     */
    public static final String BOOKSBEAN = "booksBean";


    public static String PATH_DATA = FileUtils.createRootPath(AppUtils.getAppContext()) + "/cache";

    public static String PATH_TXT = PATH_DATA + "/book/";

}
