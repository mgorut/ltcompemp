package com.compemp.services;

import java.io.Serializable;

import com.compemp.entities.Person;
import com.compemp.entities.request.PersonRequest;

public interface PersonService extends Serializable {
	
	public Person findByNameAndLastName(String name, String lastName);
	
	public Person create(PersonRequest person);
	
	public Person read(Long id);

	public Person update(PersonRequest person, Long id);
	
	public void delete(Long id);
	
}
