package com.compemp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.compemp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	@Query("SELECT em"
         + "  FROM Employee em"
         + "  JOIN FETCH em.person pe"
         + "  JOIN FETCH em.position po"
         + " WHERE em.id = :id"
         + " ORDER BY em.salary DESC")
	public Employee findOne(@Param("id") Long id);
	
	@Query("SELECT em"
         + "  FROM Employee em"
         + "  JOIN FETCH em.person pe"
         + "  JOIN FETCH em.position po"
         + " WHERE LOWER(po.name) LIKE LOWER(:name)"
         + " ORDER BY em.salary DESC")
	public List<Employee> findByPosition(@Param("name") String name);	
	
	@Query("SELECT em"
         + "  FROM Employee em"
         + "  JOIN FETCH em.person pe"
         + "  JOIN FETCH em.position po"
         + " WHERE LOWER(po.name) LIKE LOWER(:name)"
         + "   AND LOWER(pe.name) LIKE LOWER(:person)"
         + " ORDER BY em.salary DESC")
	public List<Employee> findByPositionAndName(@Param("name") String name, 
			                                    @Param("person") String person);

}
