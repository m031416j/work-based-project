package com.blog.blogservice.mapper;

import com.blog.blogservice.entity.*;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
public class PostRequestMapper {

    public Post createPostFromRequest(PostRequest request) {
        Post post = new Post();
        Department d = new Department();
        Manager m = new Manager();
        Role r = new Role();
        d.setId(request.getDepartmentId());
        m.setId(request.getManagerId());
        r.setRoleId(request.getRoleId());
        Set<TechnicalSkill> skills = new HashSet<>(request.getTechnicalSkills());
        post.setDepartment(d);
        post.setManager(m);
        post.setRole(r);
        post.setTechnicalSkill(skills);
        post.setPostContent(request.getContent());
        post.setPostRating(request.getRating());
        return post;
    }

//    public Post updatePostFromRequest(PostRequest request, Post post) {
//        Department department = new Department();
//        Manager manager = new Manager();
//        Role role = new Role();
//        Set<TechnicalSkill> skills = new HashSet<>(request.getTechnicalSkills());
//        department.setId(request.getDepartmentId());
//        manager.setId(request.getManagerId());
//        role.setRoleId(request.getRoleId());
//        Post post = new Post(department,manager,role, request.getContent(), request.getRating());
//        post.setTechnicalSkill(skills);
//        return post;
//    }

//    public Post updatePostFromRequest(PostRequest request, Post post) {
//        post.setPostRating(request.getRating());
//        post.setPostContent(request.getContent());
//        post.getManager().setId(request.getManagerId());
//        post.getRole().setRoleId(request.getRoleId());
//        post.getDepartment().setId(request.getDepartmentId());
//        return post;
//    }

    public Post updatePostFromRequest(PostRequest request, Post post, Department d, Manager m, Role r) {
        post.setPostRating(request.getRating());
        post.setPostContent(request.getContent());
        post.setManager(m);
        post.setDepartment(d);
        post.setRole(r);
        post.setTechnicalSkill(request.getTechnicalSkills());
        return post;
    }
}
