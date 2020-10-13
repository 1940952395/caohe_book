package com.lcd.entiy;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BookMulv {

    @TableId(value="book_id")
    private Integer bookId;
    private String bookName;
    private String bookDirectory;
    private Integer bookNumber;
}
