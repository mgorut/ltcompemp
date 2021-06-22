package com.compemp.entities.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	@JsonProperty("salary")
	private Double salary;
	@JsonProperty("person")
	private PersonResponse person;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public PersonResponse getPerson() {
		return person;
	}

	public void setPerson(PersonResponse person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", salary=" + salary + ", person=" + person + "]";
	}

}
