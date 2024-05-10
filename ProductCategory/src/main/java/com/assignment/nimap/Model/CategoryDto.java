package com.assignment.nimap.Model;

import java.util.List;

import com.assignment.nimap.Entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDto {

	
	
	private int id;
	private String name;
	
	private List<Product> products;
	
}
