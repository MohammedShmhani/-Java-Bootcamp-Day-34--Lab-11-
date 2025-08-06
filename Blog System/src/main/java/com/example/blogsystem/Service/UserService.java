package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        User user = userRepository.findUserByUserId(id);
        if (user == null) {
            throw new ApiException("POST_NOT_FOUND");
        }
        userRepository.delete(user);
    }

    public void updateUser(Integer id, User user) {
        User user1 = userRepository.findUserByUserId(id);
        if (user1 == null) {
            throw new ApiException("POST_NOT_FOUND");
        }
        user.setUsername(user1.getUsername());
        user.setPassword(user1.getPassword());
        user.setEmail(user1.getEmail());
        user.setRegistrationDate(user1.getRegistrationDate());
        userRepository.save(user);
    }



    //**********************************************************************************
    //Get Users Registered Before a Specific Date
    public List<User> findUsersByRegistrationDateBefore(LocalDate localDate) {
        List<User> users = userRepository.findUsersByRegistrationDateBefore(localDate);
        if (users.isEmpty()) {
            throw new ApiException("USER_NOT_FOUND");
        }
        return users;
    }
    //**********************************************************************************



    //**********************************************************************************
    //Get Users Registered Before a Specific Date
    public List<User> findUsersByRegistrationDateAfter(LocalDate localDate) {
        List<User> users = userRepository.findUsersByRegistrationDateAfter(localDate);
        if (users.isEmpty()) {
            throw new ApiException("USER_NOT_FOUND");
        }
        return users;
    }
    //**********************************************************************************
}
