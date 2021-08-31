package Exception;

public class Programe2 {
	public static void main(String[] args) {
//		try {
//			float result = divide(7, 0);
//			System.out.println(result);
//		} catch (Exception e) {
//			System.out.println("Cann't devide 0");
//		}
//		finally {
//			System.out.println("divide completed");
//		}
		question3();
	}
	public static float divide(int a, int b) {
			return a/b;
	}
	
	public static void question3() {
		int[] numbers = {1,2,3};
		try {
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
			
}
