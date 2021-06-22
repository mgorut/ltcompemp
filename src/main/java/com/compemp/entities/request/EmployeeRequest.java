package com.compemp.entities.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("person")
	private PersonRequest person;
	@JsonProperty("position")
	private PositionRequest position;
	@JsonProperty("salary")
	private Double salary;
	
	public EmployeeRequest() {}
	
	public EmployeeRequest(PersonRequest person, PositionRequest position, Double salary) {
		this.person = person;
		this.position = position;
		this.salary = salary;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonRequest getPerson() {
		return person;
	}

	public void setPerson(PersonRequest person) {
		this.person = person;
	}

	public PositionRequest getPosition() {
		return position;
	}

	public void setPosition(PositionRequest position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [id=" + id + ", person=" + person + ", position=" + position + ", salary=" + salary + "]";
	}
	
}
