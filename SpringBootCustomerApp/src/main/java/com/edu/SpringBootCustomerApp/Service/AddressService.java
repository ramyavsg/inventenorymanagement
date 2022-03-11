package com.edu.SpringBootCustomerApp.Service;

import java.util.List;

import com.edu.SpringBootCustomerApp.Entity.Address;

public interface AddressService {

	Address saveAddress(Address address);

	List<Address> getAllAddress();

	Address getAddressById(long id);

	Address updateAddress(Address address, long id);

	void deleteAddress(long id);

}
