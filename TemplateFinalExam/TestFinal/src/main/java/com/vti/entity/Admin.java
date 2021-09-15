package com.vti.entity;

public class Admin extends User {
	private short ExpInYear;

	public Admin(short id, String fullName, String email, String passWord, Role role, short expInYear) {
		super(id, fullName, email, passWord, role);
		ExpInYear = expInYear;
	}

	public short getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(short expInYear) {
		ExpInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Admin [ExpInYear=" + ExpInYear + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord() + ", getRole()=" + getRole()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
