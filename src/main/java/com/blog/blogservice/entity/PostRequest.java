package com.blog.blogservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
public class PostRequest {

    @JsonProperty("postId")
    private Integer postId;

    @JsonProperty("departmentId")
    @NotNull
    private Integer departmentId;

    @JsonProperty("managerId")
    @NotNull
    private Integer managerId;

    @JsonProperty("roleId")
    @NotNull
    private Integer roleId;

    @JsonProperty("technicalSkills")
    @NotNull
    private Set<TechnicalSkill> technicalSkills = new HashSet<>();

    @JsonProperty("content")
    private String content;

    @JsonProperty("rating")
    private Integer rating;

    public PostRequest(){}

    public PostRequest(Integer departmentId, Integer managerId,
                       Integer roleId, Set<TechnicalSkill> technicalSkills,
                       String postContent, Integer postRating) {
        this.departmentId = departmentId;
        this.managerId = managerId;
        this.roleId = roleId;
        this.technicalSkills = technicalSkills;
        this.content = postContent;
        this.rating = postRating;
    }

}
