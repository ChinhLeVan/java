package com.vti.entity;

public class EmployeeEx3<E> {
	private int id;
	private String name;
	private E[] salaris;
	private int COUNT = 0;
	
	public EmployeeEx3(String name, E[] salaris) {
		this.id = ++COUNT;
		this.name = name;
		this.salaris = salaris;
		COUNT++;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee "+this.id+";    co ten: "+this.name+";    co luong cac thang: " + salaris.toString();
	}
	
	public void printSalari() {
		System.out.println("Employee "+this.id+";    co ten: "+this.name+"\nCo luong cac thang: ");
		for (int i = 0; i < salaris.length; i++) {
			System.out.println(salaris[i]);
		}
	}
	
	public void printLastSalari() {
		System.out.println("Employee "+this.id+ ";    co ten: "+this.name
				+ ";    co luong thang cuoi cung la: " +salaris[salaris.length-1]);
	}

}
