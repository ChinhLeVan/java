package com.vti.entity;

public class Admin extends User {

	private int ExpInYear;

	public Admin(int id, String fullName, String email, String password, int ExpInYear) {
		super(id, fullName, email, password, Role.ADMIN);
		this.ExpInYear = ExpInYear;
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	@Override
	public String toString() {
		return "Admin [ExpInYear=" + ExpInYear + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getRole()=" + getRole()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
