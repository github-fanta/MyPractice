package javaTest;

public class SellingTicket {

	public static void main(String args[]) {
		
		/*Task task= new Task();
		new Thread(task, "线程1").start();
		new Thread(task, "线程2").start();
		new Thread(task, "线程3").start();
		new Thread(task, "线程4").start();*/
		
		DeadLock deadLock1 = new DeadLock("China");
		DeadLock deadLock2 = new DeadLock("American");
		
		new Thread(deadLock1, "中国人").start();
		new Thread(deadLock2, "美国人").start();
	}
}
