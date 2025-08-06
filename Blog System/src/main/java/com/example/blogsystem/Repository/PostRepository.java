package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostByPostId(Integer postId);


    //***************************************************
    //get all post by user_id
    @Query("select p FROM Post p WHERE p.userId=?1")
    List<Post> getPostsByUserId(Integer userId);
    //***************************************************

    //***************************************************
    //Get post by title
    @Query("SELECT p from Post p WHERE p.title=?1")
    Post get_post_by_title(String title);
    //***************************************************

    //***************************************************
    //Get All Posts Before a Specific Date
    @Query("SELECT p FROM Post p WHERE p.publishDate < ?1")
    List<Post> getAllPostsBeforeSpecificDate(LocalDate localDate);
    //***************************************************


    //***************************************************
    // Get All Posts by Category
    List<Post> findPostByCategoryId(Integer categoryId);
    //***************************************************


}
