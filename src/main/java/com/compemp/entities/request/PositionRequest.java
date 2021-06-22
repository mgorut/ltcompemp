package com.compemp.entities.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;	
	@JsonProperty("name")
	private String name;
	
	public PositionRequest() {}
	
	public PositionRequest(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PositionRequest [id=" + id + ", name=" + name + "]";
	}
	
}
