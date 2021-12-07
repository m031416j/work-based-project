package com.blog.blogservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {

    private T data;
    private ResponseStatus status;
    private String message;
    private String code;

    public enum ResponseStatus {
        SUCCESS, FAILURE
    }

    public Response() {
    }

    public Response(T data) {
        super();
        this.data = data;
    }

    public static <T> Response<T> of(T t) {
        Response<T> response = new Response<>(t);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    @SuppressWarnings({ "rawtypes"})
    public static <T> Response<T> errorRes(Response response) {
        Response<T> rb = new Response<>();
        rb.setStatus(response.getStatus());
        rb.setMessage(response.getMessage());
        rb.setCode(response.getCode());
        return rb;
    }

    @SuppressWarnings({ "rawtypes" })
    public static Response errorRes(String code, String message) {
        Response r = new Response();
        r.setStatus(ResponseStatus.FAILURE);
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public boolean isFailed() {
        return ResponseStatus.FAILURE.equals(this.status);
    }

    public boolean isSuccess() {
        return ResponseStatus.SUCCESS.equals(this.status);
    }

}
