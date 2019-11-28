package com.frank.sso.service;

import com.frank.sso.model.UserLogin;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/18
 */
@Component
public class SSOUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoginService userLoginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("the username is not null");
        }
        UserLogin userLogin = userLoginService.getUserLoginByName(username);
        if(null==userLogin){
            throw new UsernameNotFoundException("the user is not found");
        }
        String password = passwordEncoder.encode(userLogin.getPassword());
        // 用户角色也应在数据库中获取
        String role = "ROLE_ADMIN";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        // 返回自定义的
        User user = new User(username,password,authorities);
        return user;
    }
}
