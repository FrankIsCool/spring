package com.frank.sso.enums;


/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
public enum UserStateEnum {

    STATE_1(1, "正常"),
    STATE_2(2, "冻结"),
    STATE_3(3, "异常");

    private Integer code;
    private String desc;

    UserStateEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserStateEnum getEnum(Integer code) {
        UserStateEnum[] values = UserStateEnum.values();
        for (UserStateEnum stateEnum : values) {
            if (stateEnum.getCode() == code) {
                return stateEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
