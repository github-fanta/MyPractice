package javaTest;

public class Basket {
	
	int[] basket = new int[10];
	int actualCount = 0;
	//put和get各自记住自己的放和取的位置。互不影响
	int inPos = 0;
	int outPos = 0;
	
	public synchronized void put(int num) {
		
		try {
			while(actualCount == basket.length) {
				this.wait();
			}
			Thread.sleep(1000);
			basket[inPos] = num;
			System.out.println("basket["+ (inPos++) +"]放入值"+ num);
			actualCount++;
			
			if (inPos == basket.length) {
				inPos = 0;
			}
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void get() {
		
		try {
			while(actualCount == 0) {
				this.wait();
			}
			Thread.sleep(1000);
			System.out.println("basket["+outPos+"]取出值"+ basket[outPos]);
			basket[outPos++] = 0;
			actualCount -- ;
			
			if (outPos == basket.length) {
				outPos = 0 ;
			}
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
