package com.blog.blogservice.utils;

import com.blog.blogservice.entity.PostRequest;
import com.blog.blogservice.entity.TechnicalSkill;
import com.blog.blogservice.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class RequestValidator {

    @Autowired
    AppConstants appConstants;

    public void validatePostRequest(PostRequest request) throws Exception {

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
            String code = appConstants.getErrorRes().getBadRequestCode();
            String msg = "Request cannot have null values";
            throw new BadRequestException(code, msg);
        }

    }

    public void validatePutRequest(PostRequest request) throws Exception {

        Integer postId = request.getPostId();

        validatePostRequest(request);

        if (postId == null) {
            String code = appConstants.getErrorRes().getBadRequestCode();
            String msg = "Request is missing the post ID";
            throw new BadRequestException(code, msg);
        }

    }




}
