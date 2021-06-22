package com.compemp.entities.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonResponse implements Serializable {

	private static final long serialVersionUID = 1L;

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
		return "PersonResponse [name=" + name + ", lastName=" + lastName + ", address=" + address + ", cellPhone="
				+ cellPhone + ", cityName=" + cityName + "]";
	}

}
