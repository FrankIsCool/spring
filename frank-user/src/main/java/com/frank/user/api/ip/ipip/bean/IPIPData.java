package com.frank.user.api.ip.ipip.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class IPIPData {
    @JSONField(name = "country")
    private String country;//国家
    @JSONField(name = "province")
    private String province;//省
    @JSONField(name = "city")
    private String city;//市
    @JSONField(name = "district")
    private String district;//区或者县
    @JSONField(name = "isp")
    private String isp;//运营商
}
