package com.frank.user.api.ip.juhe.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class JHIPData {
    @JSONField(name = "Country")
    private String country;//国家
    @JSONField(name = "Province")
    private String province;//省
    @JSONField(name = "City")
    private String city;//市
    @JSONField(name = "Isp")
    private String isp;//运营商
}
