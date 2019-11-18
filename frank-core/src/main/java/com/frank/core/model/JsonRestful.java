package com.frank.core.model;

import com.frank.core.enums.ErrorEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * 类：统一返回接口实体类
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("统一返回接口实体类")
public class JsonRestful<T> {
    /**
     * 接口状态
     **/
    @ApiModelProperty("接口状态")
    private String code;
    /**
     * 错误信息
     **/
    @ApiModelProperty("错误信息")
    private String msg;
    /**
     * 返回具体内容
     **/
    @ApiModelProperty("返回具体内容")
    private T data;

    public JsonRestful<T> setMsg(ErrorEnum errorEnum) {
        if(!StringUtils.isEmpty(errorEnum.getMsg())){
            this.msg = errorEnum.getMsg();
        }
        if(!StringUtils.isEmpty(errorEnum.getCode())){
            this.code = errorEnum.getCode();
        }
        return this;
    }

    public JsonRestful<T> setData(T data) {
        this.data = data;
        return setMsg(ErrorEnum.SUCCESS_200);
    }
}
