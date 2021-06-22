package com.compemp.services;

import java.io.Serializable;

import com.compemp.entities.Position;
import com.compemp.entities.request.PositionRequest;

public interface PositionService extends Serializable {
	
	public Position findByName(String name);
	
	public Position create(PositionRequest position);
	
	public Position read(Long id);

	public Position update(PositionRequest position, Long id);
	
}
