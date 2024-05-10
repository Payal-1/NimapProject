package com.assignment.nimap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.nimap.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
