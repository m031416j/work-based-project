package com.blog.blogservice.repository;

import com.blog.blogservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByDepartmentId(Integer id);

    List<Post> findAllByDepartmentName(String name);

    List<Post> findAllByManagerId(Integer id);

    List<Post> findAllByManagerFirstNameAndManagerSurname(String firstName, String surname);

    List<Post> findAllByTechnicalSkillId(Integer id);

    List<Post> findAllByTechnicalSkillDescription(String description);

    List<Post> findAllByRoleId(Integer id);

    List<Post> findAllByRoleDescription(String description);
}
