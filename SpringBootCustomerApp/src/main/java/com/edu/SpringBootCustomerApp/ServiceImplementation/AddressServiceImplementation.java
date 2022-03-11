package com.edu.SpringBootCustomerApp.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootCustomerApp.Entity.Address;
import com.edu.SpringBootCustomerApp.Entity.Stock;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFoundException;
import com.edu.SpringBootCustomerApp.Repository.AddressRepository;
import com.edu.SpringBootCustomerApp.Repository.StockRepository;
import com.edu.SpringBootCustomerApp.Service.AddressService;
@Service
public class AddressServiceImplementation implements AddressService  {

	private AddressRepository addressRepository;
	
	public AddressServiceImplementation(AddressRepository addressRepository)
	{
		super();
		this.addressRepository=addressRepository;
	}
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	@Override
	public List<Address> getAllAddress(){
		return addressRepository.findAll();
	}
	@Override
	public Address getAddressById(long id) {
		Optional<Address> address=addressRepository.findById(id);
		if(address.isPresent()) {
			return address.get();
		}
		else {
			throw new ResourceNotFoundException("Address","addressId",id);
		}
	}
	@Override
	public Address updateAddress(Address address, long id) {
		Address ad=new Address();
		try {
			ad=addressRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Address","addressId",id));
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		//ad.setAddressId(address.getAddressId());
		ad.setPlotNo(address.getPlotNo());
		ad.setStreet(address.getStreet());
		ad.setCity(address.getCity());
		ad.setPinCode(address.getPinCode());
		
		addressRepository.save(ad);
		return ad;
	}
	@Override
	public void deleteAddress(long id) {
		addressRepository.findById(id).orElseThrow(
		()-> new ResourceNotFoundException("Address","addressId",id));
		addressRepository.deleteById(id);
	}
}
