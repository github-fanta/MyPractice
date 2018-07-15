package heap;

import java.util.Scanner;

public class Test {

	public static void main(String args[]) {
		
/*		Heap heap = new Heap();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要排序的个数：");
		String input = scanner.next();
		int total = Integer.parseInt(input);
		heap.heapSize = total;
		for(int i=1; i<=total; i++) {
			System.out.println("请输入一个整数：");
			heap.heap[i] = Integer.parseInt(scanner.next());
			System.out.println("第"+i+"个整数："+heap.heap[i]);
		}
		scanner.close();
		heap.create();
		System.out.println("排序后：");
		for(int i=0; i<total; i++) {
			System.out.println(heap.getTop());
		}*/
		
		BigHeap heap = new BigHeap();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要排序的个数：");
		String input = scanner.next();
		int total = Integer.parseInt(input);
		heap.heapSize = total;
		for(int i=1; i<=total; i++) {
			System.out.println("请输入一个整数：");
			heap.heap[i] = Integer.parseInt(scanner.next());
			System.out.println("第"+i+"个整数："+heap.heap[i]);
		}
		scanner.close();
		heap.create();
		System.out.println("排序后：");
		for(int i=0; i<total; i++) {
			System.out.print(heap.getTop()+" ");
		}
		
	}
}
