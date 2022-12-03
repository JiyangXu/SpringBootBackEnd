package com.jiyang.common.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"Success"),
    FAIL(201, "Fail"),
    SERVICE_ERROR(2012, "Service Error"),
    DATA_ERROR(204, "Data Error"),
    ILLEGAL_REQUEST(205, "Illegal Request"),
    REPEAT_SUBMIT(206, "Repeat Submit"),
    ARGUMENT_VALID_ERROR(210, "Argument Valid Error"),

    LOGIN_AUTH(208, "Login Auth"),
    PERMISSION(209, "No Permission"),
    ACCOUNT_ERROR(214, "Account Error"),
    PASSWORD_ERROR(215, "Password Error"),
    LOGIN_MOBILE_ERROR( 216, "Login Error"),
    ACCOUNT_STOP( 217, "Account Stop"),
    NODE_ERROR( 218, "Node Error");

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
