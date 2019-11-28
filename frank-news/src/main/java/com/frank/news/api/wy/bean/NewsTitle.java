package com.frank.news.api.wy.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 类：新闻简介
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
@Data
@ApiModel("新闻简介")
public class NewsTitle {
    private String liveInfo;
    private String docid;
    private String source;
    private String title;
    private String priority;
    private String hasImg;
    private String url;
    private String commentCount;
    private String imgsrc3gtype;
    private String stitle;
    private String digest;
    private String imgsrc;
    private String ptime;
}
