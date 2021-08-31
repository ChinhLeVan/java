package Entity;

import java.util.Scanner;

public class test {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

				System.out.println("Nhap vao so tuoi...");
				int age = Integer.parseInt(scanner.nextLine());
//				if (age < 0) {
//					throw new Exception("Wrong inputing! The age must be greater \r\n" + 
//										"than 0, please input again");
//				}else {
//					return age;
//				}
				System.out.println(age);
		}
	}
