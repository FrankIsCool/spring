package com.frank.sso.model;

import com.frank.sso.enums.UserStateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 类：用户登录表
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
@Data
@ApiModel("用户登录信息")
public class UserLogin implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        UserStateEnum anEnum = UserStateEnum.getEnum(this.state);
        if(anEnum==UserStateEnum.STATE_1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        UserStateEnum anEnum = UserStateEnum.getEnum(this.state);
        if(anEnum==UserStateEnum.STATE_1){
            return false;
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        UserStateEnum anEnum = UserStateEnum.getEnum(this.state);
        if(anEnum==UserStateEnum.STATE_2){
            return true;
        }
        return false;
    }
}
