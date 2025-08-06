package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @NotNull(message = "User ID cannot be null")
    private Integer userId;

    @NotNull(message = "Post ID cannot be null")
    private Integer postId;

    @NotEmpty(message = "Comment content cannot be empty")
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull(message = "Comment date cannot be null")
    @PastOrPresent(message = "Comment date must be in the past or today")
    private LocalDate commentDate;
}
