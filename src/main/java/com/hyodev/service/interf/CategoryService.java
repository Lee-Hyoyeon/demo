package com.hyodev.service.interf;

import com.hyodev.dto.CategoryDto;
import com.hyodev.dto.Response;

public interface CategoryService {
  Response createdCategory (CategoryDto categoryRequest);
  Response updateCategory (Long categoryId, CategoryDto categoryRequest);
  Response getAllCategories();
  Response getCategoryById (Long categoryId);
  Response deleteCategory (Long categoryId);

}
