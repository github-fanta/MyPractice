package Thread;

/**
 * This demon shows the co-operation between two threads Input and Output
 * @author liq
 *
 */
public class WaitAndNotify {

	public static void main(String[] args) {
		Storage storage = new Storage();
		Input input = new Input(storage);
		Output output = new Output(storage);
		new Thread(input,"input线程").start();
		new Thread(output,"output线程").start();
	}
	
}

//this is Input thread which is used to play a producer role to put a number in storage per second  
class Input implements Runnable{

	Storage storage;
	int num;
	
	public Input(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				storage.put(num++);
				System.out.println("producer puts num:"+num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//this is Output thread which is used to play a consumer role to get a number in storage per second  
class Output implements Runnable{

	Storage storage;
	
	public Output(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println("------------------------consumer gets num:"+storage.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//this is a mutual storage of consumer and producer thread to storage number
class Storage{

	private int[] cells = new int[10];
	int size = 0; //实际存储容量
	int inPos,outPos;
	
	//往cells中放入一个数
	public synchronized void put(int in) {
		try {
				if (size == 10) {
					this.wait();
				}
				cells[inPos++] = in;
				size++;
				//超过10位置重新从0开始存放
				if (inPos == 10) {
					inPos=0;
				}
				this.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	//从cells中取出一个数
	public synchronized int get() {
		int result = 0;
		try {
				//Storage 为空了，线程等待
				if (size == 0) {
					this.wait();
				}
				
				result = cells[outPos++];
				size--;
				//超过大小，从0开始取出
				if (outPos == 10) {
					outPos = 0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return result;
		}
		
	}