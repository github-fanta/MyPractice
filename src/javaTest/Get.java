package javaTest;

public class Get implements Runnable{

	Basket basket = new Basket();
	public Get(Basket bs) {
		this.basket = bs; 
	}
	@Override
	public void run() {

		while(true) {
			basket.get();
		}
	}

}
