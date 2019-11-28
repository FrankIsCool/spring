package com.frank.user.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/27
 */
public class UserUtil {

    public static String getToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return details.getTokenValue();
    }

}
