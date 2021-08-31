package Backend;

import java.util.Scanner;

public class ScannerUtils {
	public static Scanner scanner = new Scanner(System.in);
	public static int inputInt(String erroMessage) {
		while(true) {
		try {
			System.out.print("Nhập vào số int: ");
			return Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.err.println(erroMessage);
		}
	}}
	
	public static float inputFloat(String erroMessage) {
		while(true) {
		try {
			System.out.print("Nhập vào số float: ");
			return Float.parseFloat(scanner.nextLine());
		} catch (Exception e) {
			System.err.println(erroMessage);
		}
	}}
	
	public static double inputDouble(String erroMessage) {
		while(true) {
		try {
			System.out.print("Nhập vào số double: ");
			return Double.parseDouble(scanner.nextLine());
		} catch (Exception e) {
			System.err.println(erroMessage);
		}
	}}
	
	public static String inputString() {
		while(true) {
		try {
			System.out.print("Nhập vào string: ");
			return scanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}}
}
