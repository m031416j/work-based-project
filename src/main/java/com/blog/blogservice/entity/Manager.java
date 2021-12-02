package com.blog.blogservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "manager_id")
    private Integer id;

    @Column(name = "manager_first_name")
    private String firstName;

    @Column(name = "manager_surname")
    private String surname;

    public Manager(String managerFirstName, String managerSurname) {
        this.firstName = managerFirstName;
        this.surname = managerSurname;
    }

    public Manager(){}

}
