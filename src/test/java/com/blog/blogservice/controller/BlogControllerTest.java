package com.blog.blogservice.controller;

import com.blog.blogservice.entity.Post;
import com.blog.blogservice.entity.PostList;
import com.blog.blogservice.entity.Response;
import com.blog.blogservice.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;

import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @Value("classpath:data/postRequestForSuccess.json")
    Resource postRequestForSuccess;

    @Value("classpath:data/postRequestForBadRequest.json")
    Resource postRequestForBadRequest;

    @Value("classpath:data/putRequestForSuccess.json")
    Resource putRequestForSuccess;

    @Value("classpath:data/putRequestForBadRequest.json")
    Resource putRequestForBadRequest;


    private final String baseUri = "/v1/api/blog/post";

    Response<PostList> successPostListResponse = getSuccessPostListResponse();
    Response<PostList> failPostListResponse = getFailPostListResponse();
    Response<Post> successPostResponse = getSuccessPostResponse();



    Response<Post> failPostResponse = getFailPostResponse();


    @Test
    void getAllPosts_SuccessResponse() throws Exception {
        Mockito.when(postService.getAllPosts()).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsByDepartmentId_SuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsByDepartmentId(1)).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/department/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsByDepartmentId_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsByDepartmentId(1)).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/department/111"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getAllPostsByDepartmentName_SuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsByDepartmentName("Microservices")).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/department/name/")
                        .param("name", "Microservices"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsByDepartmentName_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsByDepartmentName("Microservicesss")).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/department/name/")
                .param("name", "Microservicesss"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getAllPostsByManagerId_SuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsByManagerId(1)).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/manager/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsByManagerId_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsByManagerId(111)).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/manager/111"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getAllPostsByManagerNameSuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsByManagerName("Iron", "Man")).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/manager/name/")
                        .param("firstName", "Iron").param("surname", "Man"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsByManagerName_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsByManagerName("Iron", "Mann")).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/manager/name/")
                        .param("firstName", "Iron").param("surname", "Mann"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getAllPostsBySkillIdSuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsBySkillId(1)).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/skills/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsBySkillId_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsBySkillId(1111)).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/skills/1111"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getAllPostsBySkillDescriptionSuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsBySkillDescription("HTML")).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/skills/description/").param("description", "HTML"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsBySkillDescription_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsBySkillDescription("HTMLLL")).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/skills/description/").param("description", "HTMLLL"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getAllPostsByRoleIdSuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsByRoleId(1)).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/role/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsByRoleId_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsByRoleId(111)).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/role/111"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getAllPostsByRoleDescriptionSuccessResponse() throws Exception {
        Mockito.when(postService.getAllPostsByRoleDescription("Software Development")).thenReturn(successPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/role/description/")
                        .param("description", "Software Development"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllPostsByRoleDescription_NotFound() throws Exception {
        failPostListResponse.setCode("404");
        Mockito.when(postService.getAllPostsByRoleDescription("Software Developmenting")).thenReturn(failPostListResponse);
        mockMvc.perform(MockMvcRequestBuilders.get(baseUri+"/role/description/")
                        .param("description", "Software Developmenting"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void createPostSuccess() throws Exception {
        Mockito.when(postService.createPost(any())).thenReturn(successPostResponse);
        mockMvc.perform(MockMvcRequestBuilders.post(baseUri)
                        .header("Content-Type","application/json;charset=utf-8")
                .content(new String(Files.readAllBytes(postRequestForSuccess.getFile().toPath()))))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void createPost_BadRequest() throws Exception {
        failPostResponse.setCode("400");
        Mockito.when(postService.createPost(any())).thenReturn(failPostResponse);
        mockMvc.perform(MockMvcRequestBuilders.post(baseUri)
                        .header("Content-Type","application/json;charset=utf-8")
                        .content(new String(Files.readAllBytes(postRequestForBadRequest.getFile().toPath()))))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void updatePostSuccess() throws Exception {
        Mockito.when(postService.updatePost(any())).thenReturn(successPostResponse);
        mockMvc.perform(MockMvcRequestBuilders.put(baseUri)
                        .header("Content-Type","application/json;charset=utf-8")
                        .content(new String(Files.readAllBytes(putRequestForSuccess.getFile().toPath()))))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updatePost_BadRequest() throws Exception {
        failPostListResponse.setCode("400");
        Mockito.when(postService.updatePost(any())).thenReturn(failPostResponse);
        mockMvc.perform(MockMvcRequestBuilders.put(baseUri)
                        .header("Content-Type","application/json;charset=utf-8")
                        .content(new String(Files.readAllBytes(putRequestForBadRequest.getFile().toPath()))))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void deletePostSuccess() throws Exception {
        Mockito.when(postService.deletePost(35)).thenReturn(successPostResponse);
        mockMvc.perform(MockMvcRequestBuilders.delete(baseUri).param("postId", "35"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deletePost_NotFound() throws Exception {
        failPostResponse.setCode("404");
        Mockito.when(postService.deletePost(3000)).thenReturn(failPostResponse);
        mockMvc.perform(MockMvcRequestBuilders.delete(baseUri).param("postId", "3000"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
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

}
