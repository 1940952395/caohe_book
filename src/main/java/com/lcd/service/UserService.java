package com.lcd.service;

import com.lcd.entiy.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    //查看所有用户
    public List<Users> findAll();

    //注册功能
    public Boolean save(Users users);

    //用户验证
    public Users finduser(String username);


}
