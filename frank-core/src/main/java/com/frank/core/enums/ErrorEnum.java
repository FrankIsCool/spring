package com.frank.core.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类：错误信息枚举
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/7
 */
@Getter
@AllArgsConstructor
@ApiModel("错误信息枚举")
public enum ErrorEnum {

    SUCCESS_200("200","成功");

    private String code;
    private String msg;

}
