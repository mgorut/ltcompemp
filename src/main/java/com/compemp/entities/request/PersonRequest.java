package com.compemp.entities.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;	
	@JsonProperty("name")
	private String name;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("address")
	private String address;
	@JsonProperty("cellPhone")
	private String cellPhone;
	@JsonProperty("cityName")
	private String cityName;
	
	public PersonRequest() {}
	
	public PersonRequest(String name, String lastName, String address, String cellPhone, String cityName) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.cellPhone = cellPhone;
		this.cityName = cityName;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "PersonRequest [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address
				+ ", cellPhone=" + cellPhone + ", cityName=" + cityName + "]";
	}
	
}
