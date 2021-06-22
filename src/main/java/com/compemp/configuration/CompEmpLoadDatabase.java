package com.compemp.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.compemp.entities.Employee;
import com.compemp.entities.Person;
import com.compemp.entities.Position;
import com.compemp.repositories.EmployeeRepository;
import com.compemp.repositories.PersonRepository;
import com.compemp.repositories.PositionRepository;

@Configuration
class CompEmpLoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(CompEmpLoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(PersonRepository personRep, PositionRepository positionRep, EmployeeRepository employeeRep) {
		
		return args -> {
			
			Person person1 = new Person("Camilo", "Ruiz", "Cra", "124", "Medellín");
			Person person2 = new Person("Andrés", "Escobar", "Cra", "124", "Envigado");
			Person person3 = new Person("Luis", "Pérez", "Cra", "124", "Medellin");
			Person person4 = new Person("Pedro", "Castro", "Cra", "1244", "Envigado");

			personRep.save(person1);
			personRep.save(person2);
			personRep.save(person3);
			personRep.save(person4);

			Position position1 = new Position("dev");
			Position position2 = new Position("qa");

			positionRep.save(position1);
			positionRep.save(position2);

			Employee employee1 = new Employee(person1, position1, new Double(2000));
			Employee employee2 = new Employee(person2, position1, new Double(1000));
			Employee employee3 = new Employee(person3, position2, new Double(1500));
			Employee employee4 = new Employee(person4, position2, new Double(1000));

			employeeRep.save(employee1);
			employeeRep.save(employee2);
			employeeRep.save(employee3);
			employeeRep.save(employee4);
			
			employeeRep.findAll().forEach((employee) -> {
				log.info("{}", employee);
			});
			
		};
		
	}
	
}
