package com.compemp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compemp.entities.Employee;
import com.compemp.entities.Person;
import com.compemp.entities.Position;
import com.compemp.entities.request.EmployeeRequest;
import com.compemp.entities.response.PositionReponse;
import com.compemp.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeeRepository employeeRep;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PositionService positionService;
	
	public Employee create(EmployeeRequest employee) {
		
		Employee newEmployee = new Employee();
		
		Position newPosition = positionService.findByName(employee.getPosition().getName());
		if (newPosition == null)
			newPosition = positionService.create(employee.getPosition());
		newEmployee.setPosition(newPosition);
		
		Person newPerson = personService.findByNameAndLastName(employee.getPerson().getName(), 
				                                               employee.getPerson().getLastName());
		if (newPerson == null)
			newPerson = personService.create(employee.getPerson());
		newEmployee.setPerson(newPerson);
		
		newEmployee.setSalary(employee.getSalary());
		
		return employeeRep.saveAndFlush(newEmployee);
	}
	
	public Employee read(Long id) {
		Optional<Employee> employee = employeeRep.findById(id); 
		return employee.get();
	}
	
	public Employee update(EmployeeRequest employee, Long id) {
		
		Employee newEmployee = read(id);

		Position newPosition = positionService.findByName(employee.getPosition().getName());
		if (newPosition == null)
			newPosition = positionService.create(employee.getPosition());
		newEmployee.setPosition(newPosition);
		
		Person newPerson = personService.findByNameAndLastName(employee.getPerson().getName(), 
				                                               employee.getPerson().getLastName());
		if (newPerson == null)
			newPerson = personService.create(employee.getPerson());
		newEmployee.setPerson(newPerson);
		
		newEmployee.setSalary(employee.getSalary());
		
		return newEmployee;
	}
	
	public void delete(Long id) {
		employeeRep.deleteById(id);
	}
	
	public List<PositionReponse> search(String position, String name) {
		return null;
	}
	
}
