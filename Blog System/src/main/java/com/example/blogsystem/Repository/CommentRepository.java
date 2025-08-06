package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findCommentByCommentId(Integer commentId);

    //****************************************************
    //Get All Comments for a Specific User
    List<Comment> findCommentByUserId(Integer userId);
    //****************************************************

    //****************************************************
    //Get All Comments for a Specific Post
    List<Comment> findCommentByPostId(Integer postId);
    //****************************************************


}
