package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public void updateComment(Integer id, Comment comment) {
        Comment c1 = commentRepository.findCommentByCommentId(id);
        if (c1 == null) {
            throw new ApiException("COMMENT_NOT_FOUND");
        }
        c1.setCommentDate(comment.getCommentDate());
        c1.setUserId(comment.getUserId());
        c1.setContent(comment.getContent());
        c1.setPostId(comment.getPostId());
        commentRepository.save(c1);

    }

    public void deleteComment(Integer id) {
        Comment c1 = commentRepository.findCommentByCommentId(id);
        if (c1 == null) {
            throw new ApiException("COMMENT_NOT_FOUND");
        }
        commentRepository.delete(c1);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    //***************************************************************************
    //Get All Comments for a Specific User
    public List<Comment> findCommentByUserId(Integer userId) {
        List<Comment> comment = commentRepository.findCommentByUserId(userId);
        if (comment.isEmpty()) {
            throw new ApiException("COMMENT_NOT_FOUND");
        }
        return comment;
    }
    //***************************************************************************


    //***************************************************************************
    //Get All Comments for a Specific Post
    public List<Comment> findCommentByPostId(Integer postId) {
        List<Comment> comment = commentRepository.findCommentByPostId(postId);
        if (comment.isEmpty()) {
            throw new ApiException("COMMENT_NOT_FOUND");
        }
        return comment;
    }
    //***************************************************************************

}
