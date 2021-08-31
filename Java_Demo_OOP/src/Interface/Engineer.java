package Interface;

public class Engineer implements IPerson, IWorker{
	private String tringdo;
	private String chuyennganh;

	public Engineer(String tringdo, String chuyennganh) {
		this.tringdo = tringdo;
		this.chuyennganh = chuyennganh;
	}

	@Override
	public void an() {
		// TODO Auto-generated method stub
		System.out.println("Tôi đang ăn!");
	}

	@Override
	public void uong() {
		// TODO Auto-generated method stub
		System.out.println("Tôi đang uống!");
	}

	@Override
	public void ngu() {
		// TODO Auto-generated method stub
		System.out.println("Tôi đang ngủ!");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "trinh do: " +tringdo +"      chuyen nganh: " +chuyennganh;
	}

	@Override
	public void lamviec() {
		// TODO Auto-generated method stub
		System.out.println("Tôi đang làm việc!");
	}

	@Override
	public void nhanluong() {
		// TODO Auto-generated method stub
		System.out.println("Tôi đang nhận lương!");
	}

	@Override
	public void muasam() {
		// TODO Auto-generated method stub
		System.out.println("Tôi đang mua sắm!");
	}

	@Override
	public void hoc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cal(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
}
