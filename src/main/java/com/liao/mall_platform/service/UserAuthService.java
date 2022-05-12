package com.liao.mall_platform.service;


import com.liao.mall_platform.entity.UserT;
import com.liao.mall_platform.mapper.Ordinary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


//一般服务


@Service
public class UserAuthService implements UserDetailsService {

    @Resource
    Ordinary override;


    //使用数据库对比的Service服务
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserT u = override.login(s);
        System.out.print(u.getPassword());
        System.out.print(u.getRole());
        if(u.getPassword() == null)
            throw new UsernameNotFoundException("登录失败，用户名或密码错误！");
        return User   //这里需要返回UserDetails，SpringSecurity会根据给定的信息进行比对
                .withUsername(s)
                .password(u.getPassword())   //直接从数据库取的密码
                .roles(u.getRole())   //用户角色
                .build();
    }

}

