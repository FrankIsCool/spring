package com.frank.user.api.ip.cha.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.frank.user.api.ip.cha.bean.ChaData;
import lombok.Data;

@Data
public class ChaResult {

    @JSONField(name="status")
    private String status;
    @JSONField(name="msg")
    private String msg;
    @JSONField(name="data")
    private ChaData data;
}
