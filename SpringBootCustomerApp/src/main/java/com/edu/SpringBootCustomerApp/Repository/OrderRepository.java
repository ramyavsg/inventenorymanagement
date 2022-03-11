package com.edu.SpringBootCustomerApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootCustomerApp.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
