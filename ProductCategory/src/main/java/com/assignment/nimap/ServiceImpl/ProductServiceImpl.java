package com.assignment.nimap.ServiceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assignment.nimap.Converter.ProductConverter;
import com.assignment.nimap.Entity.Product;
import com.assignment.nimap.Exception.ProductNotFoundException;
import com.assignment.nimap.Model.ProductDto;
import com.assignment.nimap.Repository.ProductRepo;
import com.assignment.nimap.Services.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepo pRepo;
	
	@Autowired
	private ProductConverter pConverter;
	
	
	
	@Override
	public Page<ProductDto> getAllProducts(Pageable pageable) {
		
		Page<Product> allProducts = this.pRepo.findAll(pageable);
        return allProducts.map(pConverter::convertToProductDto);

	
	}
	
	
	

	@Override
	public ProductDto getProductById(int id) {
		Product product = pRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product with ID " +id+ "is not found"));
		return this.pConverter.convertToProductDto(product);
	}

	
	
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
	
		Product product =this.pConverter.convertToProduct(productDto);
		Product saveProduct=this.pRepo.save(product);
		return this.pConverter.convertToProductDto(saveProduct);
		
		
	}

		
	
	@Override
	public ProductDto updateProduct(int id,ProductDto productDto) {
		Product product =pRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product with ID "+ id + "is not found"));
		
		product.setId(id);
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		
		Product saveProduct = pRepo.save(product);
		return pConverter.convertToProductDto(saveProduct);
		
	}

	@Override
	public void deleteProduct(int id) {
		pRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with ID "+ id +"is not found"));

		pRepo.deleteById(id);
	}




}
