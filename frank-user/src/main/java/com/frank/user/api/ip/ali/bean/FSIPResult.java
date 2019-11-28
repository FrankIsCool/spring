package com.frank.user.api.ip.ali.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class FSIPResult {
    @JSONField(name="ret")
    private String ret;
    @JSONField(name="data")
    private FSIPData data;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public FSIPData getData() {
        return data;
    }

    public void setData(FSIPData data) {
        this.data = data;
    }
}
