package javaTest;
public class Put implements Runnable{

	Basket basket = null;
	int num = 0;
	
	public Put(Basket bs) {
		basket = bs;
	}
	@Override
	public void run() {
		while(true) {
			basket.put(num++);
		}
	}
	
}
