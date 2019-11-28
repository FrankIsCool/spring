package com.frank.user.api.ip.ali.bean;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FSIPData {

    @ApiModelProperty("国家")
    @JSONField(name="country")
    private String country;//国家

    @ApiModelProperty("国家英文简称")
    @JSONField(name="country_code")
    private String countryCode;//国家英文简称

    @ApiModelProperty("大区")
    @JSONField(name="big_area")
    private String bigArea;//大区

    @ApiModelProperty("省份")
    @JSONField(name="prov")
    private String prov;//省份

    @ApiModelProperty("市")
    @JSONField(name="city")
    private String city;//市

    @ApiModelProperty("城市编码")
    @JSONField(name="city_code")
    private String cityCode;//城市编码

    @ApiModelProperty("城市英文简称")
    @JSONField(name="city_short_code")
    private String cityShortCode;//城市英文简称

    @ApiModelProperty("区或者县")
    @JSONField(name="area")
    private String area;//区或者县

    @ApiModelProperty("区或者县")
    @JSONField(name="area_code")
    private String areaCode;//区或者县

    @ApiModelProperty("运营商")
    @JSONField(name="isp")
    private String isp;//运营商

    @ApiModelProperty("国家英文简称")
    @JSONField(name="post_code")
    private String postCode;//国家英文简称

    @ApiModelProperty("国家")
    @JSONField(name="lng")
    private String lng;

    @ApiModelProperty("国家")
    @JSONField(name="lat")
    private String lat;

    @ApiModelProperty("国家")
    @JSONField(name="long_ip")
    private String longIp;

}
