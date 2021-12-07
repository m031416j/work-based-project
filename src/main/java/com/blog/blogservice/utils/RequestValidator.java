package com.blog.blogservice.utils;

import com.blog.blogservice.entity.PostRequest;
import com.blog.blogservice.entity.TechnicalSkill;
import com.blog.blogservice.error.BadRequestException;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class RequestValidator {

    public void validateRequest(PostRequest request) throws Exception {

        Integer departmentId = request.getDepartmentId();
        Integer managerId = request.getManagerId();
        Integer roleId = request.getRoleId();
        Set<TechnicalSkill> technicalSkills = request.getTechnicalSkills();
        String content = request.getContent();
        Integer rating = request.getRating();

        if (departmentId == null ||
        managerId == null || roleId == null ||
        technicalSkills == null || technicalSkills.isEmpty() ||
        content == null || rating == null) {
            String code = "400";
            String msg = "Request cannot have null values";
            throw new BadRequestException(code, msg);
        }

    }




}
