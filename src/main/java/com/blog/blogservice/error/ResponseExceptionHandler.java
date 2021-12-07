package com.blog.blogservice.error;

import com.blog.blogservice.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex, WebRequest request) {
        ErrorResponse er = new ErrorResponse("500", "Internal Server Error");
        return new ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorResponse er = new ErrorResponse(ex.getCode(), ex.getErMessage());
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }
}
