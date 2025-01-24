package com.abhijeet.service;

import com.abhijeet.entity.Users;
import com.abhijeet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> getAllUsersByUserRole(String userRole) {
        return userRepository.findByUserRole(userRole);
    }

    @Override
    public Users getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found..."));
    }

    @Override
    public Users getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Users addNewUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
