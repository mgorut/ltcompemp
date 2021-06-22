package com.compemp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compemp.entities.Person;
import com.compemp.entities.request.PersonRequest;
import com.compemp.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonRepository personRep;

	public Person findByNameAndLastName(String name, String lastName) {
		return personRep.findByNameAndLastName(name, lastName);
	}
	
	public Person create(PersonRequest person) {
		Person newPerson = new Person();
		newPerson.setName(person.getName());
		newPerson.setLastName(person.getLastName());
		newPerson.setAddress(person.getAddress());
		newPerson.setCellPhone(person.getCellPhone());
		newPerson.setCityName(person.getCityName());
		personRep.saveAndFlush(newPerson);
		return newPerson;
	}

	public Person read(Long id) {
		Optional<Person> person = personRep.findById(id);
		return person.get();
	}

	public Person update(PersonRequest person, Long id) {
		return personRep.findById(id).map(newPerson -> {
			newPerson.setName(person.getName());
			newPerson.setLastName(person.getLastName());
			newPerson.setAddress(person.getAddress());
			newPerson.setCellPhone(person.getCellPhone());
			newPerson.setCityName(person.getCityName());
			return personRep.save(newPerson);
		}).orElseGet(() -> {
			Person newPerson = new Person();
			newPerson.setId(id);
			return personRep.save(newPerson);
		});
	}

	public void delete(Long id) {
		personRep.deleteById(id);
	}

}
