package com.wcarvalho.course.respositories;

import com.wcarvalho.course.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
