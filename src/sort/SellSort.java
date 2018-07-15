package sort;

public class SellSort {
	
	public static void main(String args[]) {
		
		int[] data = {34,2,-9,9,9,11,4,7};
		sort(data);
		for (int i : data) {
			System.out.print(i+" ");
		}
	}

	private static void sort(int[] data) {

		int d = data.length/2;//步长
		while(d>=1) {
			
			for (int i = d; i < data.length; i++) { //相当于从每一组的第二个元素开始排起
				int temp = data[i];
				//加入这个新节点后，在同一步长下，保证一组元素有序
				int j = i-d;
				while(j>=0 && temp < data[j]) {
					data[j+d] = data[j]; //值后移
					j = j-d;//指针前移
				}
				data[j+d] = temp;
			}
			
			d = d/2;
		}
	}
	
	
	public static void sort2(int[] data) {
		int d = data.length/2;
		while(d>=1) {
			for(int i=d; i< data.length; i++) {
				int temp = data[i];
				int j = i-d;
				while(j>=0 && temp < data[j]) {
					data[j+d] = data[j];
					j = j-d;
				}
				data[j+d] = temp;
			}
				
			d = d/2;
		}
	}	 
	
}
