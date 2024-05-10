package com.assignment.nimap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.nimap.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
