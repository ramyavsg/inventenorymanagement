package com.edu.SpringBootCustomerApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.Product;

import com.edu.SpringBootCustomerApp.Service.ProductService;
@RestController
@RequestMapping("/api/product")
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService=productService;
	}
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Product> getAllProduct(){
	
		return productService.getAllProduct();
	}
	
	@GetMapping("{id}")//4
	public ResponseEntity<Product>getProductById(@PathVariable("id") long id) {
		return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);

	}
	@GetMapping("/productGroupByBrandId")
	public List<Product> getProductGroupByBrandId(String brandId){
		return productService.getProductGroupByBrandId(brandId);
	}

	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product record deleted",HttpStatus.OK);
	}

	
}


