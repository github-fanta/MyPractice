package Thread;

public class SynchronizedMethod {

	public static void main(String[] args) {
		TicketTask ticketTask = new TicketTask();
		new Thread(ticketTask,"售票口1").start();
		new Thread(ticketTask,"售票口2").start();
		new Thread(ticketTask,"售票口3").start();
		new Thread(ticketTask,"售票口4").start();
	}
}

class TicketTask implements Runnable{

	private int ticketsNum = 50;
	@Override
	public  void run() {
			try {
				for(;;) {
					if (ticketsNum <= 0) {
						break;
					}
					sellTicket();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	private synchronized void sellTicket() throws InterruptedException {
		
		if (ticketsNum > 0) {
			System.out.println(Thread.currentThread().getName()+"售票，现存："+ --ticketsNum);
			Thread.sleep(300);
		}else {
			System.out.println("票已售完！");
		}
	}
	
}
