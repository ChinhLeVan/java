package com.vti.entity;

public class StudentEx3 <T>{
	private T id;
	private String name;
	
	
	public StudentEx3(T id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student " + (T) this.id + " has name is "+ this.name;
	}
}
