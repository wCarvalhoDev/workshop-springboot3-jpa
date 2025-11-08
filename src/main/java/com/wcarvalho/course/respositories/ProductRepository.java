package com.wcarvalho.course.respositories;

import com.wcarvalho.course.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
