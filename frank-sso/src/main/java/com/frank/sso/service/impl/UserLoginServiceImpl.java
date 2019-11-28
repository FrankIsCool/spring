package com.frank.sso.service.impl;

import com.frank.sso.dao.UserLoginDao;
import com.frank.sso.model.UserLogin;
import com.frank.sso.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginDao userLoginDao;


    @Override
    public UserLogin getUserLoginByName(String userName) {
        return userLoginDao.getUserLoginByName(userName);
    }
}
