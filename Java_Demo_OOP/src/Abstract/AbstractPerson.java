package Abstract;

public abstract class AbstractPerson {
	private String name ; 
	private int age;
	private String adress ;
	
	public AbstractPerson(String name, int age, String adress) {
		this.name = name;
		this.age = age;
		this.adress = adress;
	}

	public void an() {
		System.out.println("haha");
	};	
	//public abstract void uong();	
	//public abstract void ngu();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: " +name + "     age: " +age + "      adress: " +adress;
	}
}
 