package com.frank.user.api.ip.cha.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ChaData {
    @JSONField(name="ip")
    private String ip;
    @JSONField(name="country")
    private String country; /*所属国家*/
    @JSONField(name="area")
    private String area;/*所在大的地区*/
    @JSONField(name="province")
    private String province;/*所在的省*/
    @JSONField(name="city")
    private String city;/*所在的城市*/
    @JSONField(name="district")
    private String district;/*所在的区域*/
    @JSONField(name="linetype")
    private String linetype;/*所属运营商*/
}
