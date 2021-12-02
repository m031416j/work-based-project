package com.blog.blogservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostList {

    private List<Post> posts = new ArrayList<>();

}
