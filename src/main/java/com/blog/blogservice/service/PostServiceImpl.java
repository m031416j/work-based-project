package com.blog.blogservice.service;

import com.blog.blogservice.entity.*;
import com.blog.blogservice.mapper.PostRequestMapper;
import com.blog.blogservice.utils.AppConstants;
import com.blog.blogservice.utils.RepositoryContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private RepositoryContainer repositoryContainer;

    @Autowired
    private PostRequestMapper mapper;

    @Autowired
    private AppConstants appConstants;


    @Override
    public Response<PostList> getAllPosts() {
        List<Post> posts = repositoryContainer.getPostRepository().findAll();
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return Response.of(postList);
    }

    @Override
    public Response<PostList> getAllPostsByDepartmentId(Integer id) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByDepartmentId(id);
        if(posts.isEmpty()) {
            return handleError(appConstants.getErrorRes().getNotFoundCode(), String.format("No posts found with department id: %s", id));
        }
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return Response.of(postList);
    }

    @Override
    public Response<PostList> getAllPostsByDepartmentName(String name) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByDepartmentName(name);
        if(posts.isEmpty()) {
            return handleError(appConstants.getErrorRes().getNotFoundCode(), String.format("No posts found with department name: %s", name));
        }
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return Response.of(postList);
    }

    @Override
    public Response<PostList> getAllPostsByManagerId(Integer id) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByManagerId(id);
        if(posts.isEmpty()) {
            return handleError(appConstants.getErrorRes().getNotFoundCode(), String.format("No posts found with manager id: %s", id));
        }
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return Response.of(postList);
    }

    @Override
    public Response<PostList> getAllPostsByManagerName(String firstName, String surname) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByManagerFirstNameAndManagerSurname(firstName, surname);
        if(posts.isEmpty()) {
            return handleError(appConstants.getErrorRes().getNotFoundCode(), String.format("No posts found with manager name: %s %s", firstName, surname));
        }
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return Response.of(postList);
    }

    @Override
    public Response<PostList> getAllPostsBySkillId(Integer id) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByTechnicalSkillId(id);
        if(posts.isEmpty()) {
            return handleError(appConstants.getErrorRes().getNotFoundCode(), String.format("No posts found with skill id: %s", id));
        }
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return Response.of(postList);
    }

    @Override
    public Response<PostList> getAllPostsBySkillDescription(String description) {
        List<Post> posts = repositoryContainer.getPostRepository().findAllByTechnicalSkillDescription(description);
        if(posts.isEmpty()) {
            return handleError(appConstants.getErrorRes().getNotFoundCode(), String.format("No post found with skill description: %s", description));
        }
        PostList postList = new PostList();
        postList.getPosts().addAll(posts);
        return Response.of(postList);
    }

    @Override
    public Response<Post> createPost(PostRequest request) {
        Post post = mapper.createPostFromRequest(request);
        return Response.of(repositoryContainer.getPostRepository().save(post));
    }

    @Override
    public Response updatePost(PostRequest request) {
        Optional<Post> existingPost = repositoryContainer.getPostRepository().findById(request.getPostId());
        if(existingPost.isEmpty()) {
            return handleError(appConstants.getErrorRes().getNotFoundCode(), String.format("No post found with id: %s", request.getPostId()));
        }
        Post updatedPost = mapUpdatedPost(request, existingPost.get());
        return Response.of(repositoryContainer.getPostRepository().save(updatedPost));
    }

    @Override
    public Response deletePost(Integer postId) {
        repositoryContainer.getPostRepository().deleteById(postId);
        Response response = new Response();
        response.setStatus(Response.ResponseStatus.SUCCESS);
        return response;
    }

    private Post mapUpdatedPost(PostRequest request, Post existingPost) {
        return mapper.updatePostFromRequest(request,
                existingPost,
                repositoryContainer.getDepartmentRepository().getById(request.getDepartmentId()),
                repositoryContainer.getManagerRepository().getById(request.getManagerId()),
                repositoryContainer.getRoleRepository().getById(request.getRoleId()));
    }

    private Response handleError(String code, String message) {
        return Response.errorRes(code, message);
    }
}
