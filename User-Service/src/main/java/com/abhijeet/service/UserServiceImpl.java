package com.abhijeet.service;

import com.abhijeet.entity.Users;
import com.abhijeet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
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
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
