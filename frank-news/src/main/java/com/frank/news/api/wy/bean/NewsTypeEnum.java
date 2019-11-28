package com.frank.news.api.wy.bean;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
public enum NewsTypeEnum {

//    视频：/touch/nc/api/video/recommend/Video_Recom/0-10.do?callback=videoList

    TYPE_1(1,"新闻","BBM54PGAwangning"),//    新闻：/touch/reconstruct/article/list/BBM54PGAwangning/0-10.html
    TYPE_2(2,"娱乐","BA10TA81wangning"),//    娱乐：/touch/reconstruct/article/list/BA10TA81wangning/0-10.html
    TYPE_3(3,"体育","BA8E6OEOwangning"),//    体育：/touch/reconstruct/article/list/BA8E6OEOwangning/0-10.html
    TYPE_4(4,"财经","BA8EE5GMwangning"),//    财经：/touch/reconstruct/article/list/BA8EE5GMwangning/0-10.html
    TYPE_5(5,"军事","BAI67OGGwangning"),//    军事：/touch/reconstruct/article/list/BAI67OGGwangning/0-10.html
    TYPE_6(6,"科技","BA8D4A3Rwangning"),//    科技：/touch/reconstruct/article/list/BA8D4A3Rwangning/0-10.html
    TYPE_7(7,"手机","BAI6I0O5wangning"),//    手机：/touch/reconstruct/article/list/BAI6I0O5wangning/0-10.html
    TYPE_8(8,"数码","BAI6JOD9wangning"),//    数码：/touch/reconstruct/article/list/BAI6JOD9wangning/0-10.html
    TYPE_9(9,"时尚","BA8F6ICNwangning"),//    时尚：/touch/reconstruct/article/list/BA8F6ICNwangning/0-10.html
    TYPE_10(10,"游戏","BAI6RHDKwangning"),//    游戏：/touch/reconstruct/article/list/BAI6RHDKwangning/0-10.html
    TYPE_11(11,"教育","BA8FF5PRwangning"),//    教育：/touch/reconstruct/article/list/BA8FF5PRwangning/0-10.html
    TYPE_12(12,"健康","BDC4QSV3wangning"),//    健康：/touch/reconstruct/article/list/BDC4QSV3wangning/0-10.html
    TYPE_13(13,"旅游","BEO4GINLwangning");//    旅游：/touch/reconstruct/article/list/BEO4GINLwangning/0-10.html

    private Integer code;
    private String desc;
    private String url;

    NewsTypeEnum(Integer code, String desc, String url) {
        this.code = code;
        this.desc = desc;
        this.url = url;
    }

    public static NewsTypeEnum getEnum(Integer code) {
        NewsTypeEnum[] values = NewsTypeEnum.values();
        for (NewsTypeEnum stateEnum : values) {
            if (stateEnum.getCode() == code) {
                return stateEnum;
            }
        }
        return null;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
