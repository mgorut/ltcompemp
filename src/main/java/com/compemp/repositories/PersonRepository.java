package com.compemp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compemp.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Person findByNameAndLastName(String name, String lastName);
	
}
