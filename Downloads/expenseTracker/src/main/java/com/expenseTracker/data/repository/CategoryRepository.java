package com.expenseTracker.data.repository;

import com.expenseTracker.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByIdAndUserName(long id, String name);



}
