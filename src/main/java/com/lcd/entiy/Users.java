package com.lcd.entiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigInteger;

@Data
public class Users {

    @TableId(value = "id",type = IdType.INPUT)
    private Integer Id;
    private String Username;
    private String Password;
    private String Phone;

}
