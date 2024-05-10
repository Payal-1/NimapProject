package com.assignment.nimap.Converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.assignment.nimap.Entity.Category;
import com.assignment.nimap.Model.CategoryDto;

@Component
public class CategoryConverter {
	
	
	
	public CategoryDto convertToCategoryDto(Category category) {
		
		CategoryDto categoryDto = new CategoryDto();
		
		if(category!=null)
		{
			BeanUtils.copyProperties(category, categoryDto);
			
		}
		
		return categoryDto;
		
	}
	
	
	public Category convertToCategory(CategoryDto categoryDto)
	{
		Category category = new Category();
		
		if(categoryDto!=null)
		{
			BeanUtils.copyProperties(categoryDto, category);
		}
		return category;
	}
	

}





