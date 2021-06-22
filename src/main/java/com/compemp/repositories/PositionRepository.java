package com.compemp.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.compemp.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
	
	@Query("SELECT po"
         + "  FROM Position po"
         + " WHERE po.id = :id")
	public Position findOne(@Param("id") Long id);
	
	@Query("SELECT po "
         + "  FROM Position po "
         + " ORDER BY po.name ASC")
	public List<Position> findAll();	
	
	@Query("SELECT po "
         + "  FROM Position po "
         + " WHERE LOWER(po.name) LIKE LOWER(:name)"
         + " ORDER BY po.name ASC")
	public List<Position> findAllByName(@Param("name") String name);
	
	@Query("SELECT ps"
         + "  FROM Position ps "
         + " WHERE ps.id IN (SELECT po.id "
         + "                   FROM Employee em"
         + "                   JOIN em.person pe"
         + "                   JOIN em.position po"
         + "                  WHERE po.id = ps.id"
         + "                    AND LOWER(pe.name) LIKE LOWER(:name)"
         + "                  ORDER BY po.name ASC)"
         + " ORDER BY ps.name ASC")
	public Set<Position> findAllByEmployeeName(@Param("name") String name);	
		
	Position findByName(String name);
	
	List<Position> findByNameContainingIgnoreCase(String name);
	
}
