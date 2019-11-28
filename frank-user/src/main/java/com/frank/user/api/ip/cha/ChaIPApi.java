package com.frank.user.api.ip.cha;

import com.alibaba.fastjson.JSONObject;
import com.frank.core.util.http.HttpUtil;
import com.frank.user.api.ip.cha.bean.ChaData;
import com.frank.user.api.ip.cha.bean.ChaResult;
import com.frank.user.api.ip.juhe.bean.JHIPData;

import java.util.HashMap;
import java.util.Map;

/**
 * 91cha ip识别
 * http://www.91cha.com/api/ip.html
 */
public class ChaIPApi {
    private static String URL = "http://api.91cha.com/ip";
    private static String KEY = "aa7ad059278047efa5fcfe491695ad5e";
    /**
     * ip地址识别
     * @param ip ip
     * @return
     */
    public static ChaResult getAdress(String ip){
        Map params = new HashMap();
        params.put("ip",ip);
        params.put("key",KEY);
        String s = HttpUtil.doGet(URL,params);
        ChaResult data = JSONObject.parseObject(s,ChaResult.class);
        return data;
    }
}
