package com.example.SpringBootProjectPart2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
}
