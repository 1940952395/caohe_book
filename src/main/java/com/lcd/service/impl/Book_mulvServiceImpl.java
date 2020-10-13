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
    public BookMulv findbyId(Integer bookmulvId) {
        BookMulv bookMulv = bookMulvMapper.selectById(bookmulvId);
        return bookMulv;
    }

    @Override
    public List<BookMulv> findbyname(Integer bookId) {
        QueryWrapper<BookMulv> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_number",bookId);
        List<BookMulv> bookMulvs = bookMulvMapper.selectList(queryWrapper);
        return bookMulvs;
    }
}
