package Generic;

public class Child extends Father{
	
	String sex;
	
	public Child(String name, int age, String sex) {
		super(name, age);
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Child [sex=" + sex +", name=" + super.name + ", age=" + super.age +"]";
	}
	
	
}
