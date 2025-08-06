package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @NotNull(message = "Category ID cannot be null")
    private Integer categoryId;

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 5, message = "Title must be at least 5 characters")
    private String title;

    @NotEmpty(message = "Content cannot be empty")
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull(message = "User ID cannot be null")
    private Integer userId;

    @NotNull(message = "Publish date cannot be null")
    @PastOrPresent(message = "Publish date must be in the past or today")
    private LocalDate publishDate;
}
