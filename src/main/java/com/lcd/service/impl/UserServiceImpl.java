package com.lcd.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lcd.entiy.Users;
import com.lcd.mapper.UserMapper;
import com.lcd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> findAll() {
        List<Users> list = new ArrayList<>();
        list = userMapper.selectList(null);
        return list;

    }
    //登录验证
    @Override
    public Users finduser(String username) {
        QueryWrapper<Users>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Users users = userMapper.selectOne(queryWrapper);
        return users;
    }
    //注册功能
    @Override
    public Boolean save(Users users) {
        userMapper.insert(users);
        return true;
    }
}
