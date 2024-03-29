package com.frank.user.api.ip.juhe;

import com.alibaba.fastjson.JSONObject;
import com.frank.core.util.http.HttpUtil;
import com.frank.user.api.ip.juhe.bean.JHIPData;
import com.frank.user.api.ip.juhe.bean.JHResult;

import java.util.HashMap;
import java.util.Map;

public class JHIPApi {

    private static String URL = "http://apis.juhe.cn/ip/ipNew";

    private static String KEY = "e73c70434584b2a5ee343f2cc6b49e99";
    /**
     * 获取地址
     * @param ip
     * @return
     */
    public static JHResult<JHIPData> getAddress(String ip){
        Map params = new HashMap();
        params.put("ip",ip);
        params.put("key",KEY);
        String s = HttpUtil.doGet(URL, params);
        JHResult jhResult = JSONObject.parseObject(s, JHResult.class);
        JHIPData jhIPData = JSONObject.parseObject(jhResult.getResult().toString(), JHIPData.class);
        jhResult.setResult(jhIPData);
        return jhResult;
    }
}
