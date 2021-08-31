package com.vti.entity;

public class Department {
	int id;
	String name;
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Department "+ this.id + " have name "+ this.name;
	}
}
