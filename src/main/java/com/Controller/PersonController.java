package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.PersonEntity;
import com.repository.AddressRepository;
import com.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@PostMapping("/InsertPerson")
	public PersonEntity addPerson(@RequestBody PersonEntity personEntity) {
		
		addressRepo.save(personEntity.getAddress());
		personRepo.save(personEntity);
		return personEntity;
	}
	
	@GetMapping("/getPersonList")// not work
	public List<PersonEntity> getAllPerson() {
		
		return personRepo.findAll();
	}
	
	@GetMapping("/getAllPersonById/{Id}")//not work
	public PersonEntity getPersonById(@PathVariable("Id") Integer Id) {
		Optional<PersonEntity> personEntity = personRepo.findById(Id);
		if(personEntity.isEmpty()) {
			return null;
		}
		else {
			return personEntity.get();
		}
		
	}
	
	@DeleteMapping("/deleteBy/{Id}")//not work
	public PersonEntity deleteById(@PathVariable("Id") Integer Id) {
		PersonEntity person = personRepo.findById(Id).get();
		personRepo.deleteById(Id);
		return person;
	}
	@PutMapping("/updateByPerson")
	public PersonEntity updatePerson(@RequestBody PersonEntity person) {
		personRepo.save(person);
		return person;
		
	}

}
