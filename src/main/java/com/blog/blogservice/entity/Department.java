package com.blog.blogservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Integer id;

    @Column(name = "department_name")
    private String name;

    public Department(String departmentName) {
        this.name = departmentName;
    }

    public Department(){}
}
