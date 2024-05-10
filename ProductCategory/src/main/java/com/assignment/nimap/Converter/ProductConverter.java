package com.assignment.nimap.Converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.assignment.nimap.Entity.Product;
import com.assignment.nimap.Model.ProductDto;

@Component
public class ProductConverter {
	
	
	public 	ProductDto convertToProductDto(Product product)
	{
		ProductDto productDto = new ProductDto();
		
		if(product!=null) {
			BeanUtils.copyProperties(product, productDto);
		}
		
		return productDto;
		
	}
	
	public Product convertToProduct(ProductDto productDto)
	{
		Product product = new Product();
		
		if(productDto!=null)
		{
			BeanUtils.copyProperties(productDto, product);
		}
		
		return product;
	}
	

}
