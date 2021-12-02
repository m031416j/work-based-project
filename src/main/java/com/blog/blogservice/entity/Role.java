package com.blog.blogservice.entity;

import lombok.Data;
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
    private Integer roleId;

    @Column(name = "role_description")
    private String roleDescription;

    public Role(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Role(){}

}
