package com.blog.blogservice.repository;

public interface RepositoryContainer {

    PostRepository getPostRepository();
    RoleRepository getRoleRepository();
    DepartmentRepository getDepartmentRepository();
    ManagerRepository getManagerRepository();

}
