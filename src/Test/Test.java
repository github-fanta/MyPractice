package Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("d:\\nb.txt");
		FileWriter fw = new FileWriter("d:\\nbutf-8.txt");
		
		//int i =0;
		//while((i = fr.read()) != -1) {	//一次读一个字符
			//fw.write(i);
		
		
		int i1 = fr.read();
		int i2 = fr.read();
		int i3 = fr.read();
		int i4 = fr.read();
			System.out.println(Integer.toBinaryString(i1)+"("+(char)i1+")"+":"
			+Integer.toBinaryString(i2)+"("+(char)i2+")"+":"
			+Integer.toBinaryString(i3)+"("+(char)i3+")"+":"
			+Integer.toBinaryString(i4)+"("+(char)i4+")");
		//}
		
		fr.close();
		fw.close();
		//System.out.println("Hello".subSequence(0, 4));
	}
}
