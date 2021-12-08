package com.blog.blogservice.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class BadRequestException extends Exception {

    private String code;
    private String erMessage;

    public BadRequestException(String code, String erMessage) {
        this.code=code;
        this.erMessage=erMessage;
    }

    public BadRequestException(){}


}
