package Test;

public class Child extends Father {
	public static String name = "child";
	static {
		System.out.println("子类被初始化");
	}
}
