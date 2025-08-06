package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 5, message = "Username must be at least 5 characters")
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "Registration date cannot be null")
    @PastOrPresent(message = "Registration date must be in the past or today")
    @Column(nullable = false)
    private LocalDate registrationDate;
}
