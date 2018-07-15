package javaTest;

public class GetAndPutTest {

	public static void main(String args[]) {
		
		Basket basket = new Basket();
		Put put = new Put(basket);
		Get get = new Get(basket);
		
		new Thread(put).start();
		new Thread(get).start();
	}
}
