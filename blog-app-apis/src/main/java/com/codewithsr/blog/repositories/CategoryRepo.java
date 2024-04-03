package com.codewithsr.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsr.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
