package com.expenseTracker.data.service.interfaces;

import com.expenseTracker.data.model.Category;
import com.expenseTracker.dto.request.CategoryRequest;
import com.expenseTracker.dto.response.CategoryResponse;
import org.springframework.stereotype.Service;


public interface CategoryService {

  CategoryResponse createCategory(CategoryRequest categoryRequest);

}
