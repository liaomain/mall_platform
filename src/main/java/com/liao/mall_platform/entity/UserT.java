package com.liao.mall_platform.entity;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class UserT {

    public int id;
    public String name;
    public String password;
    public String role;


}
