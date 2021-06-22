package com.compemp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.compemp.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("SELECT pe"
         + "  FROM Person pe"
         + " WHERE pe.id = :id")
	public Person findOne(@Param("id") Long id);
	
	Person findByNameAndLastName(String name, String lastName);
	
}
