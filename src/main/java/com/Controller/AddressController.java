package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AddressEntity;
import com.repository.AddressRepository;

@RestController
public class AddressController {

	@Autowired
	AddressRepository addressRepository;
	
	
	@GetMapping("/getAddress")
	public List<AddressEntity> getAllAdress() {
		
	return addressRepository.findAll();
		
	}
	
	@GetMapping("/getAddressBy/{Id}")
	public AddressEntity getAddressById(@PathVariable("Id") Integer Id) {
		Optional<AddressEntity> address = addressRepository.findById(Id);
		if(address.isEmpty()) {
			return null;
		}
		else {
			return address.get();
		}
		
	}
	
	@DeleteMapping("/addressdelete/{Id}")
	public AddressEntity deleteById(@PathVariable("Id") Integer Id) {
		AddressEntity address = addressRepository.findById(Id).get();
		addressRepository.delete(address);
		return address;
	}
	
	@PutMapping("/updateByAdderess")
	public AddressEntity updateAdderess(@RequestBody AddressEntity address) {
		addressRepository.save(address);
		return address;
		
	}
	
}
