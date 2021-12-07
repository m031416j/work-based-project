package com.blog.blogservice.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:constants.properties")
@PropertySource(value = "file:./config/constants.properties", ignoreResourceNotFound = true)@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppConstants {

    private ErrorRes errorRes;

    @Getter
    @Setter
    public static class ErrorRes {
        private String internalErrorCode;
        private String badRequestCode;
        private String notFoundCode;
    }
}
