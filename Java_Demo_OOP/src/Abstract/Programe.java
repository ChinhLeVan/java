package Abstract;

import Interface.Engineer;

public class Programe {
	public static void main(String[] args) {
//		StudentAbs studentAbs = new StudentAbs("Hoàng", 10, "Hà Nội", 10);
//		System.out.println(studentAbs.toString());
		
		StudentAbs engineer1 = new StudentAbs("A",12, "IT",14);
		engineer1.an();
	}
}
