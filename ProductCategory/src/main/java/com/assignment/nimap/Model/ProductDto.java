package com.assignment.nimap.Model;

import com.assignment.nimap.Entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	

	private int id;
	private String name;
	private double price;
	
	private Category category;
}
