package Thread;
/**
 * 后台线程
 * @author liq
 *
 */
public class DamonThread {
	
	class Damon implements Runnable{

		@Override
		public void run() {
			while(true) {
				try {
				Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+" is running");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Damon damon = new DamonThread().new Damon();
		Thread damonThread = new Thread(damon, "后台线程");
		//damonThread.setPriority(10);
		damonThread.setDaemon(true);
		System.out.println("'damonThread' is a Damon Thread?"+damonThread.isDaemon());
		damonThread.start();
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Main Thrad is Running"+i);
				if (i == 9) {
					System.out.println("Main Thrad is dead");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
