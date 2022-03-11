package com.edu.SpringBootCustomerApp.Service;

import java.util.List;

import com.edu.SpringBootCustomerApp.Entity.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);

	List<Admin> getAllAdmin();

	Admin getAdminById(long id);

	Admin updateAdmin(Admin admin, long id);

	void deleteAdmin(long id);

}
