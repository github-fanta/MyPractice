package Test;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Output extends Thread{

	private PipedOutputStream pos;
	public Output(PipedOutputStream pos) {
		this.pos = pos;
	}
	@Override
	public void run() {
		try {
			pos.write("来自管道流".getBytes());
			pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
