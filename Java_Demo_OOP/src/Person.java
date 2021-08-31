
public class Person {
	private String name ;
	private int age;
	private String adress ;
	
	public Person() {
		this.name = "tùng";
		this.age = 16;
		this.adress = "33 duy tan";
	}
	
	public Person(String name, int age, String adress) {
		this.name = name;
		this.age = age;
		this.adress = adress;
	}

	
	public void an() {
		System.out.println("Tôi đang ăn!");
	}
	
	public void uong() {
		System.out.println("Tôi đang uống!");
	}
	
	public void ngu() {
		System.out.println("Tôi đang ngủ!");
	}
	
	public int name() {
		return 10;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: " +name + "     age: " +age + "      adress: " +adress;
	}
	
}
