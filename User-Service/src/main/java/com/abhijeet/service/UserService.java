package com.abhijeet.service;

import com.abhijeet.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllUsers();

    Users getUserByUserId(Long userId);

    Users getUserByUserName(String userName);

    Users addNewUser(Users user);

    void deleteUser(Long userId);

    String verify(Users users);
}
