package com.ffmusic.exception;


import lombok.Data;

@Data
public class ErrorResponse {
    private Integer code;
    private String message;
    private Object trace;
}
