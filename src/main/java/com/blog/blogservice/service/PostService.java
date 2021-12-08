package com.blog.blogservice.service;

import com.blog.blogservice.entity.Post;
import com.blog.blogservice.entity.PostList;
import com.blog.blogservice.entity.PostRequest;
import com.blog.blogservice.entity.Response;

public interface PostService {

    Response<PostList> getAllPosts();

    Response<PostList> getAllPostsByDepartmentId(Integer id);

    Response<PostList> getAllPostsByDepartmentName(String name);

    Response<PostList> getAllPostsByManagerId(Integer id);

    Response<PostList> getAllPostsByManagerName(String firstName, String surname);

    Response<PostList> getAllPostsBySkillId(Integer id);

    Response<PostList> getAllPostsBySkillDescription(String description);

    Response<Post> createPost(PostRequest request);

    Response<Post> updatePost(PostRequest request);

    Response<Post> deletePost(Integer postId);

    Response<PostList> getAllPostsByRoleId(Integer id);

    Response<PostList> getAllPostsByRoleDescription(String description);
}
