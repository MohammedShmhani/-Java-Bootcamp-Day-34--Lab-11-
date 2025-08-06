package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;


    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void updatePost(Integer id, Post post) {
        Post post1 = postRepository.findPostByPostId(id);
        if (post1 == null) {
            throw new ApiException("POST_NOT_FOUND");
        }
        post1.setCategoryId(post.getCategoryId());
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setUserId(post.getUserId());
        post1.setPublishDate(post.getPublishDate());
        postRepository.save(post1);

    }

    public void deletePost(Integer id) {
        Post post = postRepository.findPostByPostId(id);
        if (post == null) {
            throw new ApiException("POST_NOT_FOUND");
        }
        postRepository.delete(post);
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    //********************************************************************
    //get all post by user_id
    public List<Post> getPostsByUserId(Integer userId) {
        List<Post> posts = postRepository.getPostsByUserId(userId);
        if (posts.isEmpty()) {
            throw new ApiException("POST_NOT_FOUND");
        }
        return posts;
    }
    //********************************************************************

    //********************************************************************
    //Get post by title
    public Post get_post_by_title(String title) {
        Post post = postRepository.get_post_by_title(title);
        if (post == null) {
            throw new ApiException("POST_NOT_FOUND");
        }
        return post;
    }
    //********************************************************************

    //********************************************************************
    //Get All Posts Before a Specific Date
    public List<Post> getAllPostsBeforeSpecificDate(LocalDate localDate) {
        List<Post> posts = postRepository.getAllPostsBeforeSpecificDate(localDate);
        if (posts.isEmpty()) {
            throw new ApiException("POST_NOT_FOUND");
        }
        return posts;
    }
    //********************************************************************

    //********************************************************************
    //Get All Posts by Category
    public List<Post> getPostsByCategoryId(Integer categoryId) {
        List<Post> posts = postRepository.findPostByCategoryId(categoryId);
        if (posts.isEmpty()) {
            throw new ApiException("POST_NOT_FOUND");
        }
        return posts;
    }
    //********************************************************************


}
