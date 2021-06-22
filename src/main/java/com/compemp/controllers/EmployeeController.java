package com.compemp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compemp.entities.Employee;
import com.compemp.entities.request.EmployeeRequest;
import com.compemp.entities.response.PositionReponse;
import com.compemp.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public Employee create(@RequestBody EmployeeRequest newEmployee) {
		return service.create(newEmployee);
	}
	
	@GetMapping("/{id}")
	public Employee read(@PathVariable Long id) {
		return service.read(id);
	}
	
	@PutMapping("/{id}")
	public Employee update(@RequestBody EmployeeRequest newEmployee, @PathVariable Long id) {
		return service.update(newEmployee, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping
	public List<PositionReponse> search(@RequestParam(value = "position", required = false) String position,
								 		@RequestParam(value = "name", required = false) String name) {
		return service.search(position, name);
	}
	
}
