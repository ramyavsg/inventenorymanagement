package com.edu.SpringBootCustomerApp.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootCustomerApp.Entity.Admin;
import com.edu.SpringBootCustomerApp.Entity.Stock;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFoundException;
import com.edu.SpringBootCustomerApp.Repository.AdminRepository;
import com.edu.SpringBootCustomerApp.Repository.StockRepository;
import com.edu.SpringBootCustomerApp.Service.AdminService;
@Service
public class AdminServiceImplementation implements AdminService{
private AdminRepository adminRepository;

public AdminServiceImplementation(AdminRepository adminRepository) {
	super();
	this.adminRepository=adminRepository;
}
@Override
public Admin saveAdmin(Admin admin) {
	return adminRepository.save(admin);
}
@Override
public List<Admin> getAllAdmin(){
	return adminRepository.findAll();
}
@Override
public Admin getAdminById(long id) {
	Optional<Admin> admin=adminRepository.findById(id);
	if(admin.isPresent()) {
		return admin.get();
	}
	else {
		throw new ResourceNotFoundException("Admin","adminId",id);
	}
}
@Override
public Admin updateAdmin(Admin admin,long id) {
	Admin adm=new Admin();
	try {
		adm=adminRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Admin","adminId",id));
	}catch (ResourceNotFoundException e) {
		e.printStackTrace();
	}
	//adm.setAdminId(admin.getAdminId());
	adm.setFirstName(admin.getFirstName());
	adm.setLastName(admin.getLastName());
	adm.setEmail(admin.getEmail());
	adm.setPassword(admin.getPassword());
	adm.setConfirmPassword(admin.getConfirmPassword());
	adminRepository.save(adm);
	return adm;
}
@Override
public void deleteAdmin(long id) {
	adminRepository.findById(id).orElseThrow(
			()-> new ResourceNotFoundException("Admin","adminId",id));
	adminRepository.deleteById(id);
}
}
