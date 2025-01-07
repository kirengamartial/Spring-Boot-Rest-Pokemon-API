package com.example.demo.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObject {
    private int status;
    private String message;
    private Date date;
}
