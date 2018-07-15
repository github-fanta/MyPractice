package Thread;

/**
 * 线程让步
 * @author liq
 *
 */
public class YeildThread extends Thread{
	
	public YeildThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+"-----is running");
				if (this.getName().equals("A线程") && (i%3 == 0)) {
					System.out.println("A线程让步-------------");
					Thread.yield();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		YeildThread threadA = new YeildThread("A线程");
		YeildThread threadB = new YeildThread("B线程");
		threadA.start();
		threadB.start();
	} 
}
