package com.blog.blogservice.controller;

import com.blog.blogservice.entity.Post;
import com.blog.blogservice.entity.PostList;
import com.blog.blogservice.entity.PostRequest;
import com.blog.blogservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/api/blog/post")
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostList> getAllPosts() {
        PostList postList = postService.getAllPosts();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping(path = "/department/{id}")
    public ResponseEntity<PostList> getAllPostsByDepartmentId(@PathVariable Integer id) {
        PostList postList = postService.getAllPostsByDepartmentId(id);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping(path = "/department/name/")
    public ResponseEntity<PostList> getAllPostsByDepartmentName(@RequestParam(value="name") String name) {
        PostList postList = postService.getAllPostsByDepartmentName(name);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping(path = "/manager/{id}")
    public ResponseEntity<PostList> getAllPostsByManagerId(@PathVariable Integer id) {
        PostList postList = postService.getAllPostsByManagerId(id);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping(path = "/manager/name/")
    public ResponseEntity<PostList> getAllPostsByManagerName(@RequestParam(value="firstName") String firstName,@RequestParam(value="surname") String surname ) {
        PostList postList = postService.getAllPostsByManagerName(firstName, surname);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping(path = "/skills/{id}")
    public ResponseEntity<PostList> getAllPostsBySkillId(@PathVariable Integer id) {
        PostList postList = postService.getAllPostsBySkillId(id);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping(path = "/skills/description/")
    public ResponseEntity<PostList> getAllPostsBySkillDescription(@RequestParam(value = "description") String description) {
        PostList postList = postService.getAllPostsBySkillDescription(description);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest request) {
        Post p = postService.createPost(request);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody PostRequest request) {
        Post p = postService.updatePost(request);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam(value = "postId") Integer postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
