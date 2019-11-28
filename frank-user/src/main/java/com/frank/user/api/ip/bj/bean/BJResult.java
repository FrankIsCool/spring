package com.frank.user.api.ip.bj.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.frank.user.api.ip.bj.bean.BJData;
import lombok.Data;

@Data
public class BJResult {
    @JSONField(name="status")
    private String status;
    @JSONField(name="data")
    private BJData data;
}
