package com.frank.sso.service;

import com.frank.sso.model.UserLogin;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
public interface UserLoginService {

    UserLogin getUserLoginByName(String userName);

}
