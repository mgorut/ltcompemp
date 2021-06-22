package com.compemp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compemp.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

	Position findByName(String name);
	
}

