package Thread;

/**
 * 线程插队
 * @author liq
 *
 */
public class JoinThread extends Thread{

	public JoinThread(String name) {
		super();
	}
	
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("我是插队线程~~~~~~~很讨厌吧~~~~~~~你能把我怎么样~~~~~慢慢等着吧~~~~~嘿嘿嘿~~~");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		JoinThread joinThread = new JoinThread("插队线程");
		//joinThread.start();
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("main thread is running");
				if (i == 5) {
					System.out.println("插队线程插队-------------------------------------------");
					joinThread.start();
					joinThread.join();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
