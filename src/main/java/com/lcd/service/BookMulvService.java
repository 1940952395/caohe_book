package com.lcd.service;

import com.lcd.entiy.BookMulv;

import java.util.List;

public interface BookMulvService {


     List<BookMulv> findbyname(Integer bookId);

     BookMulv findbyId(Integer bookmulvId);

}
