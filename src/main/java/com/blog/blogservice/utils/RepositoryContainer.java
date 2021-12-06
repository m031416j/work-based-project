package com.blog.blogservice.utils;

import com.blog.blogservice.repository.DepartmentRepository;
import com.blog.blogservice.repository.ManagerRepository;
import com.blog.blogservice.repository.PostRepository;
import com.blog.blogservice.repository.RoleRepository;

public interface RepositoryContainer {

    PostRepository getPostRepository();
    RoleRepository getRoleRepository();
    DepartmentRepository getDepartmentRepository();
    ManagerRepository getManagerRepository();

}
