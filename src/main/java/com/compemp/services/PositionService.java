package com.compemp.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.compemp.entities.Position;
import com.compemp.entities.request.PositionRequest;

public interface PositionService extends Serializable {
	
	public List<Position> findAll();
	
	public List<Position> findAllByPositionName(@Param("name") String name);
	
	public List<Position> findAllByEmployeeName(@Param("name") String name);
	
	public Position findByName(String name);
	
	public List<Position> findByNameContainingIgnoreCase(String name);
	
	public Position create(PositionRequest position);
	
	public Position read(Long id);

	public Position update(PositionRequest position, Long id);
	
}
