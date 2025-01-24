package com.abhijeet.controller;

import com.abhijeet.entity.Users;
import com.abhijeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{userRole}")
    public List<Users> getAllUsersByUserRole(@PathVariable String userRole){
        return userService.getAllUsersByUserRole(userRole);
    }

    @GetMapping("/{userId}")
    public Users getUserByUserId(@PathVariable Long userId){
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/{userName}")
    public Users getUserByUserName(@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }

    @PostMapping("/")
    public Users addNewUser(@RequestBody Users user){
        return userService.addNewUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User is deleted successfully...");
    }

    @PutMapping("/id/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable Long userId, @RequestBody Users user){
        Users updateUser = userService.getUserByUserId(userId);

        updateUser.setUserName(user.getUserName());
        updateUser.setUserRole(user.getUserRole());
        userService.addNewUser(updateUser);

        return ResponseEntity.ok(updateUser);
    }
}
