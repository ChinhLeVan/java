package com.vti.entity;

public class Employee extends User {
	private String proSkill;

	public Employee(short id, String fullName, String email, String passWord, Role role, String proSkill) {
		super(id, fullName, email, passWord, role);
		this.proSkill = proSkill;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [proSkill=" + proSkill + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord() + ", getRole()=" + getRole()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}	
}
