package com.blog.blogservice.service;

import com.blog.blogservice.entity.*;
import com.blog.blogservice.mapper.PostRequestMapper;
import com.blog.blogservice.repository.*;
import com.blog.blogservice.utils.AppConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class PostServiceTest {

    @MockBean
    private RepositoryContainer repositoryContainer;
    @MockBean
    private PostRepository postRepository;
    @MockBean
    private DepartmentRepository departmentRepository;
    @MockBean
    private RoleRepository roleRepository;
    @MockBean
    private ManagerRepository managerRepository;


    @MockBean
    private PostRequestMapper mapper;

    @Autowired
    private AppConstants appConstants;

    @Autowired
    private PostService postService = new PostServiceImpl();

    List<Post> posts = getPosts();
    PostRequest request = getPostRequest();
    Optional<Post> optionalPost = getOptionalPost();




    @Test
    void getAllPostsSuccess() {
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAll()).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPosts();
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsByDepartmentIdSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByDepartmentId(2)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByDepartmentId(2);
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsByDepartmentIdNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByDepartmentId(2)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByDepartmentId(2);
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void getAllPostsByDepartmentNameSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByDepartmentName("Name")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByDepartmentName("Name");
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsByDepartmentNameNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByDepartmentName("Name")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByDepartmentName("Name");
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void getAllPostsByManagerIdSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByManagerId(1)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByManagerId(1);
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsByManagerIdNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByManagerId(11)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByManagerId(11);
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void getAllPostsByManagerNameSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByManagerFirstNameAndManagerSurname("first", "second")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByManagerName("first", "second");
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsByManagerNameNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByManagerFirstNameAndManagerSurname("first", "second")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByManagerName("first", "second");
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void getAllPostsBySkillIdSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByTechnicalSkillId(1)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsBySkillId(1);
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsBySkillIdNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByTechnicalSkillId(1)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsBySkillId(1);
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void getAllPostsBySkillDescriptionSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByTechnicalSkillDescription("Desc")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsBySkillDescription("Desc");
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsBySkillDescriptionNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByTechnicalSkillDescription("Desc")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsBySkillDescription("Desc");
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void getAllPostsByRoleIdNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByRoleId(1)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByRoleId(1);
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void getAllPostsByRoleIdSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByRoleId(1)).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByRoleId(1);
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsByRoleDescriptionSuccess(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByRoleDescription("Desc")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByRoleDescription("Desc");
        Assertions.assertTrue(postListResponse.isSuccess());
    }

    @Test
    void getAllPostsByRoleDescriptionNotFound(){
        List<Post> posts = new ArrayList<>();
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findAllByRoleDescription("1")).thenReturn(posts);
        Response<PostList> postListResponse = postService.getAllPostsByRoleDescription("1");
        Assertions.assertTrue(postListResponse.isFailed());
    }

    @Test
    void createPostSuccess() {
        Mockito.when(mapper.createPostFromRequest(request)).thenReturn(new Post());
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.save(Mockito.any(Post.class))).thenReturn(new Post());
        Response response = postService.createPost(request);
        Assertions.assertTrue(response.isSuccess());
    }

    @Test
    void updatePostSuccess() {
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(repositoryContainer.getDepartmentRepository()).thenReturn(departmentRepository);
        Mockito.when(repositoryContainer.getManagerRepository()).thenReturn(managerRepository);
        Mockito.when(repositoryContainer.getRoleRepository()).thenReturn(roleRepository);
        Mockito.when(departmentRepository.getById(Mockito.anyInt())).thenReturn(new Department());
        Mockito.when(managerRepository.getById(Mockito.anyInt())).thenReturn(new Manager());
        Mockito.when(roleRepository.getById(Mockito.anyInt())).thenReturn(new Role());
        Mockito.when(postRepository.findById(Mockito.anyInt())).thenReturn(optionalPost);
        Mockito.when(postRepository.save(Mockito.any(Post.class))).thenReturn(new Post());
        Mockito.when(mapper.updatePostFromRequest(Mockito.any(PostRequest.class),
                Mockito.any(Post.class),
                Mockito.any(Department.class),
                Mockito.any(Manager.class),
                Mockito.any(Role.class))).thenReturn(new Post());
        Response response = postService.updatePost(request);
        Assertions.assertTrue(response.isSuccess());
    }

    @Test
    void updatePostNotFound(){
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Response response = postService.updatePost(request);
        Assertions.assertTrue(response.isFailed());
    }

    @Test
    void deletePostSuccess() {
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findById(Mockito.anyInt())).thenReturn(optionalPost);
        Response response = postService.deletePost(1);
        Assertions.assertTrue(response.isSuccess());
    }

    @Test
    void deletePostNotFound() {
        Mockito.when(repositoryContainer.getPostRepository()).thenReturn(postRepository);
        Mockito.when(postRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Response response = postService.deletePost(1);
        Assertions.assertTrue(response.isFailed());
    }

    Response<PostList> getFailPostListResponse(){
        Response<PostList> failResponse = new Response<>();
        failResponse.setStatus(Response.ResponseStatus.FAILURE);
        return failResponse;
    }

    Response<PostList> getSuccessPostListResponse() {
        Response<PostList> successResponse = new Response<>();
        successResponse.setStatus(Response.ResponseStatus.SUCCESS);
        return successResponse;
    }

    private Response<Post> getFailPostResponse() {
        Response<Post> failResponse = new Response<>();
        failResponse.setStatus(Response.ResponseStatus.FAILURE);
        return failResponse;
    }

    private Response<Post> getSuccessPostResponse() {
        Response<Post> successResponse = new Response<>();
        successResponse.setStatus(Response.ResponseStatus.SUCCESS);
        return successResponse;
    }

    private List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        Department department = new Department();
        Manager manager = new Manager();
        Role role = new Role();
        Post post = new Post(department, manager, role, "content", 5);
        posts.add(post);
        return posts;
    }

    private PostRequest getPostRequest() {
        PostRequest r = new PostRequest();
        r.setPostId(1);
        r.setContent("content");
        r.setDepartmentId(1);
        r.setRating(5);
        r.setManagerId(2);
        return r;
    }

    private Optional<Post> getOptionalPost() {
        return Optional.of(new Post());
    }

}
