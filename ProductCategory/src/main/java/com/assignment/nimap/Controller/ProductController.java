package com.assignment.nimap.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.nimap.Converter.ProductConverter;
import com.assignment.nimap.Model.ProductDto;
import com.assignment.nimap.Services.ProductService;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

	
	
	
	@Autowired
	ProductService ps;
	
	@Autowired
	ProductConverter pConverter;
		
	
	@PostMapping("/products")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
		
		System.out.println("Data Added"+productDto);
		return new ResponseEntity<ProductDto>(ps.addProduct(productDto),HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/products")
	public Page<ProductDto>getAllProducts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
Pageable pageable = PageRequest.of(page, size);
return ps.getAllProducts(pageable);
		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto>getProductById(@PathVariable("id") int id)
	{
		return new ResponseEntity<ProductDto>(ps.getProductById(id),HttpStatus.OK);
	}
	
	
	 @PutMapping("/products/{id}")
	    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto ProductDto,@PathVariable int id) {
			return new ResponseEntity<ProductDto>(ps.updateProduct(id, ProductDto),HttpStatus.OK);
	    }

	    
	        
	    @DeleteMapping("deleteProduct/{id}")
	    public void deleteProduct(@PathVariable int id) {
	        ps.deleteProduct(id);

	    }
	
	
	
}
