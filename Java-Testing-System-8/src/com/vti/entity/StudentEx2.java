package com.vti.entity;

import java.util.Date;

public class StudentEx2 implements Comparable<StudentEx2> {
	private int id;
	private String name;
	private Date birthday;
	private float score;
	
	public StudentEx2(int id, String name, Date date , float score) {
		this.id = id;
		this.name = name;
		this.birthday = date;
		this.score = score;
	}

	@Override
	public int compareTo(StudentEx2 student) {
		if(student.name.compareTo(name) >0) {
			return 1;
		}else if(student.name.compareTo(name) <0) {
			return -1;
		}else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + id + "        NAME: "+ name + "        SCORE:" + score;
	}
}
