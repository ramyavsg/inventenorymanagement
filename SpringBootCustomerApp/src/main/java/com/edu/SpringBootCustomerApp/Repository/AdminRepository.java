package com.edu.SpringBootCustomerApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootCustomerApp.Entity.Admin;


public interface AdminRepository extends JpaRepository<Admin,Long> {

}
