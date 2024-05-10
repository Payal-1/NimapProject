package com.assignment.nimap.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.assignment.nimap.Converter.CategoryConverter;
import com.assignment.nimap.Model.CategoryDto;
import com.assignment.nimap.Services.CategoryService;




@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoryController {

	
	
	@Autowired
	CategoryService cs;
	
	@Autowired
	CategoryConverter cConverter;
		
	
	@PostMapping("/categories")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
		
		System.out.println("Data Added"+categoryDto);
		
		return new ResponseEntity<CategoryDto>(cs.addCategory(categoryDto),HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/categories")
	public Page<CategoryDto>getAllCategory(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return cs.getAllCategory(PageRequest.of(page, size));
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryDto>getCategoryById(@PathVariable("id") int id)
	{
		return new ResponseEntity<CategoryDto>(cs.getCategoryById(id),HttpStatus.OK);
	}
	
	
	 @PutMapping("/categories/{id}")
	    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable int id) {
			return new ResponseEntity<CategoryDto>(cs.updateCategory(id, categoryDto),HttpStatus.OK);
	    }

	    
	        
	    @DeleteMapping("deleteCategory/{id}")
	    public void deleteCategory(@PathVariable int id) {
	        cs.deleteCategory(id);

	    }
	
	
	
	
	
	
	
	
	
	
	
}
