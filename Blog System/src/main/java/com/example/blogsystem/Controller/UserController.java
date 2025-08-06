package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/USER")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/GET")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/ADD")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.ok().body(new ApiResponse("USER_ADDED"));
    }

    @PutMapping("/UPDATE/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id, user);
        return ResponseEntity.ok().body(new ApiResponse("USER_UPDATED"));
    }

    @DeleteMapping("/DELETE/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body(new ApiResponse("USER_DELETED"));
    }

    //********************************************************************************
    // Get Users Registered After a Specific Date
    @GetMapping("/s/AFTER/{localDate}")
    public ResponseEntity<?> findUsersByRegistrationDateAfter(@PathVariable LocalDate localDate) {
        return ResponseEntity.ok().body(userService.findUsersByRegistrationDateAfter(localDate));
    }
    //********************************************************************************

    //********************************************************************************
    // Get Users Registered Before a Specific Date
    @GetMapping("/s/Before/{localDate}")
    public ResponseEntity<?> findUsersByRegistrationDateBefore(@PathVariable LocalDate localDate) {
        return ResponseEntity.ok().body(userService.findUsersByRegistrationDateBefore(localDate));
    }
    //********************************************************************************

}
