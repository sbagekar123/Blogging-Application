package com.codewithsr.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsr.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
