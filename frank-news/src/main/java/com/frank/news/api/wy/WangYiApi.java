package com.frank.news.api.wy;

import com.alibaba.fastjson.JSONObject;
import com.frank.core.util.http.HttpUtil;
import com.frank.news.api.wy.bean.NewsTitle;
import com.frank.news.api.wy.bean.NewsTypeEnum;

import java.util.List;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
public class WangYiApi {

    private static final String HOST = "https://3g.163.com";

    /**
     * 新闻
     * @param
     * @return
     * @author frank(付帅)
     * @date 2019/11/28
     **/
    private static List<NewsTitle> getNews(Integer type, Integer pageSize, Integer pageNum) {
        NewsTypeEnum anEnum = NewsTypeEnum.getEnum(type);
        Integer start = pageSize*(pageNum-1);
        Integer end = pageSize*(pageNum);
        StringBuilder url = new StringBuilder(HOST);
        url.append("/touch/reconstruct/article/list/")
                .append(anEnum.getUrl()).append("/")
                .append(start).append("-").append(end).append(".html");

        String s = HttpUtil.doGet(url.toString());
        s = s.replaceAll("artiList\\(","");
        s = s.substring(0,s.length()-1);
        return JSONObject.parseArray(s, NewsTitle.class);
    }

}
