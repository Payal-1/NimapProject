package com.assignment.nimap.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.assignment.nimap.Model.CategoryDto;

public interface CategoryService {
	
	public Page<CategoryDto> getAllCategory(Pageable pageable);
	
	public CategoryDto getCategoryById(int id);
	
	public CategoryDto addCategory(CategoryDto category);
	public CategoryDto updateCategory (int id, CategoryDto updateCategory);
	
	public void deleteCategory(int id);
	
	

}
