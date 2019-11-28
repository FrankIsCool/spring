package com.frank.user.api.ip.free.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 免费ip识别地址
 * https://www.kancloud.cn/ccjin/yingq/875681
 */
@Data
public class FreeAddress {
    @JSONField(name="ip")
    private String ip;
    @JSONField(name="country")
    private String country;//国家
    @JSONField(name="province")
    private String province;//省
    @JSONField(name="city")
    private String city;//城市
    @JSONField(name="isp")
    private String isp;//运营商
}
