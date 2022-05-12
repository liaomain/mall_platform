package com.liao.mall_platform.mapper;


import com.liao.mall_platform.entity.UserT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Ordinary {

    @Select(value = { "SELECT * FROM `user` WHERE name=#{name}" })
    public UserT login(@Param(value = "name") String name);
}
