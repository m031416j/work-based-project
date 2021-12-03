package com.blog.blogservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "post_id")
    @JsonProperty("postId")
    private Integer postId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_department", referencedColumnName = "department_id")
    @JsonProperty("department")
    @NotNull
    private Department department;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_manager", referencedColumnName = "manager_id")
    @JsonProperty("manager")
    @NotNull
    private Manager manager;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_role", referencedColumnName = "role_id")
    @JsonProperty("role")
    @NotNull
    private Role role;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "post_technical_skill",
            joinColumns = { @JoinColumn(name = "post_id")},
            inverseJoinColumns = { @JoinColumn(name = "technical_skill_id")})
    @JsonProperty("technicalSkills")
    @NotNull
    private Set<TechnicalSkill> technicalSkill = new HashSet<>();

    @Column(name = "post_content", columnDefinition = "TEXT")
    @JsonProperty("content")
    private String postContent;

    @Column(name = "post_rating")
    @JsonProperty("rating")
    private Integer postRating;

    public Post(Department department, Manager manager, Role role, String postContent, Integer postRating) {
        this.department = department;
        this.manager = manager;
        this.role = role;
        this.postContent = postContent;
        this.postRating = postRating;
    }

    public Post(){}
}
