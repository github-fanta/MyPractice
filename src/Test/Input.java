package Test;

import java.io.IOException;
import java.io.PipedInputStream;

public class Input extends Thread{

	private PipedInputStream pis;
	public Input(PipedInputStream pis) {
		this.pis = pis;
	}
	
	@Override
	public void run() {
		byte[] b = new byte[1024];
		int len = 0;
		try {
			len = pis.read(b);
			System.out.println(new String(b,0,len));
			pis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
