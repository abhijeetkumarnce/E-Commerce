package com.abhijeet.repository;

import com.abhijeet.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByUserRole(String userRole);

    Users findByUserName(String userName);
}
