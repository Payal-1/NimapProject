package com.assignment.nimap.Services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.assignment.nimap.Model.ProductDto;

public interface ProductService {
	
	
	public Page<ProductDto> getAllProducts(Pageable pageable);
	
	public ProductDto getProductById(int id);
	
	public ProductDto addProduct(ProductDto product);
	
	public ProductDto updateProduct(int id, ProductDto updateProduct);
	
	public void deleteProduct(int id);
	

}
