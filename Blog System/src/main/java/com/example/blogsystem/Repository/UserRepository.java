package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUserId(Integer id);




    //**********************************************************
    //Get Users Registered Before a Specific Date
    List<User> findUsersByRegistrationDateBefore(LocalDate localDate);
    //**********************************************************


    //**********************************************************
    //Get Users Registered After a Specific Date
    List<User> findUsersByRegistrationDateAfter(LocalDate localDate);
    //**********************************************************



}
