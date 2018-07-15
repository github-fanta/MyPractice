package Generic;

import java.util.ArrayList;


public class GenericTest {

	public static void main(String[] args) {
		/*ArrayList<? extends Number> list = new ArrayList<Number>();
		//Float float = new Float(2.3);
		//list.add(f);
		Integer integer = new Integer(1);
		//list.add(integer);

		Father father = new Father("father", 50);
		Child child = new Child("child", 22, "男");
		SubChild subChild = new SubChild("child", 22, "男", "America");
		*/
		
		/**
		 * 测试 上限<? extends Father>
		 */
		
		ArrayList<Child> arrList = new ArrayList<Child>();
		arrList.add(new Child("child1", 10, "男"));
		arrList.add(new Child("child2", 20, "男"));

		//list1是只读的
		ArrayList<? extends Father> list1 = arrList;
		
		Father father1 = list1.get(0); //只能读出上界类型
		System.out.println(father1);
		//Child child1 = list1.get(0); //不能读出子类型，因为不确定里面到底是哪种子类型
		
		//list1限制不能再往里写了，因为不知道里面具体是啥类型
		//list1.add(new Child("child3", 30, "男"));
		//list1.add(new Father("father", 50));
		
		/**
		 * 测试 下限<? super Child>
		 */
		
		
		/*ArrayList<Father> arrList = new ArrayList<Father>();
		arrList.add(new Father("father1", 10));
		arrList.add(new Father("father2", 20));
		arrList.add(new Child("child1", 10, "男"));
		Child child = new Child("child2", 20, "男");
		arrList.add(child);
		System.out.println(arrList.get(3).toString());*/
		//list2只能写,是无法读的
		/*ArrayList<? super Child> list2 = arrList;
		
		list2.add(new Child("child3", 30, "男"));
		list2.add(new Father("father3", 30));
		
		Father child2 = list2.get(0);
		list2.add(subChild);
		list2.add(child);
		list2.add(father);*/
	}
}
