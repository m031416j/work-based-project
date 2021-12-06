package com.blog.blogservice.entity;

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
    private Integer postId;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_department", referencedColumnName = "department_id")
    private Department department;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_manager", referencedColumnName = "manager_id")
    private Manager manager;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_role", referencedColumnName = "role_id")
    private Role role;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "post_technical_skill",
            joinColumns = { @JoinColumn(name = "post_id")},
            inverseJoinColumns = { @JoinColumn(name = "technical_skill_id")})
    private Set<TechnicalSkill> technicalSkill = new HashSet<>();

    @Column(name = "post_content", columnDefinition = "TEXT")
    private String postContent;

    @Column(name = "post_rating")
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
