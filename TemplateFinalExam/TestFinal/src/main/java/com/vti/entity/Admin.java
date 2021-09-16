package com.vti.entity;

public class Admin extends User {
	private int ExpInYear;

	public Admin(int id, String fullName, String email, String passWord, Role role, int expInYear) {
		super(id, fullName, email, passWord, role);
		ExpInYear = expInYear;
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Admin [ExpInYear=" + ExpInYear + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord() + ", getRole()=" + getRole()
				+  "]";
	}
	
}
