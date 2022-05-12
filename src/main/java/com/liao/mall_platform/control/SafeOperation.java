package com.liao.mall_platform.control;



//此控制类存放权限要求较低的操作

import com.liao.mall_platform.entity.Message;
import com.liao.mall_platform.service.UserAuthService;
import com.liao.mall_platform.entity.UserT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Map;

@Slf4j   //小辣椒的快速使用日志
@RequestMapping("so")  //地址
@Controller  //mvc
@RestController
public class SafeOperation {

    @Resource
    UserAuthService userAuthService;




//    @RequestMapping(value = "login", method = RequestMethod.POST)//或者post
//    public void demo1(@RequestBody UserT U) {
//
//        System.out.print("你来了ssss....................");
//
//    }


//    @RequestMapping(value = "login", method = RequestMethod.POST)//或者post
//    public Message demo1d(@RequestBody UserT U) {
//        Message message=new Message();
//        message.setZt("0");
//        message.setXx("mei");
//
//
//        return message;
//
//    }


//    @RequestMapping(value = "login", method = RequestMethod.POST)//或者post

    @PostMapping(path = "login")
    public Message demo1d(@RequestBody UserT u) {
        Message message=new Message();
        message.setZt("0");
        message.setXx("mei");
        System.out.print("ss");


        System.out.println("你来了"+u.getName());

        int ui=u.getId()+1;
        System.out.print("你来了"+ui);


        return message;

    }


    @PostMapping(path = "s")
    public Message demo1ds(@RequestBody Map<String, String> person) {
        Message message=new Message();
        message.setZt("0");
        message.setXx("mei");
        System.out.print("ss");
        return message;

    }




}
