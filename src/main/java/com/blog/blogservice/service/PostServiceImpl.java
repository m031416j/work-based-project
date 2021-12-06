package com.blog.blogservice.service;

import com.blog.blogservice.entity.*;
import com.blog.blogservice.mapper.PostRequestMapper;
import com.blog.blogservice.utils.RepositoryContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private RepositoryContainer repositoryContainer;

    @Autowired
    private PostRequestMapper mapper;

    @Override
    public PostList getAllPosts() {
        List<Post> posts = repositoryContainer.getPostRepository().findAll();
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByDepartmentId(Integer id) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByDepartmentId(id);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByDepartmentName(String name) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByDepartmentName(name);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByManagerId(Integer id) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByManagerId(id);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsByManagerName(String firstName, String surname) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByManagerFirstNameAndManagerSurname(firstName, surname);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsBySkillId(Integer id) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByTechnicalSkillId(id);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public PostList getAllPostsBySkillDescription(String description) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByTechnicalSkillDescription(description);
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return postList;
    }

    @Override
    public Post createPost(PostRequest request) {
        Post post = mapper.createPostFromRequest(request);
        return repositoryContainer.getPostRepository().save(post);
    }

    @Override
    public Post updatePost(PostRequest request) {
        Optional<Post> existingPost = repositoryContainer.getPostRepository().findById(request.getPostId());
        if(existingPost.isEmpty()) {
            return null;
        }

        Post updatedPost = mapUpdatedPost(request, existingPost.get());

        return repositoryContainer.getPostRepository().save(updatedPost);

    }

    private Post mapUpdatedPost(PostRequest request, Post existingPost) {
        return mapper.updatePostFromRequest(request,
                existingPost,
                repositoryContainer.getDepartmentRepository().getById(request.getDepartmentId()),
                repositoryContainer.getManagerRepository().getById(request.getManagerId()),
                repositoryContainer.getRoleRepository().getById(request.getRoleId()));
    }
}
