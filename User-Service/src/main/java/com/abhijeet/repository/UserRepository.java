package com.abhijeet.repository;

import com.abhijeet.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserName(String userName);
}
