package com.lcd.vo;

import lombok.Data;

import java.util.List;

@Data
public class Result<T> {

    private Boolean status = true;
    private String msg;
    private List<T> data;
}
