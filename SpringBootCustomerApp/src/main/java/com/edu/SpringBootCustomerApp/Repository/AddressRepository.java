package com.edu.SpringBootCustomerApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootCustomerApp.Entity.Address;



public interface AddressRepository extends JpaRepository<Address,Long>{

}
