package com.lcd.entiy;


import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Book {
    @TableId(value="book_id")
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookImg;
    private String bookCategory;
    private String bookIntroduction;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String bookTime;
    private String bookLast;




}
