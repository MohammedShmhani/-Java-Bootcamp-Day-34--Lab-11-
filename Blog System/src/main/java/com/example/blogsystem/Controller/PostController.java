package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/POST")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/GET")
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok().body(postService.getPosts());
    }

    @PostMapping("/ADD")
    public ResponseEntity<?> addPost(@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        postService.addPost(post);
        return ResponseEntity.ok().body(new ApiResponse("POST_ADDED"));
    }

    @PutMapping("/UPDATE/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer id, @Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        postService.updatePost(id, post);
        return ResponseEntity.ok().body(new ApiResponse("POST_UPDATED"));
    }

    @DeleteMapping("/DELETE/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.ok().body(new ApiResponse("POST_DELETED"));
    }

    //****************************************************************************************
    //get all post by user_id
    @GetMapping("/s/{userId}")
    public ResponseEntity<?> getPostsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(postService.getPostsByUserId(userId));
    }
    //****************************************************************************************


    //****************************************************************************************
    //Get post by title
    @GetMapping("/BY/TITLE/{title}")
    public ResponseEntity<?> get_post_by_title(@PathVariable String title) {
        return ResponseEntity.ok().body(postService.get_post_by_title(title));
    }
    //****************************************************************************************


    //****************************************************************************************
    //Get All Posts Before a Specific Date
    @GetMapping("/s/BY/{localDate}")
    public ResponseEntity<?> getAllPostsBeforeSpecificDate(@PathVariable LocalDate localDate) {
        return ResponseEntity.ok().body(postService.getAllPostsBeforeSpecificDate(localDate));
    }
    //****************************************************************************************


    //****************************************************************************************
    //Get All Posts by Category
    @GetMapping("/s/CATEGORY/{categoryId}")
    public ResponseEntity<?> getPostsByCategoryId(@PathVariable Integer categoryId) {
        return ResponseEntity.ok().body(postService.getPostsByCategoryId(categoryId));
    }
    //****************************************************************************************


}
