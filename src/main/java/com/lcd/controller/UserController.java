package com.lcd.controller;

import com.lcd.entiy.Users;
import com.lcd.utils.IO;
import com.lcd.vo.Result;
import com.lcd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.xml.ws.Response;
import javax.xml.ws.Service;
import java.io.IOException;


@Transactional
@Controller
public class UserController {




    @Autowired
    private UserService userService;



    @ResponseBody
    @RequestMapping("/findusers")
    public Result findusers(){
        Result result = new Result();
       try{
           result.setData(userService.findAll());
           result.setMsg("查找用户信息成功");
       }catch (Exception e){
           result.setStatus(false);
           result.setMsg("查找用户信息失败");
       }
       return result;
    }


    //注册
    @ResponseBody
    @RequestMapping("/save")
    public Boolean save(Users users)  {
        userService.save(users);
        return true;
    }

    @ResponseBody
    @RequestMapping("/login")
    public Boolean login(Users users)  {
        return true;
    }

    //跳转注册
    @RequestMapping("/toregist")
    public String toregist(){
        return "regist";
    }

    //跳转登录
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }


}
