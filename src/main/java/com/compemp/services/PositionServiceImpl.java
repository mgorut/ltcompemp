package com.compemp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compemp.entities.Position;
import com.compemp.entities.request.PositionRequest;
import com.compemp.repositories.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PositionRepository positionRep;

	public Position findByName(String name) {
		return positionRep.findByName(name);
	}
	
	public Position create(PositionRequest position) {
		Position newPosition = new Position();
		newPosition.setName(position.getName());
		positionRep.saveAndFlush(newPosition);
		return newPosition;
	}

	public Position read(Long id) {
		Optional<Position> position = positionRep.findById(id);
		return position.get();
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
