package com.compemp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compemp.entities.Employee;
import com.compemp.entities.Person;
import com.compemp.entities.Position;
import com.compemp.entities.request.EmployeeRequest;
import com.compemp.entities.response.EmployeeResponse;
import com.compemp.entities.response.PersonResponse;
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
		
		return employeeRep.save(newEmployee);
	}
	
	public Employee read(Long id) {
		return employeeRep.findOne(id); 
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
		
		return employeeRep.save(newEmployee);
	}
	
	public void delete(Long id) {
		employeeRep.deleteById(id);
	}
	
	public List<PositionReponse> findByPositionAndName(String positionName, String employeeName) {
		
		List<PositionReponse> response = new ArrayList<>();
		List<Position> positionList = null;
		
		if (   (positionName == null && employeeName == null) 
			|| (positionName != null && employeeName == null)) {
			
			if (positionName != null)
				positionList = positionService.findAllByPositionName(positionName);
			else
				positionList = positionService.findAll();

			if (positionList != null && !positionList.isEmpty()) {
				
				for (Position position : positionList) {
					
					List<EmployeeResponse> employeeResponseList = new ArrayList<>();
					PositionReponse positionReponse = new PositionReponse();
					positionReponse.setId(position.getId());
					positionReponse.setName(position.getName());
					positionReponse.setEmployees(employeeResponseList);
					List<Employee> employeeList = employeeRep.findByPosition(position.getName());
					
					for (Employee employee : employeeList) {
						
						Person person = employee.getPerson();

						EmployeeResponse employeeResponse = new EmployeeResponse();
						employeeResponse.setId(employee.getId());
						employeeResponse.setSalary(employee.getSalary());
						
						PersonResponse personResponse = new PersonResponse();
						personResponse.setName(person.getName());
						personResponse.setLastName(person.getLastName());
						personResponse.setAddress(person.getAddress());
						personResponse.setCellPhone(person.getCellPhone());
						personResponse.setCityName(person.getCityName());
						
						employeeResponse.setPerson(personResponse);
						employeeResponseList.add(employeeResponse);
					}
					
					response.add(positionReponse);
					
				}
				
				
			}
		
		} else {
			
			positionList = positionService.findAllByEmployeeName(employeeName);
			
			if (positionList != null && !positionList.isEmpty()) {
				
				for (Position position : positionList) {
					
					List<EmployeeResponse> employeeResponseList = new ArrayList<>();
					PositionReponse positionReponse = new PositionReponse();
					positionReponse.setId(position.getId());
					positionReponse.setName(position.getName());
					positionReponse.setEmployees(employeeResponseList);
					List<Employee> employeeList = employeeRep.findByPositionAndName(position.getName(), employeeName);
					
					for (Employee employee : employeeList) {
						
						Person person = employee.getPerson();

						EmployeeResponse employeeResponse = new EmployeeResponse();
						employeeResponse.setId(employee.getId());
						employeeResponse.setSalary(employee.getSalary());
						
						PersonResponse personResponse = new PersonResponse();
						personResponse.setName(person.getName());
						personResponse.setLastName(person.getLastName());
						personResponse.setAddress(person.getAddress());
						personResponse.setCellPhone(person.getCellPhone());
						personResponse.setCityName(person.getCityName());
						
						employeeResponse.setPerson(personResponse);
						employeeResponseList.add(employeeResponse);
					}
					
					response.add(positionReponse);
					
				}
				
			}
			
			
		}
		
		return response;
		
	}
	
}
