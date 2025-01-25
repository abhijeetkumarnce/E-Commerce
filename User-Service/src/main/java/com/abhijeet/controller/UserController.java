package com.abhijeet.controller;

import com.abhijeet.entity.Users;
import com.abhijeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/id/{userId}")
    public Users getUserByUserId(@PathVariable Long userId){
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/username/{userName}")
    public Users getUserByUserName(@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }

    @PostMapping("/")
    public Users addNewUser(@RequestBody Users user){
        return userService.addNewUser(user);
    }

    @DeleteMapping("/id/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User is deleted successfully...");
    }

    @PutMapping("/id/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable Long userId, @RequestBody Users user){
        Users updateUser = userService.getUserByUserId(userId);

        if (updateUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        updateUser.setUserName(user.getUserName());
        updateUser.setUserPassword(user.getUserPassword());
        userService.addNewUser(updateUser);

        return ResponseEntity.ok(updateUser);
    }
}
