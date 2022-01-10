package com.ffmusic.config;


import com.ffmusic.exception.RestAuthenticationEntryPoint;
import com.ffmusic.filter.JwtAuthenticationFilter;
import com.ffmusic.filter.JwtAuthorizationFilter;
import com.ffmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String SECRET = "ffMusic";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/";

    //请求取到username和psd用他们形成鉴权，定义鉴权情况，生成令牌
    UserService userService;
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //开启cors跨区域名请求，关闭csrf验证，
            //users的post请求所有人都可以请求
            //其他的request都需要鉴权
            //jwt鉴权用户名密码
            //jwt鉴权token
            //把session改成无状态的session
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,SIGN_UP_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager()))
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //指定userService是我得
        auth.userDetailsService(userService);

    }

    @Autowired
    public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
