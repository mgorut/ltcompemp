package com.compemp.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.compemp.entities.Position;
import com.compemp.entities.request.PositionRequest;
import com.compemp.repositories.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PositionRepository positionRep;

	public List<Position> findAll() {
		return positionRep.findAll();
	}
	
	public List<Position> findAllByPositionName(@Param("name") String name) {
		return positionRep.findAllByName(name);
	}
	
	public List<Position> findAllByEmployeeName(@Param("name") String name) {
		Set<Position> result = positionRep.findAllByEmployeeName(name);
		return result.stream().collect(Collectors.toList());
	}
	
	public Position findByName(String name) {
		return positionRep.findByName(name);
	}
	
	public List<Position> findByNameContainingIgnoreCase(String name) {
		return positionRep.findByNameContainingIgnoreCase(name);
	}
	
	public Position create(PositionRequest position) {
		Position newPosition = new Position();
		newPosition.setName(position.getName());
		positionRep.saveAndFlush(newPosition);
		return newPosition;
	}

	public Position read(Long id) {
		return positionRep.findOne(id);
	}
	
	public Position update(PositionRequest position, Long id) {
		return positionRep.findById(id).map(newPosition -> {
			newPosition.setName(position.getName());
			return positionRep.save(newPosition);
		}).orElseGet(() -> {
			Position newPosition = new Position();
			newPosition.setId(id);
			return positionRep.save(newPosition);
		});
	}

	public void delete(Long id) {
		positionRep.deleteById(id);
	}

}
