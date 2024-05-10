package com.assignment.nimap.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Category {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="name")
	private String name;
	 /*
	
	@OneToMany(targetEntity = Product.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "CategoryProduct_fk",referencedColumnName = "categoryId")
	@JsonBackReference*/
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
	@JsonManagedReference("categoryReference")
	private List<Product> products;

	
}
