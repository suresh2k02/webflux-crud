package com.webflux.demowebflux.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Employee {

    @Id
    private Long id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String name;
    private String address;
}
