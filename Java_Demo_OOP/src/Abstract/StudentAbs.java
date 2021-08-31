package Abstract;

public class StudentAbs extends AbstractPerson {
	
	private int diemToan;

	
	public StudentAbs(String name, int age, String adress, int diemToan) {
		super(name, age, adress);
		this.diemToan = diemToan;
	}

//	public void an() {
//		// TODO Auto-generated method stub
//		//System.out.println("học sinh đang ăn");
//	}

//	@Override
//	public void uong() {
//		// TODO Auto-generated method stub
//		System.out.println("học sinh đang uống");
//	}
//
//	@Override
//	public void ngu() {
//		// TODO Auto-generated method stub
//		System.out.println("học sinh đang uống");
//	}
//	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "     diem toán: " +diemToan ;
	}
}
