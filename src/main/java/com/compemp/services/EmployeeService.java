package com.compemp.services;

import java.io.Serializable;
import java.util.List;

import com.compemp.entities.Employee;
import com.compemp.entities.request.EmployeeRequest;
import com.compemp.entities.response.PositionReponse;

public interface EmployeeService extends Serializable {

	public Employee create(EmployeeRequest employee);

	public Employee read(Long id);

	public Employee update(EmployeeRequest employee, Long id);

	public void delete(Long id);

	public List<PositionReponse> findByPositionAndName(String name, String person);

}
