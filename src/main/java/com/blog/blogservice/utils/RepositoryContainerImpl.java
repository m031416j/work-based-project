package com.blog.blogservice.utils;

import com.blog.blogservice.repository.DepartmentRepository;
import com.blog.blogservice.repository.ManagerRepository;
import com.blog.blogservice.repository.PostRepository;
import com.blog.blogservice.repository.RoleRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class RepositoryContainerImpl implements RepositoryContainer {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ManagerRepository managerRepository;

}
