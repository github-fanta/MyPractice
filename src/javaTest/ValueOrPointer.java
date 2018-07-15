package javaTest;

public class ValueOrPointer {
	
	public static void main(String args[]) {
		A a1 = new A();
		a1.a = 1;
		A a2 = new A();
		a2.a = 2;
		function(a1, a2);
		System.out.println("\n在main函数里面:\n"+a1+"值："+a1.a);
		
	}
	
	static void function(A a1, A a2) {
		System.out.println("在被调里面：\n引用改变之前：");
		System.out.println(a1+"值："+a1.a);
		
		a1.a = 3;
		System.out.println("改变形参引用后：");
		System.out.println(a1+"值："+a1.a);
	}
}
