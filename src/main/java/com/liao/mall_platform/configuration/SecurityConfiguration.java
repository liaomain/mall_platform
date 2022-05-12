package com.liao.mall_platform.configuration;


import com.liao.mall_platform.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Resource
    UserAuthService service;        //数据库支持

    @Resource
    PersistentTokenRepository repository;      //数据源准备(记住我)



    @Bean
    public PersistentTokenRepository jdbcRepository(@Autowired DataSource dataSource){   //jdbc
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();  //使用基于JDBC的实现
        repository.setDataSource(dataSource);   //配置数据源
//        repository.setCreateTableOnStartup(true);   //启动时自动创建用于存储Token的表（建议第一次启动之后删除该行）
        return repository;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(service)   //使用自定义的Service实现类进行验证
                .passwordEncoder(new BCryptPasswordEncoder());   //依然使用BCryptPasswordEncoder
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()   //关闭csrf

                .authorizeRequests()   //首先需要配置哪些请求会被拦截，哪些请求必须具有什么角色才能访问
                .antMatchers("/static/**").permitAll()    //静态资源，使用permitAll来运行任何人访问（注意一定要放在前面）
                .antMatchers("/**").hasRole("user")   //所有请求必须登陆并且是user角色才可以访问（不包含上面的静态资源）
                .and()

                .formLogin()       //配置Form表单登陆
                .loginPage("/login.html")       //登陆页面地址（GET）
                .loginProcessingUrl("/book_manager/login")      //form表单提交地址（POST）
                .defaultSuccessUrl("/homepage.html",true)    //登陆成功后跳转的页面（GET），可以通过Handler实现高度自定义
                .permitAll();



    }




}
