package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.vti.entity.StudentEx2;

public class Exercise2 {
	public static Scanner scanner = new Scanner(System.in);
	private ArrayList<StudentEx2> listStudents = new ArrayList<>();
	public void menu() {
		while(true) {
		System.out.println("Mời chọn chức năng \n"
				+ "1: Thêm mới học sinh \n"
				+ "2: In ra học sinh sắp xếp theo name \n");
		int num = Integer.parseInt(scanner.nextLine());
		switch (num) {
		case 1: {
			insertNewStudent();
			break;
		}
		case 2: {
			printListStudents();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}
	}
	}
	public void insertNewStudent() {
		for (int i = 0; i < 5; i++) {
			@SuppressWarnings("deprecation")
			StudentEx2 studentEx2 = new StudentEx2(i, "Student "+ i, new Date(2021, 12, 3+i), (float)(3+i));
			listStudents.add(studentEx2);
		}
	}
	
	public void printListStudents() {
		Collections.sort(listStudents);
		for (StudentEx2 studentEx2 : listStudents) {
			System.out.println(studentEx2);
		}
	}

}
