package com.assignment.nimap.ServiceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assignment.nimap.Converter.CategoryConverter;
import com.assignment.nimap.Entity.Category;
import com.assignment.nimap.Exception.CategoryNotFoundException;
import com.assignment.nimap.Model.CategoryDto;
import com.assignment.nimap.Repository.CategoryRepo;
import com.assignment.nimap.Services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	CategoryRepo cRepo;
	
	@Autowired
	private CategoryConverter cConverter;
	
	
	
	@Override
	public Page<CategoryDto> getAllCategory(Pageable pageable) {
		
		Page<Category> allCategories = this.cRepo.findAll(pageable);
		
		return allCategories.map(cConverter::convertToCategoryDto);
	}
	
	
	

	@Override
	public CategoryDto getCategoryById(int id) {
		Category category = cRepo.findById(id).orElseThrow(()->new CategoryNotFoundException("Category with ID " +id+ "is not found"));
		return this.cConverter.convertToCategoryDto(category);
	}

	
	
	
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
	
		Category category =this.cConverter.convertToCategory(categoryDto);
		Category saveCategory=this.cRepo.save(category);
		return this.cConverter.convertToCategoryDto(saveCategory);
		
		
	}

		
	
	@Override
	public CategoryDto updateCategory(int id, CategoryDto categoryDto) {
		Category category=cRepo.findById(id).orElseThrow(()->new CategoryNotFoundException("Category with ID "+ id + "is not found"));
		
		category.setId(id);
		category.setName(categoryDto.getName());
		
		
		Category saveCategory = cRepo.save(category);
		return cConverter.convertToCategoryDto(saveCategory);
		
	}

	@Override
	public void deleteCategory(int id) {
		cRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category with ID "+ id +"is not found"));

		cRepo.deleteById(id);
	}

}
