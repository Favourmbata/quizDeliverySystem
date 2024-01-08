package com.expenseTracker.data.service.implementation;

import com.expenseTracker.data.model.Category;
import com.expenseTracker.data.repository.CategoryRepository;
import com.expenseTracker.data.service.interfaces.CategoryService;
import com.expenseTracker.dto.request.CategoryRequest;
import com.expenseTracker.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryImpService implements CategoryService {
  private final CategoryRepository categoryRepository;


    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
       if (categoryRepository.existsByIdAndUserName(categoryRequest.getId(),categoryRequest.getUserName())) throw new RuntimeException("Category exist");
       Category foundCategory = new Category();
        foundCategory.setUserName(categoryRequest.getUserName());
        foundCategory.setId(categoryRequest.getId());
        Category savedCategory = categoryRepository.save(foundCategory);

        CategoryResponse categoryResponse = new CategoryResponse();
        foundCategory.setUserName(savedCategory.getUserName());
        foundCategory.setId(savedCategory.getId());
        return categoryResponse;
    }





}
