package com.blog.blogservice.service;

import com.blog.blogservice.entity.PostList;

public interface PostService {

    PostList getAllPosts();

    PostList getAllPostsByDepartmentId(Integer id);

    PostList getAllPostsByDepartmentName(String name);

    PostList getAllPostsByManagerId(Integer id);

    PostList getAllPostsByManagerName(String firstName, String surname);

    PostList getAllPostsBySkillId(Integer id);

    PostList getAllPostsBySkillDescription(String description);
}
