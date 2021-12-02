package com.blog.blogservice.service;

import com.blog.blogservice.entity.Post;
import com.blog.blogservice.entity.PostList;
import com.blog.blogservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostList getAllPosts() {
        List<Post> posts = postRepository.findAll();
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByDepartmentId(Integer id) {
        List<Post> posts = postRepository.findAllByDepartmentId(id);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByDepartmentName(String name) {
        List<Post> posts = postRepository.findAllByDepartmentName(name);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByManagerId(Integer id) {
        List<Post> posts = postRepository.findAllByManagerId(id);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByManagerName(String firstName, String surname) {
        List<Post> posts = postRepository.findAllByManagerFirstNameAndManagerSurname(firstName, surname);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsBySkillId(Integer id) {
        List<Post> posts = postRepository.findAllByTechnicalSkillId(id);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsBySkillDescription(String description) {
        List<Post> posts = postRepository.findAllByTechnicalSkillDescription(description);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }
}
