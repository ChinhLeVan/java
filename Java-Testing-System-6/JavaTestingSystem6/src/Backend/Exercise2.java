package Backend;

import java.util.Scanner;

public class Exercise2 {
	private String[] department = {"Sales", "Security", "Manager"};
	public static Scanner scanner = new Scanner(System.in);

	public String getIndex(int index) {
		return department[index];
	}
	
	public void question4() {
		Exercise2 exercise2 = new Exercise2();	
		try {
			String deparmetNameString = exercise2.getIndex(2);
			System.err.println(deparmetNameString);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Can't find department");
		}
	}
	
	public static int inputAge(){
		while(true) {
		try {
			System.out.println("Nhap vao so tuoi...");
			int age = Integer.parseInt(scanner.nextLine());
			if (age < 0) {
				System.err.println("Wrong inputing! The age must be greater than 0, please input again");
			}else {
				return age;
			}
			
		} catch (NumberFormatException e) {
			System.err.println("wrong inputing!");
		} 

}
}
}
