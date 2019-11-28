package com.frank.user.api.ip.bj;

import com.alibaba.fastjson.JSONObject;
import com.frank.core.util.http.HttpUtil;
import com.frank.user.api.ip.bj.bean.BJResult;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class BJIPApi {
    private static String URL = "http://api.help.bj.cn/apis/ip";
    /**
     * ip地址识别
     * @param ip ip
     * @return
     */
    public static BJResult getAdress(String ip){
        Map params = new HashMap();
        params.put("ip",ip);
        String s = HttpUtil.doGet(URL,params);
        BJResult data = JSONObject.parseObject(s,BJResult.class);
        return data;
    }
}
