package com.blog.blogservice.controller;

import com.blog.blogservice.entity.*;
import com.blog.blogservice.service.PostService;
import com.blog.blogservice.utils.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
@RestController
@RequestMapping(path = "/v1/api/blog/post")
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private RequestValidator requestValidator;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostList> getAllPosts() {
        Response<PostList> response = postService.getAllPosts();
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    @GetMapping(path = "/department/{id}")
    public ResponseEntity<PostList> getAllPostsByDepartmentId(@PathVariable Integer id) {
        Response<PostList> response = postService.getAllPostsByDepartmentId(id);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    @GetMapping(path = "/department/name/")
    public ResponseEntity<PostList> getAllPostsByDepartmentName(@RequestParam(value="name") String name) {
        Response<PostList> response = postService.getAllPostsByDepartmentName(name);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    @GetMapping(path = "/manager/{id}")
    public ResponseEntity<PostList> getAllPostsByManagerId(@PathVariable Integer id) {
        Response<PostList> response = postService.getAllPostsByManagerId(id);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    @GetMapping(path = "/manager/name/")
    public ResponseEntity<PostList> getAllPostsByManagerName(@RequestParam(value="firstName") String firstName,@RequestParam(value="surname") String surname ) {
        Response<PostList> response = postService.getAllPostsByManagerName(firstName, surname);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    @GetMapping(path = "/skills/{id}")
    public ResponseEntity<PostList> getAllPostsBySkillId(@PathVariable Integer id) {
        Response<PostList> response = postService.getAllPostsBySkillId(id);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    @GetMapping(path = "/skills/description/")
    public ResponseEntity<PostList> getAllPostsBySkillDescription(@RequestParam(value = "description") String description) {
        Response<PostList> response = postService.getAllPostsBySkillDescription(description);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest request) throws Exception {
        requestValidator.validateRequest(request);
        Response<Post> response = postService.createPost(request);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.CREATED);
        }
        return handleError(response);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody PostRequest request) {
        Response<Post> response = postService.updatePost(request);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.CREATED);
        }
        return handleError(response);
    }

    @DeleteMapping
    public ResponseEntity<Post> deletePost(@RequestParam(value = "postId") Integer postId){
        Response<Post> response = postService.deletePost(postId);
        if(response.isSuccess()) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
        return handleError(response);
    }

    private ResponseEntity handleError(Response response) {
        ErrorResponse er = new ErrorResponse();
        er.setCode(response.getCode());
        er.setMessage(response.getMessage());
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if(er.getCode().equals("400")){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(er, status);
        }
        return new ResponseEntity<>(er, status);
    }
}
