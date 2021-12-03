package com.blog.blogservice.service;

import com.blog.blogservice.entity.Post;
import com.blog.blogservice.entity.PostList;
import com.blog.blogservice.entity.PostRequest;

public interface PostService {

    PostList getAllPosts();

    PostList getAllPostsByDepartmentId(Integer id);

    PostList getAllPostsByDepartmentName(String name);

    PostList getAllPostsByManagerId(Integer id);

    PostList getAllPostsByManagerName(String firstName, String surname);

    PostList getAllPostsBySkillId(Integer id);

    PostList getAllPostsBySkillDescription(String description);

    Post createPost(PostRequest request);

    Post updatePost(PostRequest request);
}
