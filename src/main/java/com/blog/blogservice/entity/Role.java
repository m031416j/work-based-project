package com.blog.blogservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_description")
    private String description;

    public Role(String description) {
        this.description = description;
    }

    public Role(){}

}
