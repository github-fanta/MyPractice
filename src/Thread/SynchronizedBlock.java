package Thread;

/**
 * synchronized代码块
 * @author liq
 *
 */
public class SynchronizedBlock {
	
	public static void main(String[] args) {
		Ticket ticketTask = new Ticket();
		new Thread(ticketTask,"售票窗口1").start();
		new Thread(ticketTask,"售票窗口2").start();
		new Thread(ticketTask,"售票窗口3").start();
		new Thread(ticketTask,"售票窗口4").start();
	}
	
}


class Ticket implements Runnable{

	private int ticketsNum = 10; //总共十张票
	Object lock = new Object();
	@Override
	public void run() {
		
		while(true) {
			synchronized (lock) {
				try {
					if (ticketsNum > 0) {
						System.out.println(Thread.currentThread().getName()+"售票，现存："+ --ticketsNum);
						Thread.sleep(1000);
					}else {
						System.out.println("票售完了！");
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
