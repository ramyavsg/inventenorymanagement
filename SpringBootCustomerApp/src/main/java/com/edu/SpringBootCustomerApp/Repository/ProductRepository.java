package com.edu.SpringBootCustomerApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.SpringBootCustomerApp.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	@Query("Select  p.id from Product p GROUP BY p.brandId")
	
	List<Product> findProductGroupByBrandId(String brandId);

	

}
