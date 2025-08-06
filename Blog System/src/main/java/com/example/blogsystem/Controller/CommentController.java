package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/COMMENT")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/GET")
    public ResponseEntity<?> getComments() {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllComments());
    }

    @PostMapping("/ADD")
    public ResponseEntity<?> addComment(@Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        commentService.addComment(comment);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Successfully added comment"));
    }

    @DeleteMapping("/DELETE/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Successfully deleted comment"));
    }

    @PutMapping("/UPDATE/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer id, @Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Successfully updated comment"));
    }

    //******************************************************************************************************
    //Get All Comments for a Specific User
    @GetMapping("/USER/{userId}")
    public ResponseEntity<?> findCommentByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findCommentByUserId(userId));
    }
    //******************************************************************************************************

    //******************************************************************************************************
    //    //Get All Comments for a Specific Post
    @GetMapping("/POST/{postId}")
    public ResponseEntity<?> findCommentByPostId(@PathVariable Integer postId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findCommentByPostId(postId));
    }
    //******************************************************************************************************

}
