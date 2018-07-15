package javaTest;

import java.util.HashMap;

class AA{
	public String ss = "sss";
}

public class Test {

	public static void main(String[] args) {
		AA aa = new AA();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("a", aa);
		System.out.println(map.get("a"));
		map.put("b", aa);
		System.out.println(map.get("a"));
		
		
	}
}
