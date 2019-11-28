package com.frank.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frank.user.util.UserUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import okhttp3.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/20
 */
@Controller
public class UserController {

    /**
     * 用来展示index.html 模板
     * @return
     */
    @GetMapping(value = "index")
    public String index(){
        return "index";
    }

    @GetMapping(value = "login")
    public Object login(String code, Model model) {
        String tokenUrl = "http://localhost:8001/sso/oauth/token";
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("grant_type", "authorization_code")
                .add("client", "user")
                .add("redirect_uri","http://localhost:8002/user/login")
                .add("code", code)
                .build();

        Request request = new Request.Builder()
                .url(tokenUrl)
                .post(body)
                .addHeader("Authorization", "Basic dXNlcjp1c2VyLWZyYW5rLWtuRGxUME5RSEVmWlZjb1dqSVY1cldhd2dWcThiYWFv")
                .build();
        try {
            Response response = httpClient.newCall(request).execute();
            String result = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            Map tokenMap = objectMapper.readValue(result,Map.class);
            String accessToken = tokenMap.get("access_token").toString();
            Claims claims = Jwts.parser()
                    .setSigningKey("123456".getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(accessToken)
                    .getBody();
            String userName = claims.get("user_name").toString();
            model.addAttribute("username", userName);
            model.addAttribute("accessToken", accessToken);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @org.springframework.web.bind.annotation.ResponseBody
    @GetMapping(value = "get")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object get() {
        return UserUtil.getToken();
    }

}
