package com.smallclover.nullpointerexception.config;

import com.smallclover.nullpointerexception.handler.AuthFailureHandler;
import com.smallclover.nullpointerexception.handler.AuthSuccessHandler;
import com.smallclover.nullpointerexception.service.auth.impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 权限配置
 * @Author: Amadeus
 * @Date: 2020/3/29 23:01
 */
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
// WebSecurityConfigurerAdapter 和 @EnableWebSecurity二者选其一即可实现spring security

    /*
    Spring Security在Spring加载完Bean之前就加载了（Spring框架中的Web.xml配置相关）
    MyUserDetailsService继承AbstractJUnit4SpringContextTests之后输出applicationContext，发现applicationContext为空，说明Spring没有加载完成
    Spring没有扫描到MyUserDetailsService，否则@Service肯定能达到与@Bean同样的效果
     */
    private AuthSuccessHandler authSuccessHandler;

    private AuthFailureHandler authFailureHandler;


    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

    // 构造函数初始化会出现循环依赖
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.permitAll不会绕开springsecurity验证，相当于是允许该路径通过
        // web.ignoring是直接绕开spring security的所有filter，直接跳过验证

        http.authorizeRequests()
                .antMatchers("/error/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/admin/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/admin/login/auth")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler);

        //TODO 这里SpringSecurity的流程还是要好好理解

        // 事实上之所以返回302重定向到login页面，是因为认证不通过
        // 同源下可以加载iframe
        //    DENY：浏览器拒绝当前页面加载任何Frame页面  （默认）
        //    SAMEORIGIN：frame页面的地址只能为同源域名下的页面
        //    ALLOW-FROM：origin为允许frame加载的页面地址。
        // 如果不设置会出现如下类似的错误
        // Load denied by X-Frame-Options: http://127.0.0.1:9002/uploadeFile?guid=1550410830006 does not permit framing.
        // SecurityError: Permission denied to access property "document" on cross-origin object
        http.headers().frameOptions().sameOrigin();

        // 注销
        http.logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "SESSION", "remember-me")
                .permitAll();
//         不加302错误
        http.csrf().disable();

    }
    //    spring boot security 将您重定向的次数过多
    //    为了跳转到我们自己定义的登录页面，写了loginPage("/login.html")，
    //    按照正常的逻辑，应该我们在访问接口的时候，都会跳到登录页面，结果却报错了。
    //    其原因是我们在访问接口时，因为有 anyRequest()，对所有的请求都要进行认证，
    //    所以会跳到login.html这个页面，跳转过去之后去请求login.html这个页面也需要身份认证，
    //    所以还是跳到了login.html这个页面，形成了死循环，所以会出现这个错误。
//
//
    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring()
                // 静态资源
                .antMatchers("/admin/dist/**")
                .antMatchers("/admin/plugins/**")
                .antMatchers("/upload/**")
                // 可以直接访问的页面
                .antMatchers("/")
                .antMatchers("/index")
                .antMatchers("/blog/**")
                .antMatchers("/api/**")
                // 测试用
                .antMatchers("/test/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(getUserDetailsService()).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
/*
ANT通配符有三种：
? 匹配任何单字符
* 匹配0或者任意数量的字符
** 匹配0或者更多的目录

antMatchers匹配顺序
按你注册规则的顺序，第一条能匹配上的，就是最终会执行的规则。
注册规则的时候一定要注意顺序，如果 /** 第一个注册，则后面的任何规则都不会被匹配了，永远执行 /** 的这个规则。

 */
}
