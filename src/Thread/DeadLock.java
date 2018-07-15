package Thread;

/**
 * 模拟死锁问题
 * 两个美国人 America1 和 America2。当一个人同时拥有knife 和  fork的时候才能吃饭
 * 给 America1 刀子，让他渴望（desire）有叉子
 * 给America2 叉子，让他渴望有刀子
 * @author liq
 *
 */
public class DeadLock {

	public static void main(String[] args) {
		EatTask eatTask = new EatTask();
		new Thread(eatTask,"America1").start();
		new Thread(eatTask,"America2").start();
	}
}

class EatTask implements Runnable{

	private Object knife = "knife";
	private Object fork = "fork";
	
	@Override
	public void run() {
		if ("America1".equals(Thread.currentThread().getName())) {
			eatFood(knife, fork); //给第一个人knife，同时渴望拥有fork
		}else {
			eatFood(fork, knife); //给第二个人fork，同时渴望拥有knife
		}
		
	}
	
	private void eatFood(Object own, Object desire){
		while(true) {
			synchronized (own) {
				System.out.println("Thread.currentThread().getName()-----own "+own+" desire "+desire);
				synchronized (desire) {
					System.out.println(Thread.currentThread().getName()+"is eating");
				}
			}
		}
	}
	
}