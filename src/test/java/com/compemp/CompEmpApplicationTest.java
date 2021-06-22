package com.compemp;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.compemp.entities.Employee;
import com.compemp.entities.Person;
import com.compemp.entities.Position;
import com.compemp.entities.request.EmployeeRequest;
import com.compemp.entities.request.PersonRequest;
import com.compemp.entities.request.PositionRequest;
import com.compemp.entities.response.PositionReponse;
import com.compemp.repositories.EmployeeRepository;
import com.compemp.repositories.PersonRepository;
import com.compemp.repositories.PositionRepository;
import com.compemp.services.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CompEmpApplicationTest {

	@Autowired
	PersonRepository personRep;

	@Autowired
	PositionRepository positionRep;

	@Autowired
	EmployeeRepository employeeRep;
	
	@Autowired
	EmployeeService employeeService;
	
	@BeforeEach
	public void init() {

		employeeRep.deleteAll();
		positionRep.deleteAll();
		personRep.deleteAll();
		
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
		
	}

	@Test
	public void checkingArraySize() {
		
		int size = personRep.findAll().size();
		assertNotEquals(size == 4, "The Person Array Size shouldn't be equals 4");
		
		size = positionRep.findAll().size();
		assertNotEquals(size == 2, "The Position Array Size shouldn't be equals 2");

		size = employeeRep.findAll().size();
		assertNotEquals(size == 4, "The Employee Array Size shouldn't be equals 4");
		
	}
	
	@Test
	public void createEmployee() {
		
		PersonRequest personRequest = new PersonRequest();
		personRequest.setName("Manuel");
		personRequest.setLastName("Gorut");
		personRequest.setAddress("Chipre Manzana B Lote 13");
		personRequest.setCellPhone("+573015255284");
		personRequest.setCityName("Cartagena");
		
		PositionRequest positionRequest = new PositionRequest();
		positionRequest.setName("dev");
		
		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setPerson(personRequest);
		employeeRequest.setPosition(positionRequest);
		employeeRequest.setSalary(new Double(50000));
		
		Employee employee = employeeService.create(employeeRequest);
		assertNotNull("The Employee ID shouldn't be NULL", employee.getId());
		
	}
	
	@Test
	public void searchEmployee() {
		
		List<PositionReponse> response = employeeService.findByPositionAndName(null, null);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(response);
		System.out.println(jsonOutput);
		
		assertNotEquals(response != null && !response.isEmpty(), "The Positio Array Size shouldn't be equals NULL");
		
	}
	
}
