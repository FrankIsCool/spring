package com.frank.sso.dao;

import com.frank.sso.model.UserLogin;
import org.springframework.stereotype.Repository;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/28
 */
@Repository
public interface UserLoginDao {

    UserLogin getUserLoginByName(String userName);
}
