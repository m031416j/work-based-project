package com.blog.blogservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TechnicalSkill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "technical_skill_id")
    private Integer id;

    @Column(name = "technical_skill_description")
    private String description;

    public TechnicalSkill(String technicalSkillDescription) {
        this.description = technicalSkillDescription;
    }

    public TechnicalSkill(){}

}
