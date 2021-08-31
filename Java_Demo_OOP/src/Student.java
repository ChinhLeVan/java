
public class Student extends Person {
	private float diem_toan;
	private float diem_ly;
	
	
	public Student(String name, int age, String adress, float diem_toan, float diem_ly) {
		super(name, age, adress);
		this.diem_toan = diem_toan;
		this.diem_ly = diem_ly;
	}

	public void hoc() {
		System.out.println("Tôi đang học");
	}
	
	public int cal(int a, int b) {
		return a+b;
	}
	
	public double cal(double a, double b) {
		return a+b;
	}
	
	public float cal(float a, float b) {
		return a+b;
	}
	
	@Override
	public void an() {
		super.an();
		System.out.println("Tôi đang ăn cơm");
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "     diem toán: " +diem_toan + "    diem ly: " +diem_ly;
	}
}

