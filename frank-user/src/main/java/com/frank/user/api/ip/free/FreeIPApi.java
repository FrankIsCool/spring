package com.frank.user.api.ip.free;

import com.alibaba.fastjson.JSONObject;
import com.frank.core.util.http.HttpUtil;
import com.frank.user.api.ip.free.bean.FreeAddress;

import java.util.HashMap;
import java.util.Map;

public class FreeIPApi {

    private static String URL = "http://ip.tianqiapi.com/";

    /**
     * ip地址识别
     * @param ip ip
     * @return
     */
    public static FreeAddress getAdress(String ip){
        Map params = new HashMap();
        params.put("ip",ip);
        String s = HttpUtil.doGet(URL, params);
        FreeAddress freeAddress = JSONObject.parseObject(s, FreeAddress.class);
        return freeAddress;
    }
}
