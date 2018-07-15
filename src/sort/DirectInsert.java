package sort;

public class DirectInsert {
	
	/**
	 * 直接插入排序
	 * 稳定的排序方法
	 * @param args
	 */
	public static void main(String args[]) {
		
		int[] data = {34,2,-9,9,9,11,4,7};
		sort2(data);
		for (int p : data) {
			System.out.print(p+" ");
		}
	}
	
	static void sort(int[] data) {
		int temp = 0;
		int j = 0;
		int i = 0;
		
		//直接插入排序，假定前面的范围从1开始
		for (i=1; i<data.length; i++) {
			temp = data[i]; //先保存此位置的值
			
			//找temp应该在的位置
			j = i-1;
			while(j > -1 && temp < data[j]) {
				data[j+1] = data[j]; //后移
				j--; //指针前移
			}
			data[j+1] = temp;//放入应在的位置
		}
	}
	
	static void sort2(int[] data) {
		int temp = 0;
		int j = 0;
		//直接插入排序，假定前面的范围从1开始
		for (int i=1; i<data.length; i++) {
			temp = data[i]; //先保存此位置的值
			
			//找temp应该在的位置
			for(j = i-1; j>=0 && temp < data[j]; j--) {
				data[j+1] = data[j]; //后移
			}
			data[j+1] = temp;//放入应在的位置
		}
	}
}
