package com.frank.user.api.ip.bj.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class BJData {
    @JSONField(name="country")
    private String country;//国家
    @JSONField(name="country_id")
    private String countryId;//国家简称
    @JSONField(name="area")
    private String area;//区域
    @JSONField(name="area_id")
    private String area_id;//区域id
    @JSONField(name="province")
    private String province;//省份
    @JSONField(name="province_id")
    private String provinceId;//省份id
    @JSONField(name="city")
    private String city;//城市
    @JSONField(name="city_id")
    private String cityId;//城市id
    @JSONField(name="county")
    private String county;//地区
    @JSONField(name="county_id")
    private String countyId;//地区id
    @JSONField(name="isp")
    private String isp;//运营商
    @JSONField(name="isp_id")
    private String isp_id;//运营商id
    @JSONField(name="ip")
    private String ip;

}
