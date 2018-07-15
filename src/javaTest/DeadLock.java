package javaTest;


/**
 * 这是一个死锁的演示
 * 一个中国人和一个美国人，分别占有自己的资源（锁，中国人占有筷子锁，美国人占有叉子锁）之后，还需要对方的资源。
 * 形成死锁
 * @author liq
 *
 */
public class DeadLock implements Runnable{

	static Object chopstics = new Object();
	static Object fork = new Object();
	
	private String name = null;
	
	public DeadLock(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		if (name == "China") {
			synchronized (chopstics) {
				System.out.println(Thread.currentThread().getName()+"已经拿到了筷子"+"正在拿叉子去");
				synchronized (fork) {
					System.out.println(Thread.currentThread().getName()+"两个到拿到！！！");	
				}
			}
		}else {
			synchronized (fork) {
				System.out.println(Thread.currentThread().getName()+"已经拿到叉子！,准备去拿筷子~");
				synchronized (chopstics) {
					System.out.println(Thread.currentThread().getName()+"都已经拿到！");
				}
			}
		}		
	}
	
}
