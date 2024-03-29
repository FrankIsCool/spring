package com.frank.user.api.ip.ipip;

import com.alibaba.fastjson.JSONObject;
import com.frank.core.util.http.HttpUtil;
import com.frank.user.api.ip.ipip.bean.IPIPData;

import java.util.List;

public class IPIPApi {
    private static String URL = "http://freeapi.ipip.net/";
    /**
     * ip地址识别
     * @param ip ip
     * @return
     */
    public static IPIPData getAdress(String ip){
        String s = HttpUtil.doGet(URL+ip);
        List<String> data = JSONObject.parseArray(s, String.class);
        return toData(data);
    }

    /**
     * 转换成实体
     * @param data
     * @return
     */
    private static IPIPData toData(List<String> data){
        IPIPData ipipData = new IPIPData();
        ipipData.setCountry(data.get(0));
        ipipData.setProvince(data.get(1));
        ipipData.setCity(data.get(2));
        ipipData.setDistrict(data.get(3));
        ipipData.setIsp(data.get(4));
        return ipipData;
    }
}
