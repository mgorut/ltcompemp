package com.compemp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compemp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
