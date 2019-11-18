package com.frank.sso.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/18
 */
@Component
public class SSOUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return new User(name, new BCryptPasswordEncoder().encode("123456"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
