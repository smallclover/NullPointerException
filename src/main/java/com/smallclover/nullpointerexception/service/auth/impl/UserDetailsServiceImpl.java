package com.smallclover.nullpointerexception.service.auth.impl;

import com.smallclover.nullpointerexception.mapper.UserMapper;
import com.smallclover.nullpointerexception.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 用户认证服务
 * @Author: Amadeus
 * @Date: 2020/3/31 22:22
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userMapper.findUserById(email);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("未发现指定的用户");
        }

        var grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantList.add(authority);
        user.setAuthorities(grantList);
        return user;
    }
}
