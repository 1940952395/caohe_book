package com.lcd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lcd.entiy.BookMulv;
import com.lcd.mapper.BookMulvMapper;
import com.lcd.service.BookMulvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book_mulvServiceImpl implements BookMulvService {

    @Autowired
    private BookMulvMapper bookMulvMapper;


    @Override
    public List<BookMulv> findbyname(String bookName) {
        QueryWrapper<BookMulv> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BookMulv::getBookName,bookName);
        List<BookMulv> bookMulvs = bookMulvMapper.selectList(queryWrapper);
        return bookMulvs;
    }
}
