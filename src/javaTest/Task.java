package javaTest;

public class Task implements Runnable{

	private int tickets  = 10000;
	Object lock = new Object();
	
	@Override
	public void run() {
		
			while(tickets > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
		
					e.printStackTrace();
				}
				sell();
			}
	}
	
	
	public synchronized void sell() {
		if (tickets > 0) {
			System.out.println(Thread.currentThread().getName()+"售出第"+ tickets-- +"张票");
		}
	}

}
