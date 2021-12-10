package com.blog.blogservice.mapper;

import com.blog.blogservice.entity.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PostRequestMapperTest {

    @Autowired
    PostRequestMapper mapper;

    PostRequest request = getPostRequest();

    private PostRequest getPostRequest() {
        PostRequest r = new PostRequest();
        Set<TechnicalSkill> skills = new HashSet<>();
        skills.add(new TechnicalSkill("Skill"));
        r.setPostId(1);
        r.setContent("content");
        r.setDepartmentId(1);
        r.setRating(5);
        r.setManagerId(2);
        r.setTechnicalSkills(skills);
        return r;
    }

    @Test
    void createPostFromRequestSuccess() {
        Post actual = mapper.createPostFromRequest(request);
        assertEquals(1, actual.getDepartment().getId());
    }

    @Test
    void updatePostFromRequestSuccess() {
        Post actual = mapper.updatePostFromRequest(request,
                new Post(),
                new Department(),
                new Manager(),
                new Role());
        assertEquals(actual.getClass(), Post.class);
    }

}
