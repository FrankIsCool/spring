package com.frank.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 类：用户登录表
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
@Data
@ApiModel("用户登录信息")
public class UserLogin  {
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户编码")
    private String userSn;
    @ApiModelProperty("用户手机号")
    private String phone;
    @ApiModelProperty("用户名称")
    private String userName;
    @ApiModelProperty("密码")
    private String passWord;
    @ApiModelProperty("用户状态")
    private Integer state;
    @ApiModelProperty("修改时间")
    private Date updateTime;
    @ApiModelProperty("创建时间")
    private Date createTime;
}
