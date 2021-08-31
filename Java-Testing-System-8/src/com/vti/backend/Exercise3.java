package com.vti.backend;


import java.util.Scanner;

import com.vti.entity.EmployeeEx3;
import com.vti.entity.MyMap;
import com.vti.entity.StudentEx3;

public class Exercise3 {
	
	//==================================QUESTION 1==============================
	public void question1_2_3() {
		StudentEx3<Integer> student1 = new StudentEx3<Integer>(1, "strudent int");
		System.out.println(student1.toString());
		StudentEx3<Float> student2 = new StudentEx3<Float>(2.0f, "strudent float");
		System.out.println(student2.toString());
		StudentEx3<Double> student3 = new StudentEx3<Double>(3.0, "strudent double");
		System.out.println(student3.toString());	
	}

	//===================================QUESTION 2==============================
	public <T> void printGeneric(T var) {
		System.out.println("Print by T type:  " + var);
	}
	
	public void question2() {
		StudentEx3<Integer> student1 = new StudentEx3<Integer>(1, "strudent int");
		printGeneric(student1);
	}
	//===================================QUESTION 4==============================
	public <T> void printArrWithTType(T[] var) {
		System.out.println("Cac phan tu trong mang");
		for (T t : var) {
			System.out.println(t);
		}
	}
	
	public void question4() {
		Integer[] arrInt = {1,2,3,4,5,6};
		String[] arrString = {"a","b","c","d","e"};
		Float[] arrFloat = {1.0f, 2.4f, 4.3f, 2.6f, 2.0f};
		Double[] arrDouble = {1.2, 1.3, 2.4, 5.4, 6.5};
		
		printArrWithTType(arrInt);
		printArrWithTType(arrString);
		printArrWithTType(arrFloat);
		printArrWithTType(arrDouble);
	}
	
	//====================================QUESTION 5===============================
	public static Scanner scanner = new Scanner(System.in);
	public void menuQuestion5() {
		while(true) {
		System.out.println("Chon chuc nang ban muon... \n" 
							+"1: Demo voi salaris la int \n"
							+"2: Demo voi salaris la float \n"
							+"3: Demo voi salaris la double \n"
							+"4: Exit");
		
		int num = Integer.parseInt(scanner.nextLine());
		switch (num) {
		case 1: {
			printWithInt();
			break;
		}
		case 2: {
			printWithFloat();
			break;
		}
		case 3: {
			printWithDouble();
			break;
		}
		case 4: {
			System.exit(1);
			break;
		}
		default:
			System.out.println("Ban da chon sai chuc nang. Vui long chon lai....");
			break;
		}}
		
	}

	private void printWithInt() {
		Integer[] salaris = {20,21,23,25,30,29,40,80};
		EmployeeEx3<Integer> employeeInt = new EmployeeEx3<Integer>("Employee Int", salaris);
		employeeInt.printSalari();
		employeeInt.printLastSalari();
		
	}

	private void printWithFloat() {
		Float[] salaris = {20.3f, 21.0f, 23.3f, 25.1f ,30.0f ,29.8f ,40.2f,80.0f};
		EmployeeEx3<Float> employeeInt = new EmployeeEx3<Float>("Employee Float", salaris);
		employeeInt.printSalari();
		employeeInt.printLastSalari();
	}

	private void printWithDouble() {
		Double[] salaris = {20.3, 21.0, 23.3, 25.1 ,30.0 ,29.8 ,40.2,80.0};
		EmployeeEx3<Double> employeeInt = new EmployeeEx3<Double>("Employee Double", salaris);
		employeeInt.printSalari();
		employeeInt.printLastSalari();
	}
	
	//===============================QUESTION 6 K&V generic===============================
	public void question6() {
		MyMap<Integer , String> strudentKV = new MyMap<Integer, String>(1, "StudentKV1");
		while(true) {
			System.out.println("Chon chuc nang muon su dung \n"
								+ "1: in thong tin Student \n"
								+ "2: Get key student \n"
								+ "3: Get value student \n"
								+ "4: Exit");
			
			int num = Integer.parseInt(scanner.nextLine());
			switch (num) {
			case 1: {
				System.out.println(strudentKV.toString());
				break;
			}
			case 2: {
				System.out.println(strudentKV.getKey());
				break;
			}
			case 3: {
				System.out.println(strudentKV.getValue());
				break;
			}
			case 4: {
				System.exit(1);
				break;
			}
			default:
				System.out.println("Ban chon sai chuc nang. Chon lai");
			}
		}
	}
	
}
