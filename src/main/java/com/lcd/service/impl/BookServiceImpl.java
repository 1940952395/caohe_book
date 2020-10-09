package com.lcd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lcd.entiy.Book;
import com.lcd.mapper.BookMapper;
import com.lcd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book findbookId(int id) {
       Book  book = bookMapper.selectById(id);
        return book;
    }
}
